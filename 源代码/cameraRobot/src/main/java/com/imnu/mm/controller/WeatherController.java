package com.imnu.mm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.imnu.mm.pojo.Weather;
import com.imnu.mm.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	//实时查询气象
	@RequestMapping(value = "/findWeather",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String weatherInfo(){
    	Weather weather = weatherService.selectWeather();
		return JSON.toJSONString(weather);
	
	}
}
