package com.http.shiller.cars;

class Car
{
    public void drive() throws Exception {
        Engine engine = new Engine();

        if (engine.getType().equals("electric")) {
            if (engine.isBatteryEmpty()) {
                throw new Exception("Please re-charge me");
            }
        }

        engine.start();
    }
}
