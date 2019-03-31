package com.lodqa.calculator.ws;

import com.lodqa.calculator.AppConfig;
import com.lodqa.calculator.calc.CounterManager;
import com.lodqa.calculator.model.GeometryCalculatorService;
import com.lodqa.container.client.WebGeometryContainerClient;
import com.lodqa.container.model.GeometryFigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GeometryCalculatorServiceImpl implements GeometryCalculatorService {

    WebGeometryContainerClient client;
    CounterManager counterManager = new CounterManager();

    @Autowired
    public GeometryCalculatorServiceImpl(AppConfig config) {
        client = new WebGeometryContainerClient(config.getContainerWsUrl(), 30, 30);
    }

    @Override
    public void countSurface(UUID id) {
        GeometryFigure geometry = client.getGeometry(id);
        double surface = counterManager.countSurface(geometry);
        client.updateSurface(id, surface);
    }

    @Override
    public void countVolume(UUID id) {
        GeometryFigure geometry = client.getGeometry(id);
        double volume = counterManager.countVolume(geometry);
        client.updateVolume(id, volume);
    }
}
