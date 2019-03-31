package com.lodqa.container.model;

public class Dimension {
    private char name;
    private float value;

    public Dimension(char name, float value) {
        this.name = name;
        this.value = value;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
