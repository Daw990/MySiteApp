package pl.Dawid.siteApp.consumeApi.weatherDaily.dto;

import lombok.Getter;

@Getter
public class TempFeelsLikeDto {
    private float day;
    private float night;
    private float eve;
    private float morn;
}
