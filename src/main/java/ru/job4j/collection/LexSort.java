package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] num1 = o1.split("\\.");
        String[] num2 = o2.split("\\.");
        return Integer.compare(Integer.parseInt(num1[0]), Integer.parseInt(num2[0]));
    }
}
