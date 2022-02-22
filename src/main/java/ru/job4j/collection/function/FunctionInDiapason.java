package ru.job4j.collection.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInDiapason {
    private static List<Double> diapasonList = new ArrayList<>();

    public static List<Double> functionInDiapason(int start, int end, Function<Double, Double> func) {
        for (double d = start; d < end; d++) {
            diapasonList.add(func.apply(d));
        }
        return diapasonList;
    }
}
