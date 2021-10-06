package ru.job4j.oop;

import com.sun.source.tree.IfTree;

public class Triangle {

        private Point first;
        private Point second;
        private Point third;

        public Triangle(Point ap, Point bp, Point cp) {
            this.first = ap;
            this.second = bp;
            this.third = cp;
        }

        public double semiPerimeter(double a, double b, double c) {
            double semiPerimeter = (a + b + c) / 2;
            return semiPerimeter;
        }

        public boolean exist(double ab, double ac, double bc) {
            return (ab + ac) > bc && (ab + bc) > ac && (bc + ac) > ab;
        }

        public double area() {
            double result = 0;
            double ab = first.distance(second);
            double ac = first.distance(third);
            double bc = second.distance(third);
            if (this.exist(ab, ac, bc)) {
                double p = semiPerimeter(ab, ac, bc);
                result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
            }
            return result;
        }
}

