package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.base.entity.BaseVehicleInfo;
import lombok.Getter;

public enum VehicleType {
    SIMPLE_CAR(new BaseVehicleInfo(new SimpleCar(2000, 2000))),
    TRUCK(new BaseVehicleInfo(new Truck(2000, 9000))),
    SCHOOTER(new BaseVehicleInfo(new Schooter(2000, 150))),
    BIKE(new BaseVehicleInfo(new Bike(2000, 30))),
    MOTOBIKE(new BaseVehicleInfo(new Motobike(2000, 200)));

    @Getter
    private BaseVehicleInfo info;

    VehicleType(BaseVehicleInfo info) {
        this.info = info;
    }


}
