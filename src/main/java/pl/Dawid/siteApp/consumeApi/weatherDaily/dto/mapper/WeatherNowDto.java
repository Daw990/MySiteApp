package pl.Dawid.siteApp.consumeApi.weatherDaily.dto.mapper;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherNowDto {
    private String currentDate;
    private String currentTime;
    private String sunriseTime;
    private String sunsetTime;
    private String weatherView;
    private String weatherViewEng;
    private float temp;
    private float feelsLike;
    private int pressure;
    private float windSpeed;
}
