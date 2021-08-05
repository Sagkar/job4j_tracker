package ru.job4j.poly;

public class Bus implements  Transport, Vehicle {
    private int seats = 15;

    @Override
    public void drive() {
        System.out.println("Vrrrrr");
    }

    @Override
    public void passengers(int pass) {
        int freeSeats = seats - pass;
    }

    @Override
    public double refuel(int fuel) {
        return fuel * 1.5;
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Drive on road");
    }
}
