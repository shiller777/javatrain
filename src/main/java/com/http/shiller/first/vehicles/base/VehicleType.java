package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.base.entity.BaseVehicleInfo;
import lombok.Getter;

public enum VehicleType {
    SIMPLE_CAR(new BaseVehicleInfo(2000, new SimpleCar(200, VehicleType.SIMPLE_CAR))),
    TRUCK(new BaseVehicleInfo(9000, new Truck(200, VehicleType.TRUCK))),
    SCHOOTER(new BaseVehicleInfo(150, new Schooter(200, VehicleType.SCHOOTER))),
    BIKE(new BaseVehicleInfo(30, new Bike(200, VehicleType.BIKE))),
    MOTOBIKE(new BaseVehicleInfo(200, new Motobike(200, VehicleType.MOTOBIKE)));

    @Getter
    private BaseVehicleInfo info;

    VehicleType(BaseVehicleInfo info) {
        this.info = info;
    }


}
