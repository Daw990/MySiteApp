package pl.Dawid.siteApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.Dawid.siteApp.entity.Expenses;
import pl.Dawid.siteApp.repository.ExpensesRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    private final ExpensesRepo expensesRepo;

    public List<Expenses> findExpensesByCategory(String category) {
        return expensesRepo.findExpensesByCategory(category);
    }
}
