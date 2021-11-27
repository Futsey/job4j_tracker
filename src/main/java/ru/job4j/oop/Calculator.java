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
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rslSum = Calculator.sum(5);
        int rslMult = calculator.multiply(5);
        int rslMinus = Calculator.minus(5);
        int rslDiv = calculator.divide(5);
        int rslSumAll = calculator.sumAllOperation(5);
        System.out.println("Method sum: " + rslSum);
        System.out.println("Method multiply: " + rslMult);
        System.out.println("Method minus: " + rslMinus);
        System.out.println("Method divide: " + rslDiv);
        System.out.println("Method sumAllOperation: " + rslSumAll);
    }
}
