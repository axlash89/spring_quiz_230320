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
	
	public void addBooking(String name, Date date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	public Booking checkBookingByNameAndPhone(String name, String phoneNumber) {
		return bookingMapper.selectBookingByNameAndPhone(name, phoneNumber);
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
}
