package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Motobike extends Vehicle {

    public Motobike(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice, VehicleType.MOTOBIKE.getInfo().getWeight());
    }

    public Motobike(int producedYear, int miles) {
        super(producedYear, miles, 2000, VehicleType.MOTOBIKE.getInfo().getWeight());
    }

    public Motobike(int producedYear) {
        super(producedYear, 2000, VehicleType.MOTOBIKE.getInfo().getWeight());
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}