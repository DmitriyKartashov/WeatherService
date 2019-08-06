package ru.kartashov.weatherservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kartashov.weatherservice.model.WeatherInfo;
import ru.kartashov.weatherservice.service.OpenWeatherService;

@RestController
public class WeatherInfoController {
    @Autowired
    private OpenWeatherService openWeatherService;

    @RequestMapping("/weather")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public WeatherInfo weather(@RequestParam(value="city") String city) {
        return openWeatherService.getWeather(city);
    }
}
