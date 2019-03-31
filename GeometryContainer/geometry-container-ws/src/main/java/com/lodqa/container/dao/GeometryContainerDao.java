package com.lodqa.container.dao;

import com.lodqa.container.model.GeometryFigure;

import java.util.UUID;

public interface GeometryContainerDao {

    UUID addGeometry(GeometryFigure geometryFigure);

    GeometryFigure getGeometry(UUID id);

    void updateSurface(UUID id, double surface);

    void updateVolume(UUID id, double volume);

    void deleteGeometry(UUID id);
}
