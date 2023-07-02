package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	@GetMapping("/add_bookmark_view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	@ResponseBody
	@PostMapping("/add_bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("address") String address) {
		
		// db insert
		bookmarkBO.addBookmark(name, address);
		
		// 응답
		// { "code":1, "result":"성공" }  JSON String
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		return result;
	}
	
	@GetMapping("/after_add_bookmark_view")
	public String getBookmarkView(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/afterAddBookmark";
	}
	
//	@GetMapping("/is_duplication")
//	@ResponseBody
//	public Map<String, Boolean> isDuplication(
//			@RequestParam("address") String address) {
//		
//		// db 조회
//		boolean isDuplication = bookmarkBO.existBookmarkByAddress(address);
//		
//		// 응답
//		Map<String, Boolean> result = new HashMap<>();
//		result.put("isDuplication", isDuplication);
//		
//		return result;
//	}
	
	@PostMapping("/is_duplication")
	@ResponseBody
	public Map<String, Object> isDuplication(
			@RequestParam("address") String address) {
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("isDuplication", false);
		
		// db select by url
		Bookmark bookmark = bookmarkBO.getBookmarkByAddress(address);
		if (bookmark != null) {  // 중복
			result.put("isDuplication", true);
		}
		
		return result;
	}
	
	// AJAX가 하는 요청 - 즐겨찾기 삭제
//	@GetMapping("/delete_bookmark")  // delete를 get으로 하는 것은 위험함. 
//	@ResponseBody
//	public Map<String, Object> deleteBookmarkById(
//			@RequestParam("id") int id) {
//		
//		bookmarkBO.deleteBookmarkById(id);
//		
//		Map<String, Object> result = new HashMap<>();
//		result.put("code", 1);
//		result.put("result", "성공");
//		
//		return result;
//		
//	}
	
	@DeleteMapping("/delete_bookmark")
	@ResponseBody
	public Map<String, Object> deleteBookmarkById(
			@RequestParam("id") int id) {
		
		int row = bookmarkBO.deleteBookmarkById(id)
				; 
		Map<String, Object> result = new HashMap<>();
		
		if (row == 1) {  // 삭제 성공
			result.put("code", 1);
			result.put("result", "성공");			
		} else {  // 삭제된 행이 없어서 실패일때
			result.put("code", 500);
			result.put("errorMessage", "삭제될 데이터가 없습니다.");
		}
				
		return result;
		
	}
	
	
}
