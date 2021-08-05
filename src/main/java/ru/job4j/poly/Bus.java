package ru.job4j.poly;

public class Bus implements  Transport, Vehicle {
    @Override
    public void drive() {

    }

    @Override
    public void passengers(int pass) {

    }

    @Override
    public int refuel(int fuel) {
        return 1;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Drive on road");
    }
}
