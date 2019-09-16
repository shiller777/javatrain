package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.SimpleCar;
import com.http.shiller.first.vehicles.base.Truck;
import com.http.shiller.first.vehicles.base.VehicleType;
import com.http.shiller.first.vehicles.base.util.VehicleUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.SIMPLE_CAR)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.TRUCK)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.MOTOBIKE)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.BIKE)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.SCHOOTER)));

        Vehicle vehicle1 = new SimpleCar(2000, 1001, 4500, 5000);
        Vehicle vehicle2 = new SimpleCar(1999, 10010, 4000, 5000);

        System.out.println(VehicleUtil.compare(vehicle1, vehicle2));
    }
}
