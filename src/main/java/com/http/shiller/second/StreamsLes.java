package com.http.shiller.second;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.Bike;
import com.http.shiller.first.vehicles.base.Motobike;
import com.http.shiller.first.vehicles.base.Truck;
import com.http.shiller.first.vehicles.base.entity.Engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamsLes {
    public static void main(String[] args) {
        compare();
    }

    private static void thread() {
        Thread thread = new Thread(() -> {
            System.out.println("Runnable");
        });
        thread.start();
    }

    private static void matcherExmpl() {
        String str = "QQQ WWW EEEEFFF";
        String pattern = "EEE";
        Matcher matcher = new Matcher() {
            @Override
            public double match(String base, String pattern) {
                if (base.equals(pattern)) {
                    return 1;
                }
                if (base.contains(pattern)) {
                    return 0.5;
                }
                return 0;
            }

            @Override
            public boolean anyMatch(String base, String pattern) {
                return match(base, pattern) > 0;
            }
        };
        double match = MatchUtil.match(matcher, str, pattern);
        System.out.println(match);
    }

    private static void compare() {
        Bike bike = new Bike(300);
        Truck truck = new Truck(2000, 200, 200, 100, new Engine());
        Motobike motobike = new Motobike(2001, 100, 1000, new Engine());

        Vehicle[] vehicles = {bike, truck, motobike};
        List<Vehicle> vehicleList = Arrays.asList(vehicles);
        Comparator<Vehicle> comparator = Vehicle::compareTo;
        Collections.sort(vehicleList, comparator);

        vehicleList.stream()
                .filter((veh) -> veh.getBasePrice() > 200)
                .map(Vehicle::getWeight)
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException();
                });
    }
}
