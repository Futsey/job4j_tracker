package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String firstString, String secondString) {
        int length = 0;
        if (firstString.length() < secondString.length()) {
            length = firstString.length();
        } else {
            length = secondString.length();
        }
        int rsl = 0;
        for (int i = 0; i < length - 1; i++) {
            if (firstString.charAt(i) > secondString.charAt(i)) {
                rsl = 1;
                break;
            } else if (firstString.charAt(i) == secondString.charAt(i)) {
                rsl = 0;
            } else {
                rsl = -1;
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(firstString.length(), secondString.length());
        }
        return rsl;
    }
}
