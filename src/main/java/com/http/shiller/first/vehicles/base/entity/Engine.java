package com.http.shiller.first.vehicles.base.entity;

public class Engine {

    private int power;
    private int maxCapacity;

    public Engine() {
        this.power = 100;
        this.maxCapacity = 500000;
    }

    public Engine(int power, int maxCapacity) {
        this.power = power;
        this.maxCapacity = maxCapacity;
    }

    public int getPower() {
        return power;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String toString() {
        return "Engine: {power: " + this.power + "; maxCapacity: " + this.maxCapacity + "}";
    }
}
