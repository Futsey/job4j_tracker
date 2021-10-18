package ru.job4j.tracker;

public class Plane implements Vehicle {

    public void move() {
        System.out.println("Под крылом самолета о чём-то поёт зелёное море тайги...");
    }

    public void passengers(int passengers) {
        System.out.println("В самолете находится: " + passengers + " пассажиров"
                + System.lineSeparator());
    }
}
