package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<String>();
        for (String el : origin) {
            check.add(el);
        }
        for (String elText : text) {
            if (!check.contains(elText)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
