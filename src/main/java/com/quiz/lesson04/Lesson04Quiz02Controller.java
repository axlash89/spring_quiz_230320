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
	
	// 추가 페이지
	@GetMapping("/add_realtor_view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 결과 페이지
	@PostMapping("/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,  // @ModelAttribute 생략 가능
			Model model) {
		
		// db insert
		realtorBO.addRealtor(realtor);
		
		// db select by id
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		
		// model 담기
		model.addAttribute("result", latestRealtor);
		
		// 결과 페이지로 이동
		return "lesson04/afterAddRealtor";
		
	}
	
}
