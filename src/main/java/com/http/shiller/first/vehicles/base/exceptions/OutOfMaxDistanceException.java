package com.http.shiller.first.vehicles.base.exceptions;

public class OutOfMaxDistanceException extends Exception {

    public OutOfMaxDistanceException(String message) {
        System.out.println("OutOfMaxDistanceException:" + message);
        printStackTrace();
    }
}
