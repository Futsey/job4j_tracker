package ru.job4j.collection.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionInDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionInDiapason.functionInDiapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FunctionInDiapason.functionInDiapason(2, 6, x -> 2 * Math.abs(x) + 3 * x + 1);
        List<Double> expected = Arrays.asList(11D, 16D, 21D, 26D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FunctionInDiapason.functionInDiapason(3, 9, x -> 3 * Math.abs(x));
        List<Double> expected = Arrays.asList(9D, 12D, 15D, 18D, 21D, 24D);
        assertThat(result, is(expected));
    }
}