package pl.Dawid.siteApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.entity.Expenses;
import pl.Dawid.siteApp.repository.ExpensesRepo;
import pl.Dawid.siteApp.service.CytatyService;
import pl.Dawid.siteApp.service.ExpensesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainSiteController {

    private final CytatyService cytatyService;
    private final ExpensesService expensesService;

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

    @GetMapping(value = "/note/ut2004")
    public String ut2004() {
        return "note/ut2004";
    }

    @GetMapping(value = "/note/note")
    public String note() {
        return "note/note";
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
}
