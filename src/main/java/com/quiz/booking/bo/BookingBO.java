package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// input: id
	// output: int(성공한 행 개수)
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(
			String name,
			LocalDate date,
			int day,
			int headcount,
			String phoneNumber) {
		
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input: name, phoneNumber
	// output: Booking(최신 1개) or null
	public Booking getLatestBookingByNamePhoneNumber(
			String name, String phoneNumber) {
		
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
		// [1, 2, 3] or [1]
		// []
		
//		if (bookingList.isEmpty()) {
//			return null;
//		}
//		
//		return bookingList.get(bookingList.size() - 1); // 마지막칸: 요소 개수-1
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
	
}




