package ru.job4j.poly;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle[] arr = {bus, plane, train};
        for (Vehicle a: arr) {
            a.move();
        }
    }
}
