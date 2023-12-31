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
		CompanyEntity company = companyBO.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		return company;
		
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
		CompanyEntity company = companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
		return company;
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		CompanyEntity company = companyBO.updateScaleAndHeadcountById(12, "중소기업", 32);
		return company;
	}
	
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteCompanyById(7);		
		return "삭제 완료";
	}
	
}
