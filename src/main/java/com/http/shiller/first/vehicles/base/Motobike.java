package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Motobike extends Vehicle {

    public Motobike(int producedYear, int miles, int basePrice, int weight) {
        super(producedYear, miles, basePrice, weight);
    }

    public Motobike(int producedYear, int miles, int weight) {
        super(producedYear, miles, 2000, weight);
    }

    public Motobike(int producedYear, int weight) {
        super(producedYear, 2000, weight);
    }

    public void go(int seconds) {
    }

    public void stop() {

    }
}