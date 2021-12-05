package pl.Dawid.siteApp.consumeApi.weatherDaily.dto;

import lombok.Getter;

@Getter
public class TempDailyDto {
    private float day;
    private float min;
    private float max;
    private float night;
    private float eve;
    private float morn;
}
