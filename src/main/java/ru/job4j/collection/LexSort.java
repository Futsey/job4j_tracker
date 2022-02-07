package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split("\\.");
        int leftSplitPars = Integer.parseInt(leftSplit[0]);
        String[] rightSplit = right.split("\\.");
        int rightSplitPars = Integer.parseInt(rightSplit[0]);
        return Integer.compare(leftSplitPars, rightSplitPars);
    }
}
