package com.quiz.weather;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather.bo.WeatherHistoryBO;
import com.quiz.weather.domain.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
		
	@GetMapping("/mainWeatherList")
	public String mainWeatherList(Model model) {
		
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather/mainWeatherList";
	}
	
	@GetMapping("/mainAddWeather")
	public String mainAddWeather() {
		return "weather/mainAddWeather";
	}
	
	// 날씨 insert
//	@PostMapping("/addWeather")
//	public String addWeather(
//			@ModelAttribute WeatherHistory weatherHistory,
//			Model model) {
//		
//		weatherHistoryBO.addWeatherHistory(weatherHistory);
//		
//		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistory();
//		
//		model.addAttribute("weatherHistoryList", weatherHistoryList);
//		
//		return "weather/mainWeatherList";
//	}
	
	
//	@PostMapping("/addWeather")
//	public String addWeather(
//			@ModelAttribute WeatherHistory weatherHistory) {
//		
//		weatherHistoryBO.addWeatherHistory(weatherHistory);
//		
//		return "redirect:/weather/mainWeatherList";  // 새 request 수행
//		
//	}
	
	@PostMapping("/addWeather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		return "redirect:/weather/mainWeatherList";  // 새 request 수행
		
	}	
	

}
