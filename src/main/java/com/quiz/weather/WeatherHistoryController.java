package com.quiz.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather.bo.WeatherHistoryBO;
import com.quiz.weather.domain.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
		
	@GetMapping("/mainWeatherList")
	public String mainWeatherList(Model model) {
		
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "weather/mainWeatherList";
	}
	
	@GetMapping("/mainAddWeather")
	public String mainAddWeather() {
		return "weather/mainAddWeather";
	}
	
	@PostMapping("/addWeather")
	public String addWeather(
			@ModelAttribute WeatherHistory addWeatherHistory,
			Model model) {
		
		weatherHistoryBO.addWeatherHistory(addWeatherHistory);
		
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "weather/mainWeatherList";
	}

}
