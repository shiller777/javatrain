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
    protected VehicleType type;
    @Getter
    @Setter
    protected int weight;

    public Vehicle(int producedYear, int miles, VehicleType type, int weight) {
        this.producedYear = producedYear;
        this.miles = miles;
        this.type = type;
        this.weight = weight;
    }


    public Vehicle(int producedYear, int miles, VehicleType type) {
        this(producedYear, miles, type, type.getInfo().getWeight());
    }

    public Vehicle(int producedYear, VehicleType type, int weight) {
        this(producedYear, 0, type, weight);
    }

    public Vehicle(int producedYear, VehicleType type) {
        this(producedYear, 0, type, type.getInfo().getWeight());
    }

    public static Vehicle getObjectByType(VehicleType type){
        return type.getInfo().getClassCar();
    }
}
