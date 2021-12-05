package pl.Dawid.siteApp.consumeApi.weatherDaily.dto;

import lombok.Getter;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherJson;

import java.util.List;

@Getter
public class WeatherDailyDto {
    private long dt;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    private float moon_phase;
    private int pressure;
    private int humidity;
    private float dew_point;
    private float wind_speed;
    private int wind_deg;
    private float wind_gust;
    private float clouds;
    private float pop;
    private float rain;
    private float uvi;
    private TempDailyDto temp;
    private TempFeelsLikeDto feels_like;
    private List<WeatherJson> weather;
}
