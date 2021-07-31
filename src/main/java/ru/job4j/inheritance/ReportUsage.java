package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        JsonReport report = new JsonReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}