package com.http.shiller.first.vehicles.base.exceptions;

public class OutOfMaxCapacityException extends Exception {

    public OutOfMaxCapacityException() {
        System.out.println("OutOfMaxCapacityException:");
        printStackTrace();
    }
}
