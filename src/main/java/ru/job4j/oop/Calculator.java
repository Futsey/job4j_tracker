package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return x - a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return a / x;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rslSum = calculator.sum(5);
        int rslMult = calculator.multiply(5);
        int rslMinus = calculator.minus(5);
        int rslDiv = calculator.divide(5);
        System.out.println(rslSum);
        System.out.println(rslMult);
        System.out.println(rslMinus);
        System.out.println(rslDiv);
    }
}
