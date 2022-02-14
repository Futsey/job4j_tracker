package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] firstArr = o1.split("/");
        String[] secondArr = o2.split("/");
        int compare = secondArr[0].compareTo(firstArr[0]);
        return compare == 0 ? o1.compareTo(o2) : compare;
    }
}
