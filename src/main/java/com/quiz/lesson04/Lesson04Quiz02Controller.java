package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;

	// 공인중개사 추가 화면
	// /lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 공인중개사 추가 => 최신 가입자 화면
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		// db insert
		realtorBO.addRealtor(realtor);
		
		// db select
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		
		// Model 담기
		model.addAttribute("realtor", latestRealtor);
		
		// view로 이동
		return "lesson04/afterAddRealtor";
	}
}
