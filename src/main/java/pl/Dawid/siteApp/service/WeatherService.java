package pl.Dawid.siteApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.Dawid.siteApp.consumeApi.model.WeatherHourlyDailyDto;
import pl.Dawid.siteApp.consumeApi.weather.CurrentWeatherClient;
import pl.Dawid.siteApp.consumeApi.model.CurrentWeatherDto;
import pl.Dawid.siteApp.consumeApi.weatherDaily.WeatherHourlyClient;

@Service
@Slf4j
@AllArgsConstructor
public class WeatherService {

    private CurrentWeatherClient currentWeatherClient;
    private WeatherHourlyClient weatherHourlyClient;

    public String GetCurrentWeatherFullJson(String city) {
        return currentWeatherClient.getWeatcherByCity2(city);
    }

    public CurrentWeatherDto GetCurerntWeather(String city) {
        return currentWeatherClient.getCurrentWeatcherByCity(city);
    }

    public WeatherHourlyDailyDto getWeatherhourlyDaily(String city) {
        CurrentWeatherDto currentWeatherDto = currentWeatherClient.getCurrentWeatcherByCity(city);
        return weatherHourlyClient.getDailyHourlyWeatcherByCity(currentWeatherDto.getCoordLat(),
                currentWeatherDto.getCoordLon(), currentWeatherDto.getCityName());
    }
}
