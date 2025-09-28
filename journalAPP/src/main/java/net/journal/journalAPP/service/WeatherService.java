package net.journal.journalAPP.service;

import jdk.javadoc.doclet.DocletEnvironment;
import net.journal.journalAPP.api.response.WeatherResponse;
import net.journal.journalAPP.cache.AppCache;
import net.journal.journalAPP.config.RedisConfig;
import net.journal.journalAPP.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.client.RestTemplate;

import static jdk.javadoc.doclet.DocletEnvironment.*;
import static jdk.javadoc.doclet.DocletEnvironment.ModuleMode.API;

@Service
public class WeatherService {

    @Value("${weather_api_key}")
    private String apiKey;

    private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city , WeatherResponse.class);
        if(weatherResponse != null)
            return weatherResponse;
        else{
            String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.CITY,city).replace(PlaceHolders.API_KEY,apiKey);
            ResponseEntity<WeatherResponse> response= restTemplate.exchange(finalApi, HttpMethod.POST,null, WeatherResponse.class);
            if(response.getBody() != null){
                redisService.set("weather_of_" + city,response.getBody(),300l);
            }
            return response.getBody();
        }
    }
}
