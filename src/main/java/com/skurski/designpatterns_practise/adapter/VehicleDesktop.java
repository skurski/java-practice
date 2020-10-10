package com.skurski.designpatterns_practise.adapter;

public class VehicleDesktop {

    private Movement movement;

    private VehicleType vehicleType;

    public VehicleDesktop(Movement movement, VehicleType vehicleType) {
        this.movement = movement;
        this.vehicleType = vehicleType;
    }

    public static VehicleDesktop of(VehicleType vehicleType) {
        Movement movement;
        switch (vehicleType) {
            case MOTORCYCLE:
                movement = new MotorcycleAdapter(new MotorcycleExternalTool());
                break;
            default:
                movement = new CarAdapter(new CarExternalTool());
        }

        return new VehicleDesktop(movement, vehicleType);
    }

    public void riding() {
        System.out.println("Vehicle chosen: " + vehicleType);
        movement.moveUp();
        movement.faster();
        movement.hang();
    }
}
