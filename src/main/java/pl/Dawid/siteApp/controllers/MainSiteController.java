package pl.Dawid.siteApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainSiteController {

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
