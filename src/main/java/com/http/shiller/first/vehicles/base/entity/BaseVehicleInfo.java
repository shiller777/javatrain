package com.http.shiller.first.vehicles.base.entity;

import com.http.shiller.first.vehicles.Vehicle;
import lombok.Getter;
import lombok.Setter;

public class BaseVehicleInfo {
    @Getter
    @Setter
    private int weight;
    @Getter
    @Setter
    private Vehicle classCar;

    public BaseVehicleInfo(int weight, Vehicle classCar) {
        this.weight = weight;
        this.classCar = classCar;
    }
}
