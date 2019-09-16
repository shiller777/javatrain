package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Bike extends Vehicle {

    public Bike(int producedYear, int miles, int basePrice, int weight) {
        super(producedYear, miles, basePrice, weight);
    }

    public Bike(int producedYear, int miles, int weight) {
        super(producedYear, miles, 100, weight);
    }

    public Bike(int producedYear, int weight) {
        super(producedYear, 100, weight);
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}