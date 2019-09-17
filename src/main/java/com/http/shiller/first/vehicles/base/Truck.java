package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxCapacityException;

public class Truck extends Vehicle {

    public Truck(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        super(producedYear, miles, basePrice, weight, engine);
    }

    public Truck(int producedYear, int miles, int weight, Engine engine) {
        super(producedYear, miles, 20000, weight, engine);
    }

    public Truck(int producedYear, int weight, Engine engine) {
        super(producedYear, 20000, weight, engine);
    }

    public double go(int seconds, int miles) throws OutOfMaxCapacityException {
        if (this.miles > getEngine().getMaxCapacity()) {
            throw new OutOfMaxCapacityException();
        }
        //System.out.println("Average speed: " + miles / seconds);
        this.miles += miles;
        return miles / seconds;
    }

    public void stop() {

    }
}