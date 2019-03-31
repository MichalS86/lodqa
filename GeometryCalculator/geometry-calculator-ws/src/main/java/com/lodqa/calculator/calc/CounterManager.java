package com.lodqa.calculator.calc;

import com.lodqa.calculator.exception.UndefinedGeometryDimensions;
import com.lodqa.calculator.exception.UnrecognizedGeometryNameException;
import com.lodqa.calculator.exception.UnrecognizedGeometryTypeException;
import com.lodqa.container.model.GeometryFigure;
import com.lodqa.container.model.GeometryName;

public class CounterManager {

    private SurfaceCounter2d surfaceCounter2d = new SurfaceCounter2d();
    private SurfaceCounter3d surfaceCounter3d = new SurfaceCounter3d();
    private VolumeCounter3d volumeCounter3d = new VolumeCounter3d();

    public double countSurface(GeometryFigure geometryFigure) throws UnrecognizedGeometryTypeException {
        switch (geometryFigure.getGeometryType()) {
            case "3D":
                return count3dSurface(geometryFigure);
            case "2D":
                return count2dSurface(geometryFigure);
            default:
                throw new UnrecognizedGeometryTypeException("Unrecognized geometry type");
        }
    }

    public double countVolume(GeometryFigure geometryFigure) {
        switch (geometryFigure.getGeometryType()) {
            case "3D":
                return count3dVolume(geometryFigure);
            default:
                throw new UnrecognizedGeometryTypeException("Unrecognized geometry type");
        }
    }

    private double count2dSurface(GeometryFigure geometryFigure) {
        try {
            switch (geometryFigure.getName()) {
                case GeometryName.CIRCLE:
                    return surfaceCounter2d.countSquareSurface(geometryFigure);
                case GeometryName.SQUARE:
                    return surfaceCounter2d.countSquareSurface(geometryFigure);
                case GeometryName.TRIANGLE:
                    surfaceCounter2d.countTriangleSurface(geometryFigure);
                default:
                    throw new UnrecognizedGeometryNameException("Unrecognized geometry name");
            }
        } catch (NullPointerException e) {
            throw new UndefinedGeometryDimensions("Unrecognized dimensions");
        }
    }

    private double count3dSurface(GeometryFigure geometryFigure) {
        try {
            switch (geometryFigure.getName()) {
                case GeometryName.CONE:
                    return surfaceCounter3d.countConeSurface(geometryFigure);
                case GeometryName.CUBE:
                    return surfaceCounter3d.countCubeSurface(geometryFigure);
                case GeometryName.CYLINDER:
                    return surfaceCounter3d.countCylinderSurface(geometryFigure);
                case GeometryName.SPHERE:
                    return surfaceCounter3d.countSphareSurface(geometryFigure);
                default:
                    throw new UnrecognizedGeometryNameException("Unrecognized geometry name");
            }
        } catch (NullPointerException e) {
            throw new UndefinedGeometryDimensions("Unrecognized dimensions");
        }
    }

    private double count3dVolume(GeometryFigure geometryFigure) {
        try {
            switch (geometryFigure.getName()) {
                case GeometryName.CONE:
                    return volumeCounter3d.countConeVolume(geometryFigure);
                case GeometryName.CUBE:
                    return volumeCounter3d.countCubeVolumne(geometryFigure);
                case GeometryName.CYLINDER:
                    return volumeCounter3d.countCylinderVolume(geometryFigure);
                case GeometryName.SPHERE:
                    return volumeCounter3d.countSphareVolume(geometryFigure);
                default:
                    throw new UnrecognizedGeometryNameException("Unrecognized geometry name");
            }
        } catch (NullPointerException e) {
            throw new UndefinedGeometryDimensions("Unrecognized dimensions");
        }
    }
}