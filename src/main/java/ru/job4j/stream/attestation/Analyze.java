package ru.job4j.stream.attestation;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(value -> value.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(
                        value.getName(),
                        value.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(value -> value.getSubjects()
                        .stream())
                        .collect(Collectors.groupingBy(
                                Subject::getName,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)))
                        .entrySet()
                        .stream()
                        .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                        .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(
                        value.getName(),
                        value.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .sum()))
                .max((n1, n2) -> n1.getScore() > n2.getScore() ? 1 : -1)
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(value -> value.getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .max((n1, n2) -> n1.getScore() > n2.getScore() ? 1 : -1)
                .orElse(null);
    }
}