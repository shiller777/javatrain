package com.http.shiller.first.vehicles.base.util;

import com.http.shiller.first.vehicles.Vehicle;
import com.http.shiller.first.vehicles.base.VehicleType;

import com.http.shiller.first.vehicles.base.VehicleType.*;

public class VehicleUtil {
    public static int calculatePrice(Vehicle vehicle) {

        int basePrice;
        switch (vehicle.getType()) {
            case SIMPLE_CAR:
                basePrice = 5000;
                break;
            case TRUCK:
                basePrice = 20000;
                break;
            case SCHOOTER:
                basePrice = 500;
                break;
            case BIKE:
                basePrice = 100;
                break;
            case MOTOBIKE:
                basePrice = 2000;
                break;
            default:
                basePrice = 100;
        }
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

        return vehicle1;
    }



}
