package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openweathermap.api.key}")
    private String apiKey;
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city){
        String baseUrl = "https://api.openweathermap.org/data/2.5/weather";
        String url = String.format("%s?q=%s&APPID=%s", baseUrl, city, apiKey);
        //http://localhost:9090/weather?city=Seoul
        return restTemplate.getForObject(url, String.class);
    }

}
