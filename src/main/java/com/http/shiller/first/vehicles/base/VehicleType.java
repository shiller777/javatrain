package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.base.entity.BaseVehicleInfo;
import lombok.Getter;

public enum VehicleType {
    SIMPLE_CAR(new BaseVehicleInfo(2000, new SimpleCar(2000))),
    TRUCK(new BaseVehicleInfo(9000, new Truck(2000))),
    SCHOOTER(new BaseVehicleInfo(150, new Schooter(2000))),
    BIKE(new BaseVehicleInfo(30, new Bike(2000))),
    MOTOBIKE(new BaseVehicleInfo(200, new Motobike(2000)));

    @Getter
    private BaseVehicleInfo info;

    VehicleType(BaseVehicleInfo info) {
        this.info = info;
    }


}
