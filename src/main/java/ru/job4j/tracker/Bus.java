package ru.job4j.tracker;

import java.util.Scanner;

public class Bus implements Transport {

    @Override
    public boolean drive() {
        System.out.println("Привести в движение автобус?"
        + System.lineSeparator() + "1. Завести автобус"
        + System.lineSeparator() + "2. Заглушить двигатель");
        System.out.print("Select: ");
        boolean run = false;
        Scanner scanner = new Scanner(System.in);
        int select = Integer.parseInt(scanner.nextLine());
        if (select == 1) {
            run = true;
        } else if (select == 2) {
            run = false;
        } else {
            System.out.println("Вы ввели неверное значение. Это автобус, он либо 1 либо 2 понимает...");
        }
        return run;
    }

    @Override
    public int passengers(int passengers) {
        System.out.println("В салоне находится: " + passengers + "пассажиров");
        return 0;
    }

    @Override
    public int tankUp(int fuelQuantity) {
        int fuelPrice = 45;
        int toPay = fuelPrice * fuelQuantity;
        return toPay;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.drive();
        bus.passengers(10);
        bus.tankUp(10);
        System.out.println(bus);
    }
}
