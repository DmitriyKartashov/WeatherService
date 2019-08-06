package ru.kartashov.weatherservice.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.kartashov.weatherservice.model.WeatherInfo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherServiceTest {
    private final String JSON_RESPONSE = "{\"coord\": { \"lon\": 139,\"lat\": 35},\n" +
            "  \"weather\": [\n" +
            "    {\n" +
            "      \"id\": 800,\n" +
            "      \"main\": \"Clear\",\n" +
            "      \"description\": \"clear sky\",\n" +
            "      \"icon\": \"01n\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"base\": \"stations\",\n" +
            "  \"main\": {\n" +
            "    \"temp\": 289.92,\n" +
            "    \"pressure\": 1009,\n" +
            "    \"humidity\": 92,\n" +
            "    \"temp_min\": 288.71,\n" +
            "    \"temp_max\": 290.93\n" +
            "  },\n" +
            "  \"wind\": {\n" +
            "    \"speed\": 0.47,\n" +
            "    \"deg\": 107.538\n" +
            "  },\n" +
            "  \"clouds\": {\n" +
            "    \"all\": 2\n" +
            "  },\n" +
            "  \"dt\": 1560350192,\n" +
            "  \"sys\": {\n" +
            "    \"type\": 3,\n" +
            "    \"id\": 2019346,\n" +
            "    \"message\": 0.0065,\n" +
            "    \"country\": \"JP\",\n" +
            "    \"sunrise\": 1560281377,\n" +
            "    \"sunset\": 1560333478\n" +
            "  },\n" +
            "  \"timezone\": 32400,\n" +
            "  \"id\": 1851632,\n" +
            "  \"name\": \"Shuzenji\",\n" +
            "  \"cod\": 200\n" +
            "}";
    @InjectMocks
    private OpenWeatherService openWeatherService;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void initMocks() {
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(new ResponseEntity<>(JSON_RESPONSE, HttpStatus.CREATED));
    }

    @Test
    public void shouldReturnWeatherInfoWithTemperature() {
        // given

        // when
        WeatherInfo weather = openWeatherService.getWeather("London");

        // then
        assertEquals(289.92, weather.getTemperature(), 0.0001);
    }
}