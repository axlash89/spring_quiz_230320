package com.quiz.tong;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.tong.bo.BookingBO;
import com.quiz.tong.domain.Booking;

@RequestMapping("/tong")
@Controller
public class TongController {
	
	@Autowired
	private BookingBO bookingBO;

	@GetMapping("/main_view")
	public String mainView() {
		return "tong/main";
	}
	
	@GetMapping("/main_new_reservation_view")
	public String mainNewReservation() {
		return "tong/mainNewReservation";
	}
	
	@GetMapping("/main_reservation_list_view")
	public String mainReservationList(Model model) {		
		List<Booking> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);  // 모델로 할 때는 날짜 제대로 나옴.
		
		return "tong/mainReservationList";
	}
	
	// 예약 항목 추가
	// AJAX가 하는 요청
	@PostMapping("/make_a_reservation")
	@ResponseBody
	public Map<String, Object> addReservation(
			@RequestParam("name") String name,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,  // @RequestParam("date") String date, 이렇게 받아올 수도 있음.
			@RequestParam("day") int day,
			@RequestParam("headcount")int headcount,
			@RequestParam("phoneNumber")String phoneNumber) {
		
		// insert DB
		int row = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "예약 실패");
		}
		
		return result;
		
	}
	
	// AJAX가 하는 요청
	// 예약 내역 조회
	@PostMapping("/check_a_reservation")
	@ResponseBody
	public Map<String, Object> checkReservation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// Model로 내려가는 경우는 ResponseBody가 없을 때,, jsp로 return할 때나 의미가 있는 것임.
		
		Booking booking = bookingBO.getBookingByNameAndPhone(name, phoneNumber);
		
		// 잭슨 라이브러리로 내릴 때는 날짜에 문제가 있다.
		
		/* 1) 일반 통신일 때는 문제가 없다.		 
		MySql에서 timestamp 타입으로 저장한 Date에 대해서 
		데이터를 조회해서 Model에 담아 내려주면 우리나라 시간으로 정상적으로 나온다.

		2) AJAX 통신일 때 UTC 시간으로 응답이 내려온다.
		MySql에서 timestamp 타입으로 저장한 Date에 대해서 
		데이터를 조회하고 @ResponseBody 어노테이션을 통해 Jackson 라이브러리로 date를 담아서 JSON으로 내리면
		UTC 시간으로 나오는 현상이 발생한다.
		이유는 Jackson 라이브러리에서 타임존을 맞춰주지 않았기 때문이다.
		application.properties 또는 yml 설정을 통해 Jackson의 타임존을 아래와 같이 맞춰주어야 한다. 
		
		spring.jackson.deserialization.adjust-dates-to-context-time-zone=false
		spring.jackson.time-zone=Asia/Seoul */
		
		Map<String, Object> result = new HashMap<>();
		if(booking != null) {
			result.put("code", 1);
			result.put("booking", booking);
		} else {
			result.put("code", 300);
			result.put("errorMessage", "예약 내역이 없습니다.");
		}
		
		return result;
		
	}
	
	// AJAX가 하는 요청
	@DeleteMapping("/reservation_delete")
	@ResponseBody
	public Map<String, Object> deleteReservation(
			@RequestParam("id") int id) {
		
		int row = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "삭제할 데이터가 없습니다.");
		}
		
		return result;		
		
	}
	
}
