package com.keyin.completed.weatherexample;

public class WeatherServiceImpl implements WeatherAPI {

    public String getCurrentWeather(String location) {
        return switch (location) {
            case "New York" -> "Sunny, 25°C";
            case "Los Angeles" -> "Cloudy, 20°C";
            case "Chicago" -> "RAIN RAIN RAIN WIND";
            case "St John's" -> "Snowy, -5°C";
            default -> "Location not found";
        };

    }
}
