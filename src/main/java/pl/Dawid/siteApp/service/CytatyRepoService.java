package pl.Dawid.siteApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.repository.CytatyRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CytatyRepoService {

    private final CytatyRepo cytatyRepo;

    public List<Cytaty> cytatyFindAll() {
        return cytatyRepo.findAll();
    }

//    public Cytaty findOneRandomCytat() {
//        List<Cytaty> cytaty = cytatyRepo.findAll();
//    }

}
