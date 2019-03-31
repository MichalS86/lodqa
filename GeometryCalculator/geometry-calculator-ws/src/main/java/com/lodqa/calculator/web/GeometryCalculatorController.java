package com.lodqa.calculator.web;

import com.lodqa.calculator.model.GeometryCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/")
public class GeometryCalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(GeometryCalculatorController.class);

    @Value("${info.version}")
    private String version;

    @Autowired
    GeometryCalculatorService service;

    @PostMapping(value = "/countSurface/{id}")
    public void addPainting(@PathVariable(name = "id") UUID uuid) {
        service.countSurface(uuid);
    }

    @PostMapping(value = "/countVolume/{id}")
    public void countVolume(@PathVariable(name = "id") UUID id) {
        service.countVolume(id);
    }


}
