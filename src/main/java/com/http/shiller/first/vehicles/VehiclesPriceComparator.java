package com.http.shiller.first.vehicles;

import com.http.shiller.first.vehicles.base.util.VehicleUtil;

import java.util.Comparator;

public class VehiclesPriceComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        if (VehicleUtil.calculatePrice(vehicle1) > VehicleUtil.calculatePrice(vehicle2)) {
            return 1;
        } else {
            if (VehicleUtil.calculatePrice(vehicle1) == VehicleUtil.calculatePrice(vehicle2)) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
