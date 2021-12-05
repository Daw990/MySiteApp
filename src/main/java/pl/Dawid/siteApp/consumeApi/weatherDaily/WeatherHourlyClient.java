package pl.Dawid.siteApp.consumeApi.weatherDaily;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.Dawid.siteApp.consumeApi.model.WeatherHourlyDailyDto;

import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.WeatherDailyDto;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.mapper.WeatherDailyMapDto;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.mapper.WeatherNowDto;
import pl.Dawid.siteApp.consumeApi.weatherDaily.dto.WeatherDailyFull;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class WeatherHourlyClient {
    //https://api.openweathermap.org/data/2.5/onecall?lat=52.2298&lon=21.0118&appid=76106378f4cc7973caadb1d213040f3f&units=metric&lang=pl&exclude=minutely

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/onecall";
    public static final String API_KEY = "76106378f4cc7973caadb1d213040f3f";
    private final RestTemplate restTemplate = new RestTemplate();

    @SneakyThrows
    public WeatherHourlyDailyDto getDailyHourlyWeatcherByCity(float lat, float lon, String cityName) {
        WeatherDailyFull weatherDailyFull = restTemplate.getForObject(WEATHER_URL + "?lat={1}&lon={2}&appid={3}&units=metric&lang=pl&exclude=minutely",
                WeatherDailyFull.class, lat, lon, API_KEY);

        return WeatherHourlyDailyDto.builder()
                .weatherNowDto(mapWeatherHourlyDto(weatherDailyFull))
                .weatherDailyMapDtoList(mapWeatherDailyMapDto(weatherDailyFull))
                .cityName(cityName)
                .build();
    }

    private List<WeatherDailyMapDto> mapWeatherDailyMapDto(WeatherDailyFull weatherDailyFull) {
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("E d/MM", new Locale("PL"));
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        List<WeatherDailyMapDto> weatherDailyMapDtos = new ArrayList<>();

        weatherDailyFull.getDaily().forEach(day -> {
            WeatherDailyMapDto weatherDailyMapDto = WeatherDailyMapDto.builder()
                    .date(currentDateFormat.format(new Timestamp(day.getDt()*1000)))
                    .sunriseTime(timeFormat.format(new Timestamp(day.getSunrise()*1000)))
                    .sunsetTime(timeFormat.format(new Timestamp(day.getSunset()*1000)))
                    .moonriseTime(timeFormat.format(new Timestamp(day.getMoonrise()*1000)))
                    .moonsetTime(timeFormat.format(new Timestamp(day.getMoonset()*1000)))
                    .pressure(day.getPressure())
                    .humidity(day.getHumidity())
                    .temperature(day.getTemp())
                    .tempFeelsLike(day.getFeels_like())
                    .weatherView(day.getWeather().get(0).getDescription())
                    .weatherViewEng(day.getWeather().get(0).getMain())
                    .icon(day.getWeather().get(0).getIcon())
                    .build();
            weatherDailyMapDtos.add(weatherDailyMapDto);
        });
        return weatherDailyMapDtos;
    }

    private WeatherNowDto mapWeatherHourlyDto (WeatherDailyFull weatherDailyFull) {
        SimpleDateFormat currentDateFormat = new SimpleDateFormat("d/MM/yyyy");
        SimpleDateFormat timeFormatWithSec = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        WeatherNowDto weatherNowDto = WeatherNowDto.builder()
                .currentDate(currentDateFormat.format(new Timestamp(weatherDailyFull.getCurrent().getDt()*1000)))
                .currentTime(timeFormatWithSec.format(new Timestamp(weatherDailyFull.getCurrent().getDt()*1000)))
                .sunriseTime(timeFormat.format(new Timestamp(weatherDailyFull.getCurrent().getSunrise()*1000)))
                .sunsetTime(timeFormat.format(new Timestamp(weatherDailyFull.getCurrent().getSunset()*1000)))
                .feelsLike(weatherDailyFull.getCurrent().getFeels_like())
                .pressure(weatherDailyFull.getCurrent().getPressure())
                .temp(weatherDailyFull.getCurrent().getTemp())
                .windSpeed(weatherDailyFull.getCurrent().getWind_speed())
                .weatherView(weatherDailyFull.getCurrent().getWeather().get(0).getDescription())
                .weatherViewEng(weatherDailyFull.getCurrent().getWeather().get(0).getMain())
                .build();
        return weatherNowDto;
    }

}
