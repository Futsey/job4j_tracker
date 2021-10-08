package ru.job4j.oop;

public class Surgeon extends Doctor {

    private String surgeSpecialization;

    public Surgeon(String name, String surname, String education, String birthday,
                   String specialization, int workExperience, String surgeSpecialization) {
        super(name, surname, education, birthday, specialization, workExperience);
        this.surgeSpecialization = surgeSpecialization;
    }

    public boolean sewOnTheTail(Fox fox) {
        return true;
    }

    public static void main(String[] args) {
        Surgeon viktor = new Surgeon("Viktor", "Batkovich", "university degree",
                "01 january 1999", "Surgeon", 6, "Surgery");
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
