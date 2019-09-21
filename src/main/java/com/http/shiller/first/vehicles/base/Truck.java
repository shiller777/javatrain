package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;

public class Truck extends Vehicle {

    public Truck(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        super(producedYear, miles, basePrice, weight, engine);
    }

    public Truck(int producedYear, int miles, int weight, Engine engine) {
        super(producedYear, miles, 20000, weight, engine);
    }

    public Truck(int producedYear, int weight, Engine engine) {
        super(producedYear, 20000, weight, engine);
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Truck");
    }

    public void stop() {

    }
}