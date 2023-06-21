package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	@RequestMapping(path = "/add_seller_view", method = RequestMethod.GET)
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 추가 action
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam(value = "temperature", required = false) Double temperature) {
		// db insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 입력 성공 페이지
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 정보 페이지
	@GetMapping("/seller_info")
	public String sellerInfo(Model model) {
		// 최근 가입자 db select
		Seller seller = sellerBO.getLatestSeller();
		model.addAttribute("seller", seller);		
		return "lesson04/getLatestSeller";
	}
	
	@GetMapping("/seller_info_by_id")
	public String sellerInfoById(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		model.addAttribute("seller", seller);
		return "lesson04/getLatestSeller";
	}
	
}