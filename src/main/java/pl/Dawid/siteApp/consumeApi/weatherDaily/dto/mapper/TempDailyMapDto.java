package pl.Dawid.siteApp.consumeApi.weatherDaily.dto.mapper;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TempDailyMapDto {
    private int tempMax;
    private int tempMin;
    private int tempDay;
    private int tempNight;
    private int tempEve;
    private int tempMorn;
}
