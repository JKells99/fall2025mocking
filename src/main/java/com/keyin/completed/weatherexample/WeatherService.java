package com.keyin.completed.weatherexample;

public class WeatherService {
    WeatherAPI api;
    public WeatherService(WeatherAPI api) {
        this.api = api;
    }
    public String getWeather(String location) {
        return api.getCurrentWeather(location);
}

}
