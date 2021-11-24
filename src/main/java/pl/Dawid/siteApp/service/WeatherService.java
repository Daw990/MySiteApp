package pl.Dawid.siteApp.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.Dawid.siteApp.consumeApi.weather.WeatherClient;
import pl.Dawid.siteApp.consumeApi.model.WeatherDto;

@Service
@Slf4j
@AllArgsConstructor
public class WeatherService {

    private WeatherClient weatherClient;

    public String GetWeatherString(String city) {

        return weatherClient.getWeatcherByCity2(city);
    }

    public WeatherDto GetWeather(String city) {

        return weatherClient.getWeatcherByCity(city);
    }

}
