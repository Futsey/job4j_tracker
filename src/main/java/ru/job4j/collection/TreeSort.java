package ru.job4j.collection;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSort {

    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<Integer>(Collections.reverseOrder());
        numbers.add(2);
        numbers.add(5);
        numbers.add(2);
        numbers.add(3);
        numbers.add(12);
        numbers.add(6);
        numbers.add(4);
        System.out.println(numbers);
    }
}
