package com.skurski.designpatterns_practise.adapter;

public class MotorcycleAdapter implements Movement {

    private MotorcycleExternalTool motorcycleExternalTool;

    public MotorcycleAdapter(MotorcycleExternalTool motorcycleExternalTool) {
        this.motorcycleExternalTool = motorcycleExternalTool;
    }

    @Override
    public String moveUp() {
        return motorcycleExternalTool.fire();
    }

    @Override
    public String hang() {
        return motorcycleExternalTool.stoppie();
    }

    @Override
    public String faster() {
        return motorcycleExternalTool.open();
    }
}
