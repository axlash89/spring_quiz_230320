<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	
	<div id="wrap" class="container">
		<h1>즐겨찾기 목록</h1>
		
		<table class="table text-center">
			<thead>			
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>					
				</tr>				
			</thead>
			<tbody>				
				<c:forEach items="${bookmarkList}" var="bookmark" varStatus="status">
					<tr>
						<td>${bookmark.id}</td>
						<td>${bookmark.name}</td>
						<td><a href="${bookmark.address}">${bookmark.address}</a></td>
						<td>
							<!-- <button type="button" id="${bookmark.id}" class="deleteBookmark btn btn-danger">삭제</button> -->
							
							<!-- name 속성과 value 속성을 이용하여 동적으로 삭제버튼 값 가져오기 -->
							<!-- <button type="button" name="delBtn" class="btn btn-danger" value="${bookmark.id}">삭제</button> -->							
							
							<!-- data를 이용해서 태그에 값을 임시 저장해놓기 -->
							<button type="button" class="del-btn btn btn-danger" data-bookmark-id="${bookmark.id}">삭제</button> <!-- data-bookmarkId 절대 이렇게 X 카멜케이스 안됨 -->							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>

	<script>
		$(document).ready(function() {
			
			/* $('.deleteBookmark').on('click', function() {				
				
				let id = $(this).attr('id');
				
				$.ajax({
					
					type:"get"
					, url:"/lesson06/quiz01/delete_bookmark"
					, data:{"id":id}
				
					, success:function(data) {
						if (data.code == 1) {
							location.href="/lesson06/quiz01/after_add_bookmark_view";
						} else {
							alert("삭제 실패");
						}
					}
					, error:function(request, status, error) {
						alert("삭제를 실패했습니다.")
					}
					
				});
				
			}); */
			
			/* $('button[name=delBtn]').on('click', function(e) {
				// name 속성과 value 속성을 이용하여 동적으로 삭제버튼 값 가져오기
				// alert("삭제 버튼");
				
				// let id = $(this).val();
				// let id = $(this).attr('value');				
				let id = e.target.value;
				alert(id);				
			}); */
			
			
			// data를 이용해서 태그에 값을 임시 저장해놓기
			// 태그 영역 : data-블라블라		data- 우리가 이름을 짓는다!! 카멜케이스 절대 안됨!
			// script 영역 : $(this).data();
			$('.del-btn').on('click', function() {
				// alert("삭제 버튼");
				
				let id = $(this).data('bookmark-id');
				
				$.ajax({
					
					// request
					type:"delete"
					, url:"/lesson06/quiz01/delete_bookmark"
					, data:{"id":id}
				
					// response
					, success:function(data) {
						if (data.code == 1) {
							location.reload(true);  // 그 자리에서 새로고침
						} else {
							alert(data.errorMessage);
						}
					}
					, error:function(request, status, error) {
						alert("삭제를 실패했습니다. 관리자에게 문의해주세요.")
					}
					
				});
				
			});
			
		});
	</script>

</body>
</html>