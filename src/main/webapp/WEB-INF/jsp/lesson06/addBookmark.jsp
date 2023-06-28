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
		
		<form>
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
			
			<label for="address">주소</label>
			<input type="text" id="address" class="form-control">
			
			<input type="button" id="addBtn" class="btn btn-success" value="추가">				
		</form>
	
	</div>

<script>

	$(document).ready(function() {
		
		$('#addBtn').on('click', function() {
			
			let name = $('#name').val().trim();
			if (name == '') {
				alert("사이트 제목을 입력하세요.");
				return;
			}
			
			let address = $('#address').val().trim();
			if (address == '') {
				alert("사이트 주소를 입력하세요.");
				return;
			} else if (!address.startsWith('https') && !address.startsWith('http')) {
				alert("주소는 http 또는 https로 시작하는 문자열로 입력하세요.")
				return;
			}
			
			$.ajax({
								
				type:"post"
				, url:"/lesson06/quiz01/add_bookmark"
				, data:{"name":name, "address":address}
								
				, success:function(data) {
					if (data == "success") {
						location.href = "/lesson06/quiz01/after_add_bookmark_view";
					} else {
						alert("즐겨찾기 추가를 실패했습니다.");
					}
				}
				
			});
			
		});
		
	});
	
</script>	

</body>
</html>