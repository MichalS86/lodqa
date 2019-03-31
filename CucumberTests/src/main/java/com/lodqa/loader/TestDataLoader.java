package com.lodqa.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lodqa.container.model.GeometryFigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


public class TestDataLoader {

    private static Logger LOG = LoggerFactory.getLogger(TestDataLoader.class);
    private ObjectMapper mapper = new ObjectMapper();

    public GeometryFigure getGeometryFigure(String name) {
        GeometryFigure geometryFigure = null;
        File file = new File(getClass().getClassLoader().getResource("geometry/" + name + ".json").getFile());
        try {
            geometryFigure = mapper.readValue(file, GeometryFigure.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        LOG.info("Loaded room with id {}", geometryFigure.getId());
        return geometryFigure;
    }

}
