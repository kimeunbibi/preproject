package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WeatherWebClientController {

    @Autowired
    private WebClient webClient;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @GetMapping("/webclient/weather")
    public Mono<String> getWeather(@RequestParam String city){
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s", city, apiKey);
        //http://localhost:9090/webclient/weather?city=Seoul
        return webClient.get().uri(url).retrieve().bodyToMono(String.class);
    }
}
