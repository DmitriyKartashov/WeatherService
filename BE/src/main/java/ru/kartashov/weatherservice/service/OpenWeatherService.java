package ru.kartashov.weatherservice.service;

import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.kartashov.weatherservice.model.WeatherInfo;

@Service
public class OpenWeatherService {

    @Autowired
    private RestTemplate restTemplate;

    public WeatherInfo getWeather(String city) {
        String json = restTemplate.getForEntity(String.format("https://samples.openweathermap.org/data/2.5/weather?q=%s,uk&appid=6d7fd0ce8852c52762f08208b3a00985", city), String.class).getBody();
        double temp = JsonPath.read(json, "$.main.temp");
        return WeatherInfo.builder()
                .temperature(temp)
                .build();
    }
}
