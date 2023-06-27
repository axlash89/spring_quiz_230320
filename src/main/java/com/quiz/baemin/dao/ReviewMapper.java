package com.quiz.baemin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.baemin.domain.Review;

@Repository
public interface ReviewMapper {

	public List<Review> selectReviewsById(int storeId);
	
}
