package ru.job4j.tracker;

public class Train implements Vehicle {

    public void move() {
        System.out.println("Постой, паровоз, не стучите, колёса...");
    }

    public void passengers(int passengers) {
        System.out.println("В вагоне находится: " + passengers + " пассажиров"
                + System.lineSeparator());
    }

    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        /* TODO
        * научиться вводить разное количество пассажиров для каждого транспорта
        * next level: научиться принимать количество пассажиров из консоли
        * для каждого транспортного средства
         */
        Vehicle[] vehiceles = new Vehicle[] {bus, train, plane};
        for (Vehicle transport : vehiceles) {
            transport.move();
            transport.passengers(5);
        }
        System.out.println(vehiceles);
    }
}
