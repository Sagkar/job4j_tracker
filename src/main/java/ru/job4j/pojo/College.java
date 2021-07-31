package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan");
        student.setAdmission("2000-10-10");
        student.setGroup("PM2");
        System.out.print("Student: " + student.getName() + System.lineSeparator()
                + "Date of admission: " + student.getAdmission() + System.lineSeparator()
                + "Group: " + student.getGroup());
    }
}
