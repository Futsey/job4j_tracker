package ru.job4j.collection.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInDiapason {

    public static List<Double> functionInDiapason(int start, int end, Function<Double, Double> func) {
        List<Double> diapasonList = new ArrayList<>();
        for (double d = start; d < end; d++) {
            diapasonList.add(func.apply(d));
        }
        return diapasonList;
    }
}
