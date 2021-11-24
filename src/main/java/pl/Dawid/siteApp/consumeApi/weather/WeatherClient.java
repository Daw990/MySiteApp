package pl.Dawid.siteApp.consumeApi.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.Dawid.siteApp.consumeApi.model.WeatherDto;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherFull;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherJson;

@Component
public class WeatherClient {

    //api.openweathermap.org/data/2.5/weather?q=warszawa&appid=76106378f4cc7973caadb1d213040f3f&units=metric&lang=pl
    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    public static final String API_KEY = "76106378f4cc7973caadb1d213040f3f";
    private final RestTemplate restTemplate = new RestTemplate();

    @SneakyThrows
    public WeatherDto getWeatcherByCity(String city) {
        WeatherFull weatherFull = restTemplate.getForObject(WEATHER_URL + "?q={city}&appid={apiKey}&units=metric&lang=pl",
                WeatherFull.class, city, API_KEY);

        return WeatherDto.builder()
                .temperature(weatherFull.getMain().getTemp())
                .pressure(weatherFull.getMain().getPressure())
                .wind(weatherFull.getWind().getWind())
                .description(weatherFull.getWeather().get(0).getDescription())
                .build();
    }

    public String getWeatcherByCity2(String city) {
        return restTemplate.getForObject(WEATHER_URL + "?q={city}&appid={apiKey}&units=metric&lang=pl",
                String.class, city, API_KEY);
    }
}