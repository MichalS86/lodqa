package com.lodqa.container.model;

import java.util.UUID;

public interface GeometryService {

    UUID addGeometry(GeometryFigure geometryFigure);

    GeometryFigure getGeometry(UUID id);

    void updateSurface(UUID id, double surface);

    void updateVolume(UUID id, double volume);

    void deleteGeometry(UUID id);
}
