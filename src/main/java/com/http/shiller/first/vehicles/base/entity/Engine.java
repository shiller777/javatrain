package com.http.shiller.first.vehicles.base.entity;

public class Engine {

    private int power;
    private int maxDistance;
    private int acceleration;

    public Engine() {
        this.power = 100;
        this.maxDistance = 500000;
        this.acceleration = 5;
    }

    public Engine(int power, int maxDistance, int acceleration) {
        this.power = power;
        this.maxDistance = maxDistance;
        this.acceleration = acceleration;
    }

    public int getPower() {
        return power;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public String toString() {
        return String.format("Engine: {power: %s; maxDistance: %s; acceleration: %s}",
                this.power, this.maxDistance, this.acceleration);
    }
}
