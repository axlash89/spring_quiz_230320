<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="d-flex contents">

	<nav class="bg-info col-3">
			<img src="/image/weather/weatherService.png" width="100px" alt="로고1">
			<ul class="nav flex-column h5 mt-3">
 				<li class="nav-item mb-3"><a href="/weather/mainWeatherList" class="nav-link menu-font">날씨</a></li>
				<li class="nav-item mb-3"><a href="/weather/mainAddWeather" class="nav-link menu-font">날씨입력</a></li>
				<li class="nav-item mb-3"><a href="#" class="nav-link menu-font">테마날씨</a></li>
				<li class="nav-item mb-3"><a href="#" class="nav-link menu-font">관측기후</a></li>
			</ul>
		</nav>

	<div class="col-9">
	
		<h2 class="ml-1 mt-2">날씨 입력</h2>
		
		<form method="post" action="/weather/addWeather" class="mt-3">
		
			<div class="d-flex justify-content-between align-items-center">
				<label for="datepicker">날짜</label>
				<input type="text" class="form-control col-3 ml-1 mr-3" id="datepicker" name="date">
				<label for="weather">날씨</label>
				<select class="form-control col-3 ml-1 mr-3" id="weather" name="weather">
					<option>맑음</option>
					<option>구름조금</option>
					<option>흐림</option>
					<option>비</option>
				</select>
				<label for="microDust">미세먼지</label>
				<select class="form-control col-3 ml-1" id="microDust" name="microDust">
					<option>좋음</option>
					<option>보통</option>
					<option>나쁨</option>
					<option>최악</option>
				</select>
			</div>	
				
			
			<div class="d-flex justify-content-between mt-3">				
				<div class="d-flex align-items-center col-4">
					<div class="input-label">기온</div>
					<div class="input-group">
					  <input type="text" class="form-control ml-1"name="temperatures">
					  <div class="input-group-append">
					    <span class="input-group-text">°C</span>
					  </div>
					</div>
				</div>				
				<div class="d-flex align-items-center col-4">
					<div class="input-label">강수량</div>
					<div class="input-group">
					  <input type="text" class="form-control ml-1"name="precipitation">
					  <div class="input-group-append">
					    <span class="input-group-text">mm</span>
					  </div>
					</div>
				</div>				
				<div class="d-flex align-items-center col-4">
					<div class="input-label">풍속</div>
					<div class="input-group">
					  <input type="text" class="form-control ml-1"name="windSpeed">
					  <div class="input-group-append">
					    <span class="input-group-text">km/h</span>
					  </div>
					</div>
				</div>				
			</div>
			
			<input type="submit" class="float-right btn btn-success mt-2" value="저장">		
			
		</form>
	
	</div>
	
</div>	