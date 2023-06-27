<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족 - 우리동네 가게</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/baemin/style.css">
</head>
<body>
	
	<div id="wrap" class="container">
		<header>
			<div class="bg-info text-white p-1">
				<h2 class="font-weight-light">배탈의 민족</h2>
			</div>
		</header>
		<section class="contents">
		
			<c:forEach items="${baeminList}" var="store" varStatus="status">
			
				<div id="storeBox" class="w-100 border border-info mt-2">
					<a href="/baemin/reviews?storeId=${status.count}&storeName=${store.name}">
					<div class="m-2">
						<h4>${store.name}</h4>
						전화번호 : ${store.phoneNumber}<br>
						주소 : ${store.address}<br>
					</div>
					</a>
				</div>
			
			</c:forEach>
			
		</section>
		<footer>
			<div>(주)우와한형제</div>
			<div class="text-secondary">고객센터 : 1900-1688</div>
		</footer>
	</div>

</body>
</html>