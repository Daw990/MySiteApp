package pl.Dawid.siteApp.consumeApi.weatherHourly;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.Dawid.siteApp.consumeApi.model.WeatherHourlyDailyDto;

import pl.Dawid.siteApp.consumeApi.weatherHourly.dto.mapper.WeatherHourlyDto;
import pl.Dawid.siteApp.consumeApi.weatherHourly.dto.WeatherHourlyFull;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
public class WeatherHourlyClient {
    //https://api.openweathermap.org/data/2.5/onecall?lat=52.2298&lon=21.0118&appid=76106378f4cc7973caadb1d213040f3f&units=metric&lang=pl&exclude=minutely

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/onecall";
    public static final String API_KEY = "76106378f4cc7973caadb1d213040f3f";
    private final RestTemplate restTemplate = new RestTemplate();

    @SneakyThrows
    public WeatherHourlyDailyDto getDailyHourlyWeatcherByCity(float lat, float lon) {
        WeatherHourlyFull weatherHourlyFull = restTemplate.getForObject(WEATHER_URL + "?lat={1}&lon={2}&appid={3}&units=metric&lang=pl&exclude=minutely",
                WeatherHourlyFull.class, lat, lon, API_KEY);

        SimpleDateFormat currentDateFormat = new SimpleDateFormat("d/MM/yyyy");
        SimpleDateFormat timeFormatWithSec = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        WeatherHourlyDto weatherHourlyDto = WeatherHourlyDto.builder()
                .currentDate(currentDateFormat.format(new Timestamp(weatherHourlyFull.getCurrent().getDt()*1000)))
                .currentTime(timeFormatWithSec.format(new Timestamp(weatherHourlyFull.getCurrent().getDt()*1000)))
                .sunriseTime(timeFormat.format(new Timestamp(weatherHourlyFull.getCurrent().getSunrise()*1000)))
                .sunsetTime(timeFormat.format(new Timestamp(weatherHourlyFull.getCurrent().getSunset()*1000)))
                .feelsLike(weatherHourlyFull.getCurrent().getFeels_like())
                .pressure(weatherHourlyFull.getCurrent().getPressure())
                .temp(weatherHourlyFull.getCurrent().getTemp())
                .windSpeed(weatherHourlyFull.getCurrent().getWind_speed())
                .build();

        return WeatherHourlyDailyDto.builder()
                .weatherHourlyDto(weatherHourlyDto)
                .weatherView(weatherHourlyFull.getCurrent().getWeather().get(0).getDescription())
                .build();
    }


}
