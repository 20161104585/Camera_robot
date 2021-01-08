package com.imnu.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.mm.mapper.WeatherMapper;
import com.imnu.mm.pojo.Weather;
import com.imnu.mm.pojo.WeatherExample;

@Service
@Transactional
public class WeatherServiceImp implements WeatherService {

	@Autowired
	private WeatherMapper weatherMapper;
	//气象信息查询
	public Weather selectWeather() {
		WeatherExample example = new WeatherExample();
		example.createCriteria().andWeatheridEqualTo(1);
		List<Weather> list = weatherMapper.selectByExample(example);
		return list.isEmpty()?null :list.get(0);
	}
}
