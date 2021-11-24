package pl.Dawid.siteApp.consumeApi.weather.dto;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class WeatherFull {

    private WeatherMainDto main;
    private WeatherWindDto wind;
    private List<WeatherJson> weather;
}
