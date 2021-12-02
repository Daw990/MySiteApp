package pl.Dawid.siteApp.consumeApi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CurrentWeatherDto {

    private float temperature;
    private int pressure;
    private float wind;
    private String description;
    private String cityName;
    private String CityfromTemplate;
    private float coordLon;
    private float coordLat;
}
