package pl.Dawid.siteApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Expenses {

    @Id
    private Long idExpenses;
    private String name;
    private String category;

}
