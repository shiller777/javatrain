package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.base.entity.BaseVehicleInfo;
import com.http.shiller.first.vehicles.base.entity.Engine;
import lombok.Getter;

public enum VehicleType {
    SIMPLE_CAR(new BaseVehicleInfo(new SimpleCar(2000, 2000,
            new Engine(200, 500000, 13)))),
    TRUCK(new BaseVehicleInfo(new Truck(2000, 9000,
            new Engine(500, 1000000, 9)))),
    SCHOOTER(new BaseVehicleInfo(new Schooter(2000, 150,
            new Engine(50, 10000, 4)))),
    BIKE(new BaseVehicleInfo(new Bike(2000, 30,
            new Engine(10, 1000, 2)))),
    MOTOBIKE(new BaseVehicleInfo(new Motobike(2000, 200,
            new Engine(100, 50000, 11))));

    @Getter
    private BaseVehicleInfo info;

    VehicleType(BaseVehicleInfo info) {
        this.info = info;
    }


}
