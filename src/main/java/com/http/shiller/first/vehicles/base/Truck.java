package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Truck extends Vehicle {

    public Truck(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice, VehicleType.TRUCK.getInfo().getWeight());
    }

    public Truck(int producedYear, int miles) {
        super(producedYear, miles, 20000, VehicleType.TRUCK.getInfo().getWeight());
    }

    public Truck(int producedYear) {
        super(producedYear, 20000, VehicleType.TRUCK.getInfo().getWeight());
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}