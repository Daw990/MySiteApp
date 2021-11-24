package pl.Dawid.siteApp.consumeApi.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WeatherDto {

    private float temperature;
    private int pressure;
    private float wind;
    private String description;
}
