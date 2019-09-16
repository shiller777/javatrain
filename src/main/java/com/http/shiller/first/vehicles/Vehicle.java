package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.Features;
import com.http.shiller.first.vehicles.base.VehicleType;
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

    public Vehicle(int producedYear, int miles, int basePrice, int weight) {
        this.producedYear = producedYear;
        this.miles = miles;
        this.basePrice = basePrice;
        this.weight = weight;
    }

    public Vehicle(int producedYear, int basePrice, int weight) {
        this(producedYear, 0, basePrice, weight);
    }

    public static Vehicle getObjectByType(VehicleType type){
        return type.getInfo().getClassCar();
    }

    public String toString() {
        return "Vehicle {producedYear: " + this.producedYear + "; miles: " + this.miles + "; basePrice: " +
                this.basePrice + "; weight: " + this.weight + "}";
    }
}
