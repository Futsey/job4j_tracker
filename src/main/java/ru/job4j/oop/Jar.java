package ru.job4j.oop;

public class Jar {

    private int value;

    public Jar(int size) {
        this.value = size;
    }

    public void pour(Jar another, Jar anotherOne) {
        this.value = this.value + another.value + anotherOne.value;
        another.value = 0;
        anotherOne.value = 1;
    }

    public static void main(String[] args) {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        Jar third = new Jar(6);
        System.out.println("first : " + first.value + ". second : " + second.value
                + ".\n third : " + third.value);
        first.pour(second, third);
        System.out.println("first : " + first.value + ". second : " + second.value
                + ".\n third : " + third.value);
    }
}
