<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
	
	<h2 class="d-flex justify-content-center mt-4 mb-4 font-weight-bold">예약하기</h2>
	
	<div class="d-flex justify-content-center">
		<div id="reservationBox">
			<div class="form-group">
				<div>이름</div>
				<input type="text" class="form-control" id="name">
			</div>
			<div class="form-group">
				<div>예약날짜</div>
				<input type="text" class="form-control" id="date">
			</div>
			<div class="form-group">
				<div>숙박일수</div>
				<input type="text" class="form-control" id="day" placeholder="ex) 숫자만 입력">
			</div>
			<div class="form-group">
				<div>숙박인원</div>
				<input type="text" class="form-control" id="headcount" placeholder="ex) 숫자만 입력">
			</div>
			<div class="form-group">
				<div>전화번호</div>
				<input type="text" class="form-control" id="phoneNumber" placeholder="ex) 010-1234-5678">
			</div>
			<input type="button" class="btn btn-warning w-100" id="bookingBtn" value="예약하기">
		</div>
	</div>
	
</section>

<script>
		$(document).ready(function() {
			
			
			$('#date').datepicker({
				dateFormat: "yy-mm-dd"
			});
			
			$('#bookingBtn').on('click', function() {
				let name = $('#name').val().trim();
				let date = $('#date').val().trim();
				let day = $('#day').val().trim();
				let headcount = $('#headcount').val().trim();
				let phoneNumber = $('#phoneNumber').val().trim();
				
				if(!name) {
					alert("공란을 빠짐없이 작성하세요.")
					return;
				} else if(!date) {
					alert("공란을 빠짐없이 작성하세요.")
					return;
				} else if(!day) {
					alert("공란을 빠짐없이 작성하세요.")
					return;
				} else if(!headcount) {
					alert("공란을 빠짐없이 작성하세요.")
					return;
				} else if(!phoneNumber) {
					alert("공란을 빠짐없이 작성하세요.")
					return;
				}
				
				if(/[^0123456789-]/g.test(phoneNumber)){
				    // 숫자와 하이픈이 아닌 기타 문자가 들어있는 경우
				    alert("전화번호는 숫자와 하이픈(-)만 입력하세요.");
				    $('#phoneNumber').val('');
				    return;
				}
				
				if (!/^[0-9]{3}-[0-9]{4}-[0-9]{4}/.test(phoneNumber)) {
					alert("3자리-4자리-4자리 형식으로 입력하세요.");
					$('#phoneNumber').val('');
			        return;
			    }
				
				$.ajax({
					type:"post"
					, url:"/tong/make_a_reservation"
					, data:{"name":name 
							,"date":date  
							,"day":day 
							,"headcount":headcount 
							,"phoneNumber":phoneNumber}
				
					, success:function(data) {
						if (data.code == 1) {
							location.href="/tong/main_reservation_list";
						} else {
							alert("예약 실패")
						} 
					} 
					, error:function(request, status, error) {
						alert("예약 실패. 관리자에게 문의해주세요.")
					}
				});
			});
			
		});
</script>