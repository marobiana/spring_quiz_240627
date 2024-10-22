package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	// input: X
	// output: List<Booking>
	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public void insertBooking(
			@Param("name") String name,
			@Param("date") LocalDate date,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber);
	
	// input: name, phoneNumber   => map
	// output: List<Booking>
	public List<Booking> selectBookingListByNamePhoneNumber(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
}





