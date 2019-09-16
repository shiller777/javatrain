package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class SimpleCar extends Vehicle {

    public SimpleCar(int producedYear, int miles, int basePrice, int weight) {
        super(producedYear, miles, basePrice, weight);
    }

    public SimpleCar(int producedYear, int miles, int weight) {
        super(producedYear, miles, 5000, weight);
    }

    public SimpleCar(int producedYear, int weight) {
        super(producedYear, 5000, weight);
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}
