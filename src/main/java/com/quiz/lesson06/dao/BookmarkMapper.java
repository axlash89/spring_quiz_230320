package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	public List<Bookmark> selectBookmarkList();
	
	public void insertBookmark(
			@Param("name") String name,
			@Param("address") String address);
	
	public boolean existBookmarkByAddress(String address);
	
	public Bookmark selectBookmarkByAddress(String address);
	
//	public void deleteBookmarkById(int id);

	public int deleteBookmarkById(int id);
	
}
