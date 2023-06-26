<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

			<div class="contents bg-warning col-9">
				<h2>과거 날씨</h2>
				<table class="table">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${weatherHistory}" var="weather" varStatus="status">
							<tr>
								<td><fmt:formatDate value="${weather.date}" pattern="yyyy년 M월 d일"/></td>
								<td>
									<c:choose>
										<c:when test="${weather.weather eq '비'}">
											<img src="/image/weather/rainy.jpg">
										</c:when>										
										<c:when test="${weather.weather eq '맑음'}">
											<img src="/image/weather/sunny.jpg">
										</c:when>
										<c:when test="${weather.weather eq '흐림'}">
											<img src="/image/weather/cloudy.jpg">
										</c:when>
										<c:when test="${weather.weather eq '구름조금'}">
											<img src="/image/weather/partlyCloudy.jpg">
										</c:when>
									</c:choose>
								</td>
								<td>${weather.temperatures}°C</td>
								<td>${weather.precipitation}mm</td>
								<td>${weather.microDust}</td>
								<td>${weather.windSpeed}km/h</td>
							</tr>
						</c:forEach>				
						
					</tbody>
				</table>
			</div>