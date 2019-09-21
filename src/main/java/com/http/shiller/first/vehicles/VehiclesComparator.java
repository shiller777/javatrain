package com.http.shiller.first.vehicles;

import java.util.Comparator;

public class VehiclesComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return vehicle1.compareTo(vehicle2);
    }
}
