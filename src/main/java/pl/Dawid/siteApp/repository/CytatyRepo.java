package pl.Dawid.siteApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.Dawid.siteApp.entity.Cytaty;

import java.util.List;

@Repository
public interface CytatyRepo extends CrudRepository<Cytaty, Long>{

    List<Cytaty> findAll();

}
