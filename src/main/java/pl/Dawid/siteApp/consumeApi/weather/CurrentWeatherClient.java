package pl.Dawid.siteApp.consumeApi.weather;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.Dawid.siteApp.consumeApi.model.CurrentWeatherDto;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherCordsDto;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherFull;

@Component
public class CurrentWeatherClient {

    //api.openweathermap.org/data/2.5/weather?q=warszawa&appid=76106378f4cc7973caadb1d213040f3f&units=metric&lang=pl

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    public static final String API_KEY = "76106378f4cc7973caadb1d213040f3f";
    private final RestTemplate restTemplate = new RestTemplate();

    @SneakyThrows
    public CurrentWeatherDto getCurrentWeatcherByCity(String city) {
        WeatherFull weatherFull = restTemplate.getForObject(WEATHER_URL + "?q={city}&appid={apiKey}&units=metric&lang=pl",
                WeatherFull.class, city, API_KEY);

        return CurrentWeatherDto.builder()
                .temperature(weatherFull.getMain().getTemp())
                .pressure(weatherFull.getMain().getPressure())
                .wind(weatherFull.getWind().getSpeed())
                .description(weatherFull.getWeather().get(0).getDescription())
                .cityName(weatherFull.getName())
                .coordLat(weatherFull.getCoord().getLat())
                .coordLon(weatherFull.getCoord().getLon())
                .build();
    }

    public String getWeatcherByCity2(String city) {
        return restTemplate.getForObject(WEATHER_URL + "?q={city}&appid={apiKey}&units=metric&lang=pl",
                String.class, city, API_KEY);
    }
}