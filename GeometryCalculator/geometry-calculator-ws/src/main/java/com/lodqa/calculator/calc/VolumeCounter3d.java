package com.lodqa.calculator.calc;

import com.lodqa.container.model.GeometryFigure;

public class VolumeCounter3d {

    public static double PI = 3.14;

    public double countCubeVolumne(GeometryFigure cube) {
        return Math.pow(cube.getDimensions().get("a"), 3);
    }

    public double countSphareVolume(GeometryFigure sphare) {
        return (4 / 3) * PI * Math.pow(sphare.getDimensions().get("r"), 3);
    }

    public double countConeVolume(GeometryFigure cone) {
        return (1 / 3) * PI * Math.pow(cone.getDimensions().get("r"), 2) * cone.getDimensions().get("h");
    }

    public double countCylinderVolume(GeometryFigure cylinder) {
        return PI * Math.pow(cylinder.getDimensions().get("r"), 2) * cylinder.getDimensions().get("h");
    }
}
