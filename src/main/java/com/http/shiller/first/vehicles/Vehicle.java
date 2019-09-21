package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.Features;
import com.http.shiller.first.vehicles.base.VehicleType;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;
import lombok.Getter;
import lombok.Setter;


public abstract class Vehicle implements Features, Comparable<Vehicle> {
    @Getter
    @Setter
    protected int producedYear;
    @Getter
    @Setter
    protected int miles;
    @Getter
    @Setter
    protected int basePrice;
    @Getter
    @Setter
    protected int weight;
    @Getter
    @Setter
    protected Engine engine;

    public Vehicle(int producedYear, int miles, int basePrice, int weight, Engine engine) {
        this.producedYear = producedYear;
        this.miles = miles;
        this.basePrice = basePrice;
        this.weight = weight;
        this.engine = engine;
    }

    public Vehicle(int producedYear, int basePrice, int weight, Engine engine) {
        this(producedYear, 0, basePrice, weight, engine);
    }

    public static Vehicle getObjectByType(VehicleType type){
        return type.getInfo().getClassCar();
    }

    public int go(int seconds) throws OutOfMaxDistanceException {
        int distance = seconds * seconds * this.engine.getAcceleration();
        if (distance > getEngine().getMaxDistance()) {
            throw new OutOfMaxDistanceException("engine distance is not enough");
        }
        this.miles += distance;
        return distance;
    }

    public String toString() {
        return "Vehicle [%s] {producedYear: " + this.producedYear + "; miles: " + this.miles + "; basePrice: " +
                this.basePrice + "; weight: " + this.weight + "; " + this.engine.toString() + "}";
    }

    @Override
    public int compareTo(Vehicle o) {
        int years = this.getProducedYear() - o.getProducedYear();
        if (years > -3 && years < 3) {
            if (this.getMiles() < o.getMiles()) {
                return 1;
            } else {
                if (this.getMiles() == o.getMiles()) {
                    return 0;
                }
                return -1;
            }
        } else {
            if (years > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
