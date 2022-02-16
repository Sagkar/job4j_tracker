package ru.job4j.map;

import java.util.Map;
import java.util.Set;

public class OldCollege {
    private final Map<OldStudent, Set<OldSubject>> students;

    public OldCollege(Map<OldStudent, Set<OldSubject>> students) {
        this.students = students;
    }

    public static void main(String[] args) {
        Map<OldStudent, Set<OldSubject>> students =
                Map.of(new OldStudent("Student", "000001", "201-18-15"),
                Set.of(
                        new OldSubject("Math", 70),
                        new OldSubject("English", 85)
                )
        );
        OldCollege college = new OldCollege(students);
        OldStudent student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        OldSubject english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.getScore());
    }

    public OldStudent findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    public OldSubject findBySubjectName(String account, String name) {
        OldStudent a = findByAccount(account);
        if (a != null) {
            return students.get(a)
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
}