package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 추가 화면
	// /lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 추가 기능 => AJAX 호출
	// @ResponseBody가 사용되면 Model을 쓸 수 없다.
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB Insert
		bookmarkBO.addBookmark(name, url);
		
		// 성공 여부 JSON String
		// "{"code":200, "result":"성공"}"
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; 
	}
	
	// 즐겨찾기 목록 화면
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView(Model model) {
		// db select => List
		List<Bookmark> bookmarkList = bookmarkBO.selectBookmarkList();
		
		// Model에 담기
		model.addAttribute("bookmarkList", bookmarkList);
		
		// view 화면 이동
		return "lesson06/bookmarkList";
	}
}




