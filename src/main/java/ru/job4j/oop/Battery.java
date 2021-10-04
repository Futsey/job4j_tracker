package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery batteryOne = new Battery(56);
        Battery batteryTwo = new Battery(3);
        System.out.println("Заряд первой батареи: " + batteryOne.load
                + ".\n Заряд второй батареи: " + batteryTwo.load);
        batteryOne.exchange(batteryTwo);
        System.out.println("Заряд первой батареи: " + batteryOne.load
                + ".\n Заряд второй батареи: " + batteryTwo.load);
    }
}
