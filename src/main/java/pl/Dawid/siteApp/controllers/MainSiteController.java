package pl.Dawid.siteApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.Dawid.siteApp.entity.Cytaty;
import pl.Dawid.siteApp.service.CytatyRepoService;

@Controller
@RequiredArgsConstructor
public class MainSiteController {

    private final CytatyRepoService cytatyRepoService;

    @GetMapping(value = "/")
    public String mainSite(Model model) {
        Cytaty cytat = cytatyRepoService.findOneRandomCytat();
        model.addAttribute("cytat", cytat);
        return "index";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "mainWeb/contact";
    }

    @GetMapping(value = "/projects")
    public String projects() {
        return "mainWeb/projects";
    }

    @GetMapping(value = "note/ut2004")
    public String ut2004() {
        return "note/ut2004";
    }

    @GetMapping(value = "note/note")
    public String note() {
        return "note/note";
    }
}
