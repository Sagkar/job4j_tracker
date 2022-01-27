package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String el1 = o1.split("/")[0];
        String el2 = o2.split("/")[0];
        int rsl = el1.compareTo(el2);
        return rsl == 0 ? o1.compareTo(o2) : el2.compareTo(el1);
    }
}
