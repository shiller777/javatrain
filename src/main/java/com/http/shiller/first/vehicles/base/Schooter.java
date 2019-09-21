package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;

public class Schooter extends Vehicle {

    public Schooter(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        super(producedYear, miles, basePrice, weight, engine);
    }

    public Schooter(int producedYear, int miles, int weight, Engine engine) {
        super(producedYear, miles, 500, weight, engine);
    }

    public Schooter(int producedYear, int weight, Engine engine) {
        super(producedYear, 500, weight, engine);
    }

    @Override
    public String toString() {
        return String.format(super.toString(), "Schooter");
    }

    public void stop() {

    }
}