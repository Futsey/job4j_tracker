package ru.job4j.oop;

public class Surgeon extends Doctor {

    private String surgeSpecialization;

    public Surgeon() {
        super();
        this.surgeSpecialization = surgeSpecialization;
    }

    public boolean sewOnTheTail(Fox fox) {
        return true;
    }

    public static void main(String[] args) {
        Surgeon viktor = new Surgeon();
        Fox fireTail = new Fox();
        viktor.getName();
        viktor.getSurname();
        viktor.birthday();
        viktor.education();
        viktor.getSpecialization();
        viktor.getWorkExperience();
        viktor.sewOnTheTail(fireTail);
    }
}
