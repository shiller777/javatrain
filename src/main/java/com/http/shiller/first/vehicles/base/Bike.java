package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Bike extends Vehicle {

    public Bike(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice);
    }

    public Bike(int producedYear, int miles) {
        super(producedYear, miles, 100);
    }

    public Bike(int producedYear) {
        super(producedYear, 100);
    }

    public void go() {
    }

    public void stop() {

    }
}