package com.keyin.completed.weatherexample;

public class APITEST {
    public static void main(String[] args) {
        WeatherServiceImpl api = new WeatherServiceImpl();
        WeatherService service = new WeatherService(api);
        String weather = service.getWeather("St John's");
        System.out.println("Current weather in St John's: " + weather);
    }
}
