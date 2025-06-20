package com.example.JournalsAndAuthors.service;

import com.example.JournalsAndAuthors.cache.AppCache;
import com.example.JournalsAndAuthors.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.service.apikey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather", WeatherResponse.class);
        if(weatherResponse != null) {
            return weatherResponse;
        }
        String finalApi = appCache.APP_CACHE.get("weather_service_url").replace("<api_key>", apiKey).replace("<city>", city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse res = response.getBody();
        if(res != null) {
            redisService.set("weather", res, 300l);
        }
        return res;
    }
}
