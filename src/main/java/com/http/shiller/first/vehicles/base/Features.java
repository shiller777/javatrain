package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxCapacityException;

public interface Features {
    double go(int seconds, int miles) throws OutOfMaxCapacityException;

    void stop();
}
