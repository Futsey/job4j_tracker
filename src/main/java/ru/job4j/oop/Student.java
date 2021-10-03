package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("tra ta ta");
    }

    public void song() {
        System.out.println("I believe I can fly, i believe i can touch the sky");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
