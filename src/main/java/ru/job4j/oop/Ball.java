package ru.job4j.oop;

public class Ball {

    public Ball tryRun(boolean condition) {
        boolean result = false;
        if (!condition) {
            System.out.println("RIP: Kolobok. Bright memory of this yeast ball");
        } else {
            System.out.println("Kolobok run away!!!");
        }
        return null;
    }
}
