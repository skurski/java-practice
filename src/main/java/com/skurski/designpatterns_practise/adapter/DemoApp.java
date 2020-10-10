package com.skurski.designpatterns_practise.adapter;

public class DemoApp {

    public static void main(String[] args) {
        VehicleDesktop vehicleDesktop = VehicleDesktop.of(VehicleType.MOTORCYCLE);
        vehicleDesktop.riding();

        VehicleDesktop vehicleDesktop1 = VehicleDesktop.of(VehicleType.CAR);
        vehicleDesktop1.riding();

    }
}
