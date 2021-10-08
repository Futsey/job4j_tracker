package ru.job4j.oop;

public class Engineer extends Profession {

    private String specialization;
    private int workExperience;

    public Engineer(String name, String surname, String education, String birthday,
                    String specialization, int workExperience) {
        super(name, surname, education, birthday);
        this.specialization = specialization;
        this.workExperience = workExperience;
    }

    public String getSpecialization() {
        return null;
    }

    public String getWorkExperience() {
        return null;
    }
}
