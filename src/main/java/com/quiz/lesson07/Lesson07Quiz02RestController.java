package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.dao.RecruitRepository;
import com.quiz.lesson07.entity.RecruitEntity;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	

	@GetMapping("/1")
	public RecruitEntity getRecruit() {
		return recruitRepository.findById(5).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> getRecruitByCompanyId() {
		return recruitRepository.findAllByCompanyId(1);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> getRecruitByPositionAndType() {
		return recruitRepository.findAllByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> getRecruitByTypeOrSalary() {
		return recruitRepository.findAllByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> getRecruitByTypeAndSalaryLimit() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> getRecruitByRegionAndSalary() {
		return recruitRepository.findAllByRegionAndSalaryGreaterThanEqualAndSalaryLessThanEqual("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	public List<RecruitEntity> getRecruitByDeadlineAndSalaryAndType() {
		return recruitRepository.findByDeadlineAndSalaryAndType("2026-04-10", 8100, "정규직");
	}
	
}
