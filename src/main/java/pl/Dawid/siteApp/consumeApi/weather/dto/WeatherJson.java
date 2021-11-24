package pl.Dawid.siteApp.consumeApi.weather.dto;

import lombok.Getter;

@Getter
public class WeatherJson {
    private int id;
    private String description;
    private String main;
    private String icon;
}
