package pl.Dawid.siteApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.Dawid.siteApp.entity.Expenses;

import java.util.List;

@Repository
public interface ExpensesRepo extends CrudRepository<Expenses, Long> {

    List<Expenses> findExpensesByCategory(String category);

}
