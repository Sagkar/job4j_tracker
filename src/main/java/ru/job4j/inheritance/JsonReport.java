package ru.job4j.inheritance;

public class JsonReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return   name + ": name \n"
                + body + ": body";
    }
}
