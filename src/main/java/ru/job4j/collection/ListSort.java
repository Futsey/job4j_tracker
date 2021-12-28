package ru.job4j.collection;

import java.util.*;

public class ListSort {

    public static int showRsl(String first, String second) {
        int rsl = first.compareTo(second);
        if (rsl <= 0) {
            System.out.println("showRsl: Имя " + first
                    + " больше, чем " + second + ". Значение rsl: " + rsl);
        } else {
            System.out.println("showRsl: Имя " + second
                    + " больше, чем " + first + ". Значение rsl: " + rsl);
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 3, 5, 7, 14, 82);
        System.out.println("До сортировки: " + list);
        Collections.sort(list);
        System.out.println("После сортировки: " + list);

        ListSort first = new ListSort();
        first.showRsl("Gleb", "Bob");
        first.showRsl("Michelangelo", "Walter");
    }
}
