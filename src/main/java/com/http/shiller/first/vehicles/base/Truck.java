package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class Truck extends Vehicle {

    public Truck(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice);
    }

    public Truck(int producedYear, int miles) {
        super(producedYear, miles, 20000);
    }

    public Truck(int producedYear) {
        super(producedYear, 20000);
    }

    public void go() {
    }

    public void stop() {

    }
}