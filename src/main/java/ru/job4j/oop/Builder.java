package ru.job4j.oop;

public class Builder extends Engineer {

    private String buildSpecialization;
    private boolean managementExperience;

    public Builder(String buildSpecialization, boolean managementExperience) {
        super();
        this.buildSpecialization = buildSpecialization;
        this.managementExperience = managementExperience;
    }

    public String hammerANail() {
        return null;
    }

    public int numberOfWorkers(int numberOfWorkers) {
        if (managementExperience) {
            return numberOfWorkers;
        }
        return 0;
    }

    public static void main(String[] args) {
        Builder foreman = new Builder("Electrician", true);
        foreman.getName();
        foreman.getSurname();
        foreman.birthday();
        foreman.education();
        foreman.getSpecialization();
        foreman.getWorkExperience();
        foreman.numberOfWorkers(5);
    }
}
