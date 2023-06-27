package com.quiz.baemin.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.baemin.dao.BaeminMapper;
import com.quiz.baemin.domain.Baemin;

@Service
public class BaeminBO {

	@Autowired
	private BaeminMapper baeminMapper;
	
	public List<Baemin> getBaeminList() {
		return baeminMapper.selectBaeminList();
	}
	
}
