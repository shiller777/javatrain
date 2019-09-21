package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;

public class SimpleCar extends Vehicle {

    public SimpleCar(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        super(producedYear, miles, basePrice, weight, engine);
    }

    public SimpleCar(int producedYear, int miles, int weight, Engine engine) {
        super(producedYear, miles, 5000, weight, engine);
    }

    public SimpleCar(int producedYear, int weight, Engine engine) {
        super(producedYear, 5000, weight, engine);
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "SimpleCar");
    }

    public void stop() {

    }
}
