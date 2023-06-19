package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RequestMapping("/lesson03/quiz03")
@RestController
public class Lesson03Quiz03RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/1")
	public String quiz03(
			@RequestParam("id") int id,
			@RequestParam("type") String type,
			@RequestParam("price") int price) {
		
		int row = realEstateBO.updateTypePriceById(id, type, price);
		return "수정 성공 : " + row;
		
	}
	
}
