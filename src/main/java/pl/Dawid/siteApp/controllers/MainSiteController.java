package pl.Dawid.siteApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.Dawid.siteApp.consumeApi.model.CurrentWeatherDto;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.entity.Expenses;
import pl.Dawid.siteApp.service.CytatyService;
import pl.Dawid.siteApp.service.ExpensesService;
import pl.Dawid.siteApp.service.WeatherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainSiteController {

    private final CytatyService cytatyService;
    private final ExpensesService expensesService;
    private final WeatherService weatherService;

    @GetMapping(value = "/")
    public String mainSite(Model model) {
        Cytaty cytat = cytatyService.findOneRandomCytat();
        model.addAttribute("cytat", cytat);
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "mainWeb/login";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "mainWeb/contact";
    }

    @GetMapping(value = "/projects")
    public String projects() {
        return "mainWeb/projects";
    }

    @GetMapping(value = "/games/ut2004")
    public String ut2004() {
        return "note/ut2004";
    }

    @GetMapping(value = "/note/note")
    public String note() {
        return "note/note";
    }

    @GetMapping(value = "/note/linux-wiki")
    public String linuxWiki() {
        return "note/linux-wiki";
    }

    @GetMapping(value = "/note/savings-counter")
    public String savingMeter(Model model) {
        List<Expenses> expensesRachunki = expensesService.findExpensesByCategory("Rachunki");
        List<Expenses> expensesFinanse = expensesService.findExpensesByCategory("Produkty finansowe");
        List<Expenses> expensesDomowe = expensesService.findExpensesByCategory("Wydatki domowe");
        List<Expenses> expensesEdukacja = expensesService.findExpensesByCategory("Edukacja");
        List<Expenses> expensesOther = expensesService.findExpensesByCategory("Inne");
        model.addAttribute("rachunki", expensesRachunki);
        model.addAttribute("finanse", expensesFinanse);
        model.addAttribute("domowe", expensesDomowe);
        model.addAttribute("edukacja", expensesEdukacja);
        model.addAttribute("inne", expensesOther);
        return "note/savings-counter";
    }

    @GetMapping(value = "/note/api")
    public String api() {
        return "note/api";
    }

    @GetMapping(value = "/note/weather")
    public String weather(Model model,
                          @RequestParam(name = "cities", required = false) List<String> cities) {
        //WeatherDto weatherDto = weatherService.GetWeather(city);
        List<CurrentWeatherDto> currentWeatherDtoListToGet = new ArrayList<>();

            cities.forEach(city -> {
                CurrentWeatherDto currentWeatherDto = weatherService.GetCurerntWeather(city);
                currentWeatherDto.setCityfromTemplate(city);
                currentWeatherDtoListToGet.add(currentWeatherDto);
            });

        model.addAttribute("cities", cities);
        model.addAttribute("CurrentWeatherDtoListToGet", currentWeatherDtoListToGet);
        return "note/weather";
    }
}
