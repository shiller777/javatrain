package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;

public class SimpleCar extends Vehicle {

    public SimpleCar(int producedYear, int miles, int basePrice) {
        super(producedYear, miles, basePrice);
    }

    public SimpleCar(int producedYear, int miles) {
        super(producedYear, miles, 5000);
    }

    public SimpleCar(int producedYear) {
        super(producedYear, 5000);
    }

    public void go() {
    }

    public void stop() {

    }
}
