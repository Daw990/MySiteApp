package pl.Dawid.siteApp.consumeApi.weatherHourly.dto;

import lombok.Getter;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherJson;

import java.util.List;

@Getter
public class WeatherHourlyFull {
    private CurrentHourlyDailyWeatherDto current;
}
