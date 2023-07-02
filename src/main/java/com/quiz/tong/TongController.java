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
	
	@GetMapping("/main_new_reservation")
	public String mainNewReservation() {
		return "tong/mainNewReservation";
	}
	
	@GetMapping("/main_reservation_list")
	public String mainReservationList(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "tong/mainReservationList";
	}
	
	@PostMapping("/make_a_reservation")
	@ResponseBody
	public Map<String, Object> addReservation(
			@RequestParam("name") String name,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("day") int day,
			@RequestParam("headcount")int headcount,
			@RequestParam("phoneNumber")String phoneNumber) {
		
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		
		return result;
	}
	
	@PostMapping("/check_a_reservation")
	@ResponseBody
	public Map<String, Object> checkReservation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		Booking booking = bookingBO.checkBookingByNameAndPhone(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if(booking != null) {
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
			String convertedDate = format.format(booking.getDate());
			result.put("code", 1);
			result.put("name", booking.getName());
			result.put("date", convertedDate);
			result.put("day", booking.getDay());
			result.put("headcount", booking.getHeadcount());
			result.put("state", booking.getState());
		} else {
			result.put("code", 500);
			result.put("errorMessage", "예약 내역이 없습니다.");
		}
		
		return result;
	}
	
	@DeleteMapping("/reservation_delete")
	@ResponseBody
	public Map<String, Object> deleteReservation(
			@RequestParam("id") int id) {
		
		int row = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (row == 1) {
			result.put("code", 1);
		} else {
			result.put("code", 500);
			result.put("errorMessage", "삭제할 데이터가 없습니다.");
		}
		
		return result;		
	}
	
}
