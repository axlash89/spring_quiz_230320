package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.BookmarkMapper;
import com.quiz.lesson06.domain.Bookmark;

@Service  // Spring bean이 될 수 있도록 annotation
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	public void addBookmark(String name, String address) {
		bookmarkMapper.insertBookmark(name, address);
	}
	
	public boolean existBookmarkByAddress(String address) {
		return bookmarkMapper.existBookmarkByAddress(address);
	}
	
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
	
}
