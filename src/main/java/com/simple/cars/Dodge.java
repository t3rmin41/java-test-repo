package com.simple.cars;

import com.simple.Car;

public class Dodge implements Car {

    @Override
    public String getManufacturer() {
        return "Ford";
    }

    @Override
    public double getMaxSpeed() {
        return 120;
    }

    @Override
    public String getSpeedUnits() {
        return "mph";
    }
}
