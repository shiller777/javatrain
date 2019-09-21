package com.http.shiller.first.vehicles.base;

import com.http.shiller.first.vehicles.base.exceptions.OutOfMaxDistanceException;

public interface Features {
    int go(int seconds) throws OutOfMaxDistanceException;

    void stop();
}
