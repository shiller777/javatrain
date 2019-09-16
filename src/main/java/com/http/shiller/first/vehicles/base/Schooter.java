package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Schooter extends Vehicle {

    public Schooter(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice, VehicleType.SCHOOTER.getInfo().getWeight());
    }

    public Schooter(int producedYear, int miles) {
        super(producedYear, miles, 500, VehicleType.SCHOOTER.getInfo().getWeight());
    }

    public Schooter(int producedYear) {
        super(producedYear, 500, VehicleType.SCHOOTER.getInfo().getWeight());
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}