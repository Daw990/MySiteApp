package pl.Dawid.siteApp.consumeApi.weatherDaily.dto.mapper;

import lombok.Builder;
import lombok.Getter;
import pl.Dawid.siteApp.consumeApi.weather.dto.WeatherJson;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.TempDailyDto;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.TempFeelsLikeDto;

import java.util.List;

@Getter
@Builder
public class WeatherDailyMapDto {
    private String icon;
    private String weatherView;
    private String weatherViewEng;
    private String date;
    private String sunriseTime;
    private String sunsetTime;
    private String moonriseTime;
    private String moonsetTime;
    private float moonPhase;
    private int pressure;
    private int humidity;
    private float wind_speed;
    private float pop;
    private float rain;
    private TempDailyMapDto temperature;
    private TempFeelsLikeDto tempFeelsLike;
}
