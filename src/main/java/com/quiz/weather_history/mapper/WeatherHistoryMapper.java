package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {

	// input: X
	// output: List<WeatherHistory>
	public List<WeatherHistory> selectWeatherHistoryList();
}
