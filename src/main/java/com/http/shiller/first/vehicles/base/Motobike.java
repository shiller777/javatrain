package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Motobike extends Vehicle {

    public Motobike(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice);
    }

    public Motobike(int producedYear, int miles) {
        super(producedYear, miles, 2000);
    }

    public Motobike(int producedYear) {
        super(producedYear, 2000);
    }

    public void go() {
    }

    public void stop() {

    }
}