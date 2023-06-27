package com.quiz.baemin.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.baemin.dao.ReviewMapper;
import com.quiz.baemin.domain.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	public List<Review> getReviewsById(int storeId) {
		return reviewMapper.selectReviewsById(storeId);
	}

}
