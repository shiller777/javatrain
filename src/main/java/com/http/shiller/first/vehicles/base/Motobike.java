package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;

public class Motobike extends Vehicle {

    public Motobike(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        super(producedYear, miles, basePrice, weight, engine);
    }

    public Motobike(int producedYear, int miles, int weight, Engine engine) {
        super(producedYear, miles, 2000, weight, engine);
    }

    public Motobike(int producedYear, int weight, Engine engine) {
        super(producedYear, 2000, weight, engine);
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Motobike");
    }

    public void stop() {

    }
}