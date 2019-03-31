package com.lodqa.container.model;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class GeometryFigure {

    private UUID id;
    private String geometryType;
    private String name;
    private Map<String, Double> dimensions;
    private double surface;
    private double volume;

    public GeometryFigure() {

    }

    public GeometryFigure(UUID id, String geometryType, String name, Map<String, Double> dimensions, float surface, float volume) {
        this.id = id;
        this.geometryType = geometryType;
        this.name = name;
        this.dimensions = dimensions;
        this.surface = surface;
        this.volume = volume;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Map<String, Double> dimensions) {
        this.dimensions = dimensions;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "GeometryFigure{" +
                "id=" + id +
                ", geometryType='" + geometryType + '\'' +
                ", name='" + name + '\'' +
                ", dimensions=" + dimensions +
                ", surface=" + surface +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeometryFigure)) return false;
        GeometryFigure that = (GeometryFigure) o;
        return Double.compare(that.getSurface(), getSurface()) == 0 &&
                Double.compare(that.getVolume(), getVolume()) == 0 &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getGeometryType(), that.getGeometryType()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDimensions(), that.getDimensions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGeometryType(), getName(), getDimensions(), getSurface(), getVolume());
    }
}
