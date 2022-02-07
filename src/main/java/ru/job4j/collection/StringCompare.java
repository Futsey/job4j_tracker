package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String firstString, String secondString) {
        int length = Math.min(firstString.length(), secondString.length());
        for (int i = 0; i < length; i++) {
            if (firstString.charAt(i) != secondString.charAt(i)) {
                return Character.compare(firstString.charAt(i), secondString.charAt(i));
            }
        }
        return Integer.compare(firstString.length(), secondString.length());
    }
}
