package ru.job4j.oop;

public class Builder extends Engineer {

    private boolean managementExperience;

    public Builder(String name, String surname, String education, String birthday,
                   String specialization, int workExperience, boolean managementExperience) {
        super(name, surname, education, birthday, specialization, workExperience);
        this.managementExperience = managementExperience;
    }

    public String hammerANail() {
        return null;
    }

    public String hiringWorkers(String allowHire) {
        if (managementExperience) {
            return allowHire;
        }
        return "You have no experience for hiring workers";
    }

    public static void main(String[] args) {
        Builder foreman = new Builder("Greg", "Doe", "high school",
                "01 mdecember 1977",  "electrician", 3, true);
        foreman.getName();
        foreman.getSurname();
        foreman.birthday();
        foreman.education();
        foreman.getSpecialization();
        foreman.getWorkExperience();
        foreman.hiringWorkers("You can hire 2 more man");
    }
}
