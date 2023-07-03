package com.quiz.tong.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.tong.domain.Booking;

@Repository
public interface BookingMapper {

	public List<Booking> selectBookingList();
	
	public int insertBooking(
			@Param("name") String name, 
			@Param("date") Date date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public List<Booking> selectBookingByNameAndPhone(  // 셀렉트를 했을 때 중복이 되면 두개가 리턴될 수도 있는 상황임.
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
	
	public int deleteBookingById(int id);
	
}
