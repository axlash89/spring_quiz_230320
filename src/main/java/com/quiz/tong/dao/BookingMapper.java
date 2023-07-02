package com.quiz.tong.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.tong.domain.Booking;

@Repository
public interface BookingMapper {

	public List<Booking> selectBookingList();
	
	public void insertBooking(
			@Param("name") String name, 
			@Param("date") Date date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public Booking selectBookingByNameAndPhone(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
	public int deleteBookingById(int id);
	
}
