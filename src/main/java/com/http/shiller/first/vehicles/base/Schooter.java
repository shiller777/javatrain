package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Schooter extends Vehicle {

    public Schooter(int producedYear, int miles, int basePrice, int weight) {
        super(producedYear, miles, basePrice, weight);
    }

    public Schooter(int producedYear, int miles, int weight) {
        super(producedYear, miles, 500, weight);
    }

    public Schooter(int producedYear, int weight) {
        super(producedYear, 500, weight);
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}