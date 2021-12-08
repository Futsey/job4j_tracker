package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<String>();
        for (Task number : list) {
                numbers.add(number.getNumber());
        }
        return numbers;
    }
}
