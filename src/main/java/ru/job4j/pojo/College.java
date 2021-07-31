package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan");
        student.setAdmission("2000-10-10");
        student.setGroup("PM2");
        System.out.print("Student: " + student.getName() + "\n"
                + "Date of admission: " + student.getAdmission() + "\n"
                + "Group: " + student.getGroup());
    }
}
