package ru.job4j.stream.carddeck;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {

        String[] levels = {"level 1", "level 2", "level 3"};
        String[] tasks = {"task 1", "task 2", "task 3", "task 4"};
        Stream.of(levels)
                .flatMap(level -> Stream.of(tasks)
                        .map(task -> "Stream.of: " + level + " " + task))
                .forEach(System.out::println);

        Arrays.stream(levels)
                .flatMap(level -> Stream.of(tasks)
                        .map(task -> "Arrays.stream: " + level + " " + task))
                .forEach(System.out::println);

        Stream.of(Suit.values())
                .flatMap(level -> Stream.of(Value.values())
                .map(task -> "Stream.of(enum): " + level + " " + task))
                .forEach(System.out::println);

/* OUTDATE CODE
        String[] levels = {"level 1", "level 2", "level 3"};
        String[] tasks = {"task 1", "task 2", "task 3", "task 4"};
        for (String level : levels) {
            for (String task : tasks) {
                System.out.println(level + " " + task);
            }
        }
         */
    }
}
