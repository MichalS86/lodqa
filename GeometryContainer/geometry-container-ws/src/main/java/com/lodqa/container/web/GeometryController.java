package com.lodqa.container.web;

import com.lodqa.container.model.GeometryFigure;
import com.lodqa.container.model.GeometryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/")
public class GeometryController {

    private static final Logger LOG = LoggerFactory.getLogger(GeometryController.class);

    @Value("${info.version}")
    private String version;

    @Autowired
    GeometryService service;

    @PostMapping(value = "/addGeometry", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UUID addPainting(@RequestBody GeometryFigure geometryFigure) {
        return service.addGeometry(geometryFigure);
    }

    @GetMapping(value = "/getGeometry/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GeometryFigure getGeometry(@PathVariable(name = "id") UUID id) {
        return service.getGeometry(id);
    }

    @PostMapping(value = "/updateSurface/{id}/{surface}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSurface(@PathVariable(name = "id") UUID id, @PathVariable(name = "surface") Float surface) {
        service.updateSurface(id, surface);
    }

    @PostMapping(value = "/updateVolume/{id}/{volume}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateVolume(@PathVariable(name = "id") UUID id, @PathVariable(name = "volume") Float volume) {
        service.updateVolume(id, volume);
    }

    @DeleteMapping(value = "/deleteGeometry/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteGeometry(@PathVariable(name = "id") UUID id) {
        service.deleteGeometry(id);
    }
}
