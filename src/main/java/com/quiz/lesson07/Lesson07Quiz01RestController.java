package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {

	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/save1")
	public CompanyEntity save1() {
//		회사명 : 넥손
//		사업내용 : 컨텐츠 게임
//		규모 : 대기업
//		사원수 : 3585명
		return companyBO.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
//		회사명 : 버블팡
//		사업내용 : 여신 금융업
//		규모 : 대기업
//		사원수 : 6834명
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}
	
	// /lesson07/quiz01/update
	@GetMapping("/update")
	public CompanyEntity update() {
		// id가 8번인 버블팡 중소기업, 사원수를 34명
		return companyBO.updateCompanyById(8, "중소기업", 34);
	}
	
	// /lesson07/quiz01/delete
	@GetMapping("/delete")
	public String delete() {
		// id가 8번 회사 삭제
		companyBO.deleteCompanyById(8);
		return "삭제 성공";
	}
}
