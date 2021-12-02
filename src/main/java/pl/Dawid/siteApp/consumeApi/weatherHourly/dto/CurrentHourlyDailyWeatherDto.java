package pl.Dawid.siteApp.consumeApi.weatherHourly.dto;

import lombok.Getter;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherJson;

import java.util.List;

@Getter
public class CurrentHourlyDailyWeatherDto {
    private long dt;
    private long sunrise;
    private long sunset;
    private float temp;
    private float feels_like;
    private int pressure;
    private float wind_speed;

    private List<WeatherJson> weather;


}
