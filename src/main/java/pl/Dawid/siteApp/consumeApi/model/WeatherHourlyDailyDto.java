package pl.Dawid.siteApp.consumeApi.model;

import lombok.Builder;
import lombok.Getter;
import pl.Dawid.siteApp.consumeApi.weatherHourly.dto.mapper.WeatherHourlyDto;

@Getter
@Builder
public class WeatherHourlyDailyDto {
    private String weatherView;
    private WeatherHourlyDto weatherHourlyDto;

}
