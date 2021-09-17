package pl.Dawid.siteApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.service.CytatyRepoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestControllerApi {

    private final CytatyRepoService cytatyRepoService;

    @GetMapping("/test/cytaty")
    public List<Cytaty> getCytaty() {
        return cytatyRepoService.cytatyFindAll();
    }
}
