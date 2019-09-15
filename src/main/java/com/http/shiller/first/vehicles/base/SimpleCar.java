package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class SimpleCar extends Vehicle {

    public SimpleCar(int producedYear) {
        super(producedYear, VehicleType.SIMPLE_CAR);
    }

    public void go() {
    }

    public void stop() {

    }
}
