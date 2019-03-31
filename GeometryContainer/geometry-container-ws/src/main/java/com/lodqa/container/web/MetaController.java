package com.lodqa.container.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class MetaController {

    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/swagger-ui.html", true);
    }

}
