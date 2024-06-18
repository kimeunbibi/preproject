package com.example.demo;

public class Car {

    private String carName;
    private String location = "-";
    private int step = 0;
    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public String getLocation() {
        return location;
    }

    public int getStep() {
        return step;
    }

    public void moveForward(){
        this.location += "-";
        this.step++;
    }

    @Override
    public String toString() {
        return carName + " : " + location;
    }
}
