package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.Features;
import com.http.shiller.first.vehicles.base.VehicleType;
import com.http.shiller.first.vehicles.base.entity.Engine;
import lombok.Getter;
import lombok.Setter;


public abstract class Vehicle implements Features {
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

    public String toString() {
        return "Vehicle {producedYear: " + this.producedYear + "; miles: " + this.miles + "; basePrice: " +
                this.basePrice + "; weight: " + this.weight + "; " + this.engine.toString() + "}";
    }
}
