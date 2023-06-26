<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
</head>
<body>

	<div class="contents bg-warning col-9">
		
		<h1>날씨 입력</h1>
		<form method="post" action="">
			<label for="date">날짜</label>
			<input type="text" id="date" name="date">
			<label for="weather">날씨</label>
			<input type="select" id="weather" name="weather">
			<label for="microDust">미세먼지</label>
			<input type="text" id="microDust" name="microDust">
			<label for="temperatures">온도</label>
			<div class="d-flex">
				<div class="input-group">
				  <input type="text" class="form-control" id="temperatures" name="temperatures">
				  <div class="input-group-append">
				    <span class="input-group-text">°C</span>
				  </div>
				</div>
				<label for="precipitation">강수량</label>
				<div class="input-group">
				  <input type="text" class="form-control" id="precipitation" name="precipitation">
				  <div class="input-group-append">
				    <span class="input-group-text">mm</span>
				  </div>
				</div>
				<label for="windSpeed">풍속</label>
				<div class="input-group">
				  <input type="text" class="form-control" id="windSpeed" name="windSpeed">
				  <div class="input-group-append">
				    <span class="input-group-text">km/h</span>
				  </div>
				</div>
			</div>
			
		</form>
		
	</div>	
</body>
</html>