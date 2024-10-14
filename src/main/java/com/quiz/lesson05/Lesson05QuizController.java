package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05QuizController {

	@GetMapping("/quiz01")
	public String quiz01() {
		return "lesson05/quiz01";
	}
}
