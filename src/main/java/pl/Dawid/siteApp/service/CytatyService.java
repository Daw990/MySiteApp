package pl.Dawid.siteApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.repository.CytatyRepo;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CytatyService {

    private final CytatyRepo cytatyRepo;

    public List<Cytaty> cytatyFindAll() {
        return cytatyRepo.findAll();
    }

    public Cytaty findOneRandomCytat() {
        List<Cytaty> cytaty = cytatyRepo.findAll();
        Random rand = new Random();
        return cytaty.get(rand.nextInt(cytaty.size()));
    }

}
