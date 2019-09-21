package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.SimpleCar;
import com.http.shiller.first.vehicles.base.VehicleType;
import com.http.shiller.first.vehicles.base.entity.Engine;
import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;
import com.http.shiller.first.vehicles.base.util.VehicleUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.SIMPLE_CAR)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.TRUCK)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.MOTOBIKE)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.BIKE)));
        System.out.println(VehicleUtil.calculatePrice(Vehicle.getObjectByType(VehicleType.SCHOOTER)));

        Vehicle vehicle1 = new SimpleCar(2000, 1001, 4500, 5000,
                new Engine(150, 400000, 10));
        Vehicle vehicle2 = new SimpleCar(1999, 10010, 4000, 5000,
                new Engine(200, 450000, 8));
        Vehicle vehicle3 = new SimpleCar(1999, 10010, 4700, 4500,
                new Engine(200, 450000, 7));
        Vehicle vehicle4 = new SimpleCar(1980, 10010, 15000, 3500,
                new Engine(200, 450000, 15));
        Vehicle vehicle5 = new SimpleCar(1966, 10010, 3000, 6500,
                new Engine(200, 450000, 7));
        Vehicle vehicle6 = new SimpleCar(1966, 10010, 3001, 6500,
                new Engine(200, 450000, 7));
        Vehicle vehicle7 = new SimpleCar(1966, 10010, 3002, 6500,
                new Engine(200, 450000, 7));
        Vehicle vehicle8 = new SimpleCar(1966, 10010, 3003, 6500,
                new Engine(200, 450000, 7));
        Vehicle vehicle9 = new SimpleCar(1966, 10010, 3004, 6500,
                new Engine(200, 450000, 7));
        Vehicle vehicle10 = new SimpleCar(1966, 10010, 3005, 6500,
                new Engine(200, 450000, 7));




        Vehicle exceptionVehicle = new SimpleCar(2000, 400001, 4500, 5000,
                new Engine(150, 400000, 10));
        try {
            System.out.println("Average distance: " + exceptionVehicle.go(5));
        } catch (OutOfMaxDistanceException e) {
            e.printStackTrace();
        }

        Vehicle exceptionVehicle2 = new SimpleCar(2000, 400000, 4500, 5000,
                new Engine(150, 400000, 9));
        try {
            System.out.println("Average distance: " + exceptionVehicle2.go(5));
            System.out.println("Average distance: " + exceptionVehicle2.go(5));
        } catch (OutOfMaxDistanceException e) {
            e.printStackTrace();
        }


        System.out.println(VehicleUtil.compareDistance(10, vehicle1, vehicle2, vehicle3));

        System.out.println("==========================================");


        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
        vehicles.add(vehicle5);
        vehicles.add(vehicle6);
        vehicles.add(vehicle7);
        vehicles.add(vehicle8);
        vehicles.add(vehicle9);
        vehicles.add(vehicle10);
        vehicles.sort(new VehiclesComparator().thenComparing(new VehiclesPriceComparator()));

        vehicles.forEach(System.out::println);

        System.out.println("==========================================");


        List<Vehicle> vehicles2 = new ArrayList<>();
        vehicles2.add(vehicle1);
        vehicles2.add(vehicle2);
        vehicles2.add(vehicle3);
        vehicles2.add(vehicle4);
        vehicles2.add(vehicle5);
        vehicles2.add(vehicle6);
        vehicles2.add(vehicle7);
        vehicles2.add(vehicle8);
        vehicles2.add(vehicle9);
        vehicles2.add(vehicle10);

        vehicles2.sort(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle vehicle1, Vehicle vehicle2) {
                if (vehicle1.getMiles() > vehicle2.getMiles()) {
                    return 1;
                } else {
                    if (vehicle1.getMiles() == vehicle2.getMiles()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });

        vehicles2.forEach(System.out::println);
    }
}
