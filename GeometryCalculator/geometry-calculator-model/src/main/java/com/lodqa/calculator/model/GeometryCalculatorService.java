package com.lodqa.calculator.model;

import java.util.UUID;

public interface GeometryCalculatorService {

    void countSurface(UUID id);

    void countVolume(UUID id);
}
