package pl.Dawid.siteApp.consumeApi.weatherHourly.dto.mapper;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherHourlyDto {
    private String currentDate;
    private String currentTime;
    private String sunriseTime;
    private String sunsetTime;
    private float temp;
    private float feelsLike;
    private int pressure;
    private float windSpeed;
}
