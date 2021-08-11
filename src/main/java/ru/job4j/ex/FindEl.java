package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] ==  key) {
                rsl = i;
                return rsl;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not exist");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = new String[1];
        try {
            indexOf(array,"nullValue");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}