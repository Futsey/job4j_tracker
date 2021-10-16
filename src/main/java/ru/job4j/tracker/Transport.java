package ru.job4j.tracker;

public interface Transport {

    boolean drive();

    int passengers(int passengers);

    int tankUp(int fuelQuantity);
}
