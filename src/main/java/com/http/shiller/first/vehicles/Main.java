package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.Truck;
import com.http.shiller.first.vehicles.base.VehicleType;
import com.http.shiller.first.vehicles.base.util.VehicleUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.SIMPLE_CAR)));
    }
}
