<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section>
		
			<div>
				<img id="introImg" border="0" width="1110px">
			</div>
			
			<div class="d-flex">
				<div id="box1" class="box font-weight-light col-4 p-5">
					<h1 class="ml-5 mt-4">실시간</h1><h1 class="ml-5">예약하기</h1>
				</div>
				<div id="box2" class="box col-4">
					<h3 class="pl-3 mt-5 mb-3">예약 확인</h3>
					<div class="d-flex justify-content-center align-items-center">
						<label for="name" class="col-4 pl-5">이름 : </label><input type="text" class="form-control col-7" id="name">
					</div>
					<div class="d-flex justify-content-center mt-3 align-items-center">
					<label for="phoneNumber" class="col-4">전화번호 : </label><input type="text" class="form-control col-7" id="phoneNumber">
					</div>
					<input type="button" id="bookingCheck" class="btn btn-success mt-3 float-right mr-2" value="조회하기">	
				</div>
				<div id="box3" class="box col-4">
					<div class="h3 p-5 ml-5 mt-4">
						<div>예약문의 :</div> 
						<div>010-</div> 
						<div>0000-1111</div> 						
					</div>				
				</div>
			</div>
			
</section>
<script type="text/javascript">
			var imgArray = [];
            imgArray[0] = "/image/tong/test06_banner1.jpg";
            imgArray[1] = "/image/tong/test06_banner2.jpg";
            imgArray[2] = "/image/tong/test06_banner3.jpg";
            imgArray[3] = "/image/tong/test06_banner4.jpg";
      		
            var imgNum = 0;
       		function showImage() {
            if (imgNum >= imgArray.length) {
                imgNum = 0;
            }
            var objImg = document.getElementById("introImg");
            objImg.src = imgArray[imgNum];
            setTimeout("showImage()", 5000);
            imgNum++;
       		}
</script>

<script>
		$(document).ready(function() {
			
			$('#bookingCheck').on('click', function() {
				let name = $('#name').val().trim();
				let phoneNumber = $('#phoneNumber').val().trim();
				
				if(!name) {
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
					, url:"/tong/check_a_reservation"
					, data:{"name":name 
							,"phoneNumber":phoneNumber}
				
					, success:function(data) {
						if (data.code == 1) {
							alert("이름 : " + data.name + "\n날짜 : " + data.date + "\n일수 : " + data.day + "\n인원 : " + data.headcount + "\n상태 : " + data.state);
						} else {
							alert(data.errorMessage);
						} 
					} 
					, error:function(request, status, error) {
						alert("조회 실패. 관리자에게 문의 바랍니다.")
					}
				});
			});
			
		});
</script>