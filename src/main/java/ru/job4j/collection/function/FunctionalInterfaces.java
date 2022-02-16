package ru.job4j.collection.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);

        BiPredicate<Integer, String> biPred = (i, s) -> (i % 2 == 0 || map.get(i).length() == 4);

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());

        Consumer<String> con = (s) -> System.out.println(s);

        Function<String, String> func = s -> s.toUpperCase(Locale.ROOT);
    }
}
