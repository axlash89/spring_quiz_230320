package com.quiz.tong.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.tong.dao.BookingMapper;
import com.quiz.tong.domain.Booking;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;

	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public int addBooking(String name, Date date, int day, int headcount, String phoneNumber) {
		return bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	public Booking getBookingByNameAndPhone(String name, String phoneNumber) {
		
		// 가능한 값 : [], [booking], [booking A, booking B,...]
		List<Booking> bookingList = bookingMapper.selectBookingByNameAndPhone(name, phoneNumber);
		if (bookingList.isEmpty()) {
			return null;
		}
		return bookingList.get(bookingList.size() - 1);  // 마지막 값을 준다. (최신 예약)
		
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
}
