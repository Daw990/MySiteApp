package pl.Dawid.siteApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.Dawid.siteApp.consumeApi.model.WeatherDto;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.entity.Expenses;
import pl.Dawid.siteApp.service.CytatyService;
import pl.Dawid.siteApp.service.ExpensesService;
import pl.Dawid.siteApp.service.WeatherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RestControllerApi {

    private final CytatyService cytatyService;
    private final ExpensesService expensesService;
    private final WeatherService weatherService;

    @GetMapping("/cytaty")
    public List<Cytaty> getCytaty() {
        return cytatyService.cytatyFindAll();
    }

    @GetMapping("/random-cytat")
    public Cytaty getCytat() {
        return cytatyService.findOneRandomCytat();
    }

    @GetMapping("/expenses/rachunki")
    public List<Expenses> getExpensesRachunki() {
        return expensesService.findExpensesByCategory("Rachunki");
    }

    @GetMapping("/expenses/produkty-finansowe")
    public List<Expenses> getExpensesProduktyFinansowe() {
        return expensesService.findExpensesByCategory("Produkty finansowe");
    }

    @GetMapping("/expenses/wydatki-domowe")
    public List<Expenses> getExpensesWydatkiDomowe() {
        return expensesService.findExpensesByCategory("Wydatki domowe");
    }

    @GetMapping("/expenses/edukacja")
    public List<Expenses> getExpensesEdukacja() {
        return expensesService.findExpensesByCategory("Edukacja");
    }

    @GetMapping("/expenses/inne")
    public List<Expenses> getExpensesInne() {
        return expensesService.findExpensesByCategory("Inne");
    }

    @GetMapping("/weatherFull")
    public String getWeatherFull() {
        return weatherService.GetWeatherString("Warszawa");
    }

    @GetMapping("/weather")
    public WeatherDto getWeatherByCity() {
        return weatherService.GetWeather("Warszawa");
    }
}
