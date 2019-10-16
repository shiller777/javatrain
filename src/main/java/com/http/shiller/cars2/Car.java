package com.http.shiller.cars2;

import java.util.ArrayList;
import java.util.List;

class Car
{

    private List<CarDetail> details;

    public Car(List<CarDetail> details) {
        this.details = details;
    }

    public boolean isBroken()
    {
        return details.stream().anyMatch(CarDetail::isBroken);
    }

    public boolean isPaintingDamaged()
    {
// MAKE AN IMPLEMENTATION
        return true;
    }

    public static void main(String[] args) {
        List<CarDetail> details = new ArrayList<>();
        details.add(new Door(true));
        details.add(new Tyre(false));
        Car car = new Car(details);
        System.out.println(car.isBroken());
    }
}
