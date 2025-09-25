package com.keyin.completed.weatherexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {
    WeatherService weatherService;

    @Mock
    WeatherAPI mockWeatherAPI;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService(mockWeatherAPI);
    }
    @Test
    void testWeatherMock(){
        when(mockWeatherAPI.getCurrentWeather("St Johns")).thenReturn("Sunny 25C");
        Assertions.assertEquals("Sunny 25C", weatherService.getWeather("St Johns"));
        verify(mockWeatherAPI).getCurrentWeather("St Johns");
    }
}
