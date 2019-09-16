package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Truck extends Vehicle {

    public Truck(int producedYear, int miles, int basePrice, int weight) {
        super(producedYear, miles, basePrice, weight);
    }

    public Truck(int producedYear, int miles, int weight) {
        super(producedYear, miles, 20000, weight);
    }

    public Truck(int producedYear, int weight) {
        super(producedYear, 20000, weight);
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}