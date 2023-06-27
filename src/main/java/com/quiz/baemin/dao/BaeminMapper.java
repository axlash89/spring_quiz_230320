package com.quiz.baemin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.baemin.domain.Baemin;

@Repository
public interface BaeminMapper {

	public List<Baemin> selectBaeminList();
	
}
