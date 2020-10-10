package com.skurski.designpatterns_practise.adapter;

public class CarAdapter implements Movement {

    private CarExternalTool carExternalTool;

    public CarAdapter(CarExternalTool carExternalTool) {
        this.carExternalTool = carExternalTool;
    }

    @Override
    public String moveUp() {
        return carExternalTool.start();
    }

    @Override
    public String hang() {
        return carExternalTool.stop();
    }

    @Override
    public String faster() {
        return carExternalTool.accelerate();
    }
}
