<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section>
	<h2 class="d-flex justify-content-center mt-4 mb-4">예약 목록 보기</h2>
	<table class="table text-center">
		
		<thead>
			<tr>
				<th>이름</th>
				<th>예약날짜</th>
				<th>숙박일수</th>
				<th>숙박인원</th>
				<th>전화번호</th>
				<th>예약상태</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${bookingList}" var="booking">
				<tr>
					<td>${booking.name}</td>
					<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일"/></td>
					<td>${booking.day}</td>
					<td>${booking.headcount}</td>
					<td>${booking.phoneNumber}</td>
					<td>
						<c:choose>
							<c:when test="${booking.state eq '확정'}">
								<span class="text-success">${booking.state}</span>
							</c:when>
							<c:when test="${booking.state eq '대기중'}">
								<span class="text-info">${booking.state}</span>
							</c:when>
						</c:choose>
					</td>
					<td><input type="button" class="del-btn btn btn-danger" value="삭제" data-booking-id="${booking.id}"></td>
				</tr>	
			</c:forEach>	
		</tbody>
		
	</table>
</section>

<script>
		$(document).ready(function() {
			
			$('.del-btn').on('click', function() {
				let id = $(this).data('booking-id');
				
				$.ajax({
					type:"delete"
					, url:"/tong/reservation_delete"
					, data:{"id":id}
				
					, success:function(data) {
						if (data.code == 1) {
							location.reload(true);
						} else {
							alert(data.errorMessage)
						}
					} 
					, error:function(request, status, error) {
						alert("삭제를 실패했습니다. 관리자에게 문의해주세요.")
					}
				});
			});
			
		});
</script>