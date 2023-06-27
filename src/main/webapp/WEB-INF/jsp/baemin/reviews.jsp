<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족 - 리뷰</title>
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
			<h1 class="text-weight-light">${storeName} - 리뷰</h1>
			<c:choose>
				<c:when test="${empty reviews}">
					<h1>작성된 리뷰가 없습니다.</h1>
				</c:when>
				<c:otherwise>
					<c:forEach items="${reviews}" var="review">					
						<div id="ReviewBox" class="border border-info mt-2">
							<div class="m-2">
								<div class="d-flex">
									<h4 class="font-weight-bold">${review.userName}</h4>						
									<c:set var="count" value="${review.point / 1}"/>							
									<c:set var="calStar" value="0"/>							
									<c:forEach begin="1" end="${count}" step="1">
										<img src="/image/baemin/star_fill.png" alt="별 1" width="20px" height="20px">
										<c:set var="calStar" value="${calStar + 1}"/>
									</c:forEach>
									<c:set var="countHalf" value="${review.point % 1}"/>
									<c:if test="${countHalf eq 0.5}">
										<img src="/image/baemin/star_half.png" alt="별 0.5" width="20px" height="20px">
										<c:set var="calStar" value="${calStar + 1}"/>
									</c:if>
									<c:forEach begin="1" end="${5 - calStar}" step="1">
										<img src="/image/baemin/star_empty.png" alt="별 0" width="20px" height="20px">
									</c:forEach>						
								</div>
								<span><fmt:formatDate value="${review.createdAt}" pattern="yyyy년 M월 d일"/></span>
								<h5>${review.review}</h5>
								<span>${review.menu}</span>
							</div>
						</div>					
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</section>
		<footer>
			<div>(주)우와한형제</div>
			<div class="text-secondary">고객센터 : 1900-1688</div>
		</footer>
	</div>

</body>
</html>