package pl.Dawid.siteApp.consumeApi.weatherDaily.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class WeatherDailyFull {
    private CurrentHourlyDailyWeatherDto current;
    private List<WeatherDailyDto> daily;
}
