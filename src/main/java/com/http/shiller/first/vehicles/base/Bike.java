package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;

public class Bike extends Vehicle {

    public Bike(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        super(producedYear, miles, basePrice, weight, engine);
    }

    public Bike(int producedYear, int miles, int weight, Engine engine) {
        super(producedYear, miles, 100, weight, engine);
    }

    public Bike(int producedYear, int weight, Engine engine) {
        super(producedYear, 100, weight, engine);
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Bike");
    }

    public void stop() {

    }
}