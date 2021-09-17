package pl.Dawid.siteApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Cytaty {

    @Id
    private Long idCytaty;
    private String cytat;
    private String autor;

}
