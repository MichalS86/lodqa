package com.lodqa.calculator.calc;

import com.lodqa.container.model.GeometryFigure;

public class SurfaceCounter2d {

    public static double PI = 3.14;

    public double countSquareSurface(GeometryFigure square) {
        return Math.pow(square.getDimensions().get("a"), 2);
    }

    public double countCircleSurface(GeometryFigure circle){
        return Math.pow(PI * circle.getDimensions().get("r"), 2);
    }

    public double countTriangleSurface(GeometryFigure triangle){
        return triangle.getDimensions().get("a") * triangle.getDimensions().get("h") / 2;
    }


}
