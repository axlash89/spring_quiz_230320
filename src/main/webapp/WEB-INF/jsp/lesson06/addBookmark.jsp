<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>

	<div id="wrap" class="container">
		
		<h1>즐겨찾기 추가하기</h1>
		
		<label for="name">제목</label>
		<div class="form-group">
			<input type="text" id="name" class="form-control">
		</div>			
		
		<label for="address">주소</label>
		<div class="form-group">
			<div class="form-inline">
			 	<input type="text" id="address" class="form-control col-9">
				<input type="button" id="checkDuplicateBtn" class="btn btn-info col-3" value="중복확인">	
			</div>			
			<!-- <small id="addressStatusArea"></small><small id="nbsp">&nbsp</small> -->
			<small id="duplicationText" class="text-danger d-none">중복된 url 입니다.</small>
			<small id="availableText" class="text-success d-none">저장 가능한 url 입니다.</small>
		</div>		
		
		<input type="button" id="addBtn" class="btn btn-success btn-block" value="추가">

	</div>

	<script>
	
		$(document).ready(function() {
			
			$('#checkDuplicateBtn').on('click', function() {
				/* $('#addressStatusArea').empty();
				
				let address = $('#address').val().trim();
				
				if (!address) {
					$('#addressStatusArea').append('<span class="text-danger">주소가 비어있습니다.</span>')					
					return;
				}
				
				if (!address.startsWith('https://') && !address.startsWith('http://')) {
					$('#addressStatusArea').append('<span class="text-danger">주소 형식이 잘못되었습니다.</span>')
					return;
				}
				
								
				$.ajax({
					
					type:"get"
					, url:"/lesson06/quiz01/is_duplication"
					, data:{"address":address}
					
					, success:function(data) {
						if (data.isDuplication) {
							$('#addressStatusArea').append('<span class="text-danger">주소가 중복되었습니다.</span>')
						} else {
							$('#addressStatusArea').append('<span class="text-primary">저장 가능한 주소입니다.</span>')
						}
					}
					, error:function(request, status, error) {
						alert("중복 확인에 실패하였습니다.")
					}
					
				}); */
				
				let address = $('#address').val().trim();
				if (!address) {
					alert("검사할 url을 입력해주세요");
					return;
				}
				
				// AJAX 통신 => DB URL 존재 여부
				$.ajax({
					
					// request
					type:"post"
					, url:"/lesson06/quiz01/is_duplication"
					, data:{"address":address}
				
					// response
					, success:function(data) {
						// {"code":1, "isDuplication":true}
						if (data.isDuplication) {  // 중복
							$('#duplicationText').removeClass('d-none');
							$('#availableText').addClass('d-none');
						} else {  // 사용 가능(중복 아님)
							$('#duplicationText').addClass('d-none');
							$('#availableText').removeClass('d-none');
						}
					}
					
				});
					
			});
			
			$('#addBtn').on('click', function() {
				
				let name = $('#name').val().trim();
				let address = $('#address').val().trim();
				
				if (name == '') {
					alert("사이트 제목을 입력하세요.");
					return;
				}
				
				if (address == '') {
					alert("사이트 주소를 입력하세요.");
					return;
				// http 아니고 그리고 https 아닐 때	
				} else if (!address.startsWith('https://') && !address.startsWith('http://')) {
					alert("주소 형식이 잘못되었습니다.")
					return;
				}
				
				// 중복확인 체크
				if ($('#availableText').hasClass('d-none')) {  // 잘못된 경우( availableText d-none인 경우 )
					alert("중복된 url입니다. 다시 확인해주세요.")
					return;
				}
				
				// AJAX 통신 => 서버 요청
				$.ajax({
					// request
					type:"post"
					, url:"/lesson06/quiz01/add_bookmark"
					, data:{"name":name, "address":address}
					
					// response
					, success:function(data) {  // String, JSON => 자바스크립트의 객체 변환
						if (data.code == 1) {
							location.href = "/lesson06/quiz01/after_add_bookmark_view";  // GET method
						} else {
							alert("즐겨찾기 추가를 실패했습니다.");
						}
					}
					, error:function(request, status, error) {
						alert("즐겨찾기 추가를 실패했습니다.")
					}
					
				});
				
			});
			
		});
		
	</script>	

</body>
</html>