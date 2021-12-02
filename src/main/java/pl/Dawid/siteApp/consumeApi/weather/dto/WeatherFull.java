package pl.Dawid.siteApp.consumeApi.weather.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class WeatherFull {

    private WeatherMainDto main;
    private WeatherWindDto wind;
    private WeatherCordsDto coord;
    private List<WeatherJson> weather;
    private String name;
}
