package com.quiz.baemin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.baemin.bo.BaeminBO;
import com.quiz.baemin.bo.ReviewBO;
import com.quiz.baemin.domain.Baemin;
import com.quiz.baemin.domain.Review;

@RequestMapping("/baemin")
@Controller
public class BaeminController {
	
	@Autowired
	private BaeminBO baeminBO;
	
	@Autowired
	private ReviewBO reviewBO;
	
	@GetMapping("/storeList")
	public String storeList(Model model) {
		
		List<Baemin> baeminList = baeminBO.getBaeminList();
		
		model.addAttribute("baeminList", baeminList);
		
		return "baemin/storeList";
	}
	
	@GetMapping("/reviews")
	public String reviews(
			@RequestParam("storeId") int storeId,
			@RequestParam("storeName") String storeName,
			Model model) {
		
		List<Review> reviews = reviewBO.getReviewsById(storeId);
		
		model.addAttribute("reviews", reviews);
		model.addAttribute("storeName", storeName);
		
		return "baemin/reviews";
	}
	
}
