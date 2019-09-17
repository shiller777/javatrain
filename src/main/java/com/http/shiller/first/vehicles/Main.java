package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.SimpleCar;
import com.http.shiller.first.vehicles.base.Truck;
import com.http.shiller.first.vehicles.base.VehicleType;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxCapacityException;
import com.http.shiller.first.vehicles.base.util.VehicleUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.SIMPLE_CAR)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.TRUCK)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.MOTOBIKE)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.BIKE)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.SCHOOTER)));

        Vehicle vehicle1 = new SimpleCar(2000, 1001, 4500, 5000,
                new Engine(150, 400000));
        Vehicle vehicle2 = new SimpleCar(1999, 10010, 4000, 5000,
                new Engine(200, 450000));
        Vehicle vehicle3 = new SimpleCar(1999, 10010, 4700, 4500,
                new Engine(200, 450000));

        System.out.println(VehicleUtil.compare(vehicle1, vehicle2));


        Vehicle exceptionVehicle = new SimpleCar(2000, 400001, 4500, 5000,
                new Engine(150, 400000));
        try {
            System.out.println("Average speed: " + exceptionVehicle.go(5, 15));
        } catch (OutOfMaxCapacityException e) {
            e.printStackTrace();
        }

        Vehicle exceptionVehicle2 = new SimpleCar(2000, 400000, 4500, 5000,
                new Engine(150, 400000));
        try {
            System.out.println("Average speed: " + exceptionVehicle2.go(5, 15));
            System.out.println("Average speed: " + exceptionVehicle2.go(5, 15));
        } catch (OutOfMaxCapacityException e) {
            e.printStackTrace();
        }


        System.out.println(VehicleUtil.compareSpeed(10, 100, vehicle1, vehicle2, vehicle3));


    }
}
