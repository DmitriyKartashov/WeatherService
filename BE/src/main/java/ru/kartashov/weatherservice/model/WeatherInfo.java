package ru.kartashov.weatherservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherInfo {
    private double temperature;
}
