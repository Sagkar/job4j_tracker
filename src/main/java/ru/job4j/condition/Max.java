package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        return left <= right ? right : left;
    }

    public static int max(int first, int second, int third) {
        return third <= max(first, second) ? max(first, second) : third;
    }

    public static int max(int first, int second, int third, int fourth) {
        return fourth <= max(first, second, third) ? max(first, second, third) : fourth;
    }
}
