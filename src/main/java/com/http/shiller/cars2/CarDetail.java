package com.http.shiller.cars2;

abstract class CarDetail {
    private boolean isBroken;

    public CarDetail(boolean isBroken) {
        this.isBroken = isBroken;
    }

    public boolean isBroken() {
        return isBroken;
    }
}
