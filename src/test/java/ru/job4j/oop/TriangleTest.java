package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TriangleTest {

    @Test
    public void area8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void area1dot5() {
        Point a = new Point(0, 3);
        Point b = new Point(4, 0);
        Point c = new Point(5, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(1.5, 0.001));
    }

    @Test
    public void area88dot5() {
        Point a = new Point(1, 15);
        Point b = new Point(6, 4);
        Point c = new Point(23, 2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(88.5, 0.001));
    }

    @Test
    public void area249() {
        Point a = new Point(0, 16);
        Point b = new Point(42, 0);
        Point c = new Point(3, 3);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(249, 0.001));
    }
}