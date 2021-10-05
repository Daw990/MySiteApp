package pl.Dawid.siteApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.entity.Expenses;
import pl.Dawid.siteApp.service.CytatyService;
import pl.Dawid.siteApp.service.ExpensesService;

import java.util.List;

@RestController("/api")
@RequiredArgsConstructor
public class RestControllerApi {

    private final CytatyService cytatyService;
    private final ExpensesService expensesService;

    @GetMapping("/cytaty")
    public List<Cytaty> getCytaty() {
        return cytatyService.cytatyFindAll();
    }

    @GetMapping("/cytat")
    public Cytaty getCytat() {
        return cytatyService.findOneRandomCytat();
    }

    @GetMapping("/expenses")
    public List<Expenses> getExpenses() {
        return expensesService.findExpensesByCategory("Rachunki");
    }

}
