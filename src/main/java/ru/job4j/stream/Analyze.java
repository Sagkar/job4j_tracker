package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Вычисляет общий средний балл
     * @param stream принимает на вход поток учеников
     * @return double общий средний балл по всем ученикам и предметам
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects()
                .stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Вычисляет общий средний балл ученика по его предметам
     * @param stream принимает на вход поток учеников
     * @return список из объекта Tuple(имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(
                pupil.getName(), pupil.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D))).collect(Collectors.toList());
    }

    /**
     * Вычисляет средний балл по всем предметам для каждого ученика
     * @param stream принимает на вход поток учеников
     * @return список из объекта Tuple(название предмета и средний балл)
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(set -> new Tuple(set.getKey(), set.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Вычисляет лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам
     * @param stream принимает на вход поток учеников
     * @return Объект Tuple(лучшего ученика)
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(
                pupil.getName(), pupil.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream принимает на вход поток учеников
     * @return объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(set -> new Tuple(set.getKey(), set.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}