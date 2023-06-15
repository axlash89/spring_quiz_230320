package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.domain.Store;

@Service
public class StoreBO {
	
	// input : X
	// output : storeList => Controller한테 돌려준다.
		
	@Autowired
	private StoreMapper storeMapper;  // spring bean을 주입받는다. DI
	
	public List<Store> getStoreList() {
		List<Store> storeList = storeMapper.selectStoreList();
		return storeList;
	}
	
}
