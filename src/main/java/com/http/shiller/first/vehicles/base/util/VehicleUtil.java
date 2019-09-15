package com.http.shiller.first.vehicles.base.util;

import com.http.shiller.first.vehicles.Vehicle;

public class VehicleUtil {
    public static int calculatePrice(Vehicle vehicle) {
        int basePrice = vehicle.getBasePrice();
        double yearCoeff = 1 + ((vehicle.getProducedYear() - 1950) * 0.01);
        double milesCoeff = 1;
        if (vehicle.getMiles() < 1000) {
            milesCoeff = 2;
        }
        if (vehicle.getMiles() > 10000) {
            milesCoeff = 0.7;
        }
        return (int)(basePrice * yearCoeff * milesCoeff);
    }

    public static Vehicle compare(Vehicle vehicle1, Vehicle vehicle2) {
        int years = vehicle1.getProducedYear() - vehicle2.getProducedYear();
        if (years > -3 && years < 3) {
            if (vehicle1.getMiles() < vehicle2.getMiles()) {
                return vehicle1;
            } else {
                return vehicle2;
            }
        } else {
            if (years > 0) {
                return vehicle1;
            } else {
                return vehicle2;
            }
        }
    }

}
