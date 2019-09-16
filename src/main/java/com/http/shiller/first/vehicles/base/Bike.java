package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Bike extends Vehicle {

    public Bike(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice, VehicleType.BIKE.getInfo().getWeight());
    }

    public Bike(int producedYear, int miles) {
        super(producedYear, miles, 100, VehicleType.BIKE.getInfo().getWeight());
    }

    public Bike(int producedYear) {
        super(producedYear, 100, VehicleType.BIKE.getInfo().getWeight());
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}