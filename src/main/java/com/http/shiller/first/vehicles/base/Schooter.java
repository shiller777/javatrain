package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxCapacityException;

public class Schooter extends Vehicle {

    public Schooter(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        super(producedYear, miles, basePrice, weight, engine);
    }

    public Schooter(int producedYear, int miles, int weight, Engine engine) {
        super(producedYear, miles, 500, weight, engine);
    }

    public Schooter(int producedYear, int weight, Engine engine) {
        super(producedYear, 500, weight, engine);
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