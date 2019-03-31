package com.lodqa.calculator.calc;

import com.lodqa.container.model.GeometryFigure;

public class SurfaceCounter3d {

    public static double PI = 3.14;

    public double countCubeSurface(GeometryFigure cube) {
        return 6 * Math.pow(cube.getDimensions().get("a"), 2);
    }

    public double countSphareSurface(GeometryFigure sphare) {
        return 4 * PI * Math.pow(PI * sphare.getDimensions().get("r"), 2);
    }

    public double countConeSurface(GeometryFigure cone) {
        double base = PI * Math.pow(cone.getDimensions().get("r"), 2);

        double lateral = PI * (cone.getDimensions().get("r") *
                Math.pow(
                        Math.pow(cone.getDimensions().get("h"), 2) + Math.pow(cone.getDimensions().get("r"), 2)
                        , (0.5)));

        return base + lateral;
    }

    public double countCylinderSurface(GeometryFigure cylinder) {
        double base = 2 * PI * Math.pow(cylinder.getDimensions().get("r"), 2);
        double lateral = 2 * PI * cylinder.getDimensions().get("r") * cylinder.getDimensions().get("h");
        return base + lateral;
    }


}
