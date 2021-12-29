package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int index = 0;
        int rsl;
        do {
            rsl = Character.compare(o1.charAt(index), o2.charAt(index));
            index++;
            if (rsl != 0) {
                break;
            }
        }
        while (index < o1.length());
        if (rsl == 0) {
            return Integer.compare(o1.length(), o2.length());
        }
        return rsl;
    }
}
