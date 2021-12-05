package pl.Dawid.siteApp.consumeApi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.WeatherDailyDto;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.mapper.WeatherDailyMapDto;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.mapper.WeatherNowDto;

import java.util.List;

@Getter
@Setter
@Builder
public class WeatherHourlyDailyDto {

    private String cityName;
    private String cityfromTemplate;
    private WeatherNowDto weatherNowDto;
    //private List<WeatherDailyDto> weatherDailyMapDtos;
    private List<WeatherDailyMapDto> weatherDailyMapDtoList;
}
