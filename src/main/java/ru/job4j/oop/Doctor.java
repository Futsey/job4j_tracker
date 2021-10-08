package ru.job4j.oop;

public class Doctor extends Profession {

    private String specialization;
    private int workExperience;

    public Doctor(String name, String surname, String education, String birthday,
                  String specialization, int workExperience) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
        this.workExperience = workExperience;
    }

    public String getSpecialization() {
        return null;
    }

    public int getWorkExperience() {
        return 0;
    }
}
