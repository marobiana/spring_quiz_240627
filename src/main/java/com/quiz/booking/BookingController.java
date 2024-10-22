package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;

	// 1)
	// 예약 목록 화면
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		// db select
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model에 담기
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// delete booking - AJAX 요청
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		// 응답값 => JSON
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 대상이 없습니다.");
		}
		return result;
	}
	
	// 2)
	// 예약하기 화면
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// 예약하기 insert - AJAX 요청
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date, // yyyy-MM-dd
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답 JSON
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	// 3)
	// 예약 조회 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// 예약 조회 - AJAX 요청
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB select
		Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);
		
		// 결과값 => Map에 담아 JSON (Model 사용 X)
		// {"code":200, }
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		
		return result;
	}
}




