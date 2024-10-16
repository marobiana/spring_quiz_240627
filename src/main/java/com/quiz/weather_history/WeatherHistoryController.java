package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;

	// 목록 화면
	// /weather-history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// DB Select
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model에 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/weatherList";
	}
	
	// 추가 화면
	// /weather-history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
}
