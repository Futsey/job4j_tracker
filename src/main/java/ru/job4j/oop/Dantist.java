package ru.job4j.oop;

public class Dantist extends Doctor {

    private String dantistSpecialization;

    public Dantist(String name, String surname, String education, String birthday,
                   String specialization, int workExperience, String dantistSpecialization) {
        super(name, surname, education, birthday, specialization, workExperience);
        this.dantistSpecialization = dantistSpecialization;
    }

    public boolean toothOut(Wolf wolf) {
        return true;
    }

    public static void main(String[] args) {
        Dantist toothMaster = new Dantist("Nafanya", "Batkovich", "university degree",
                "01 january 2002", "Dantist", 1, "surgery");
        Wolf sharpTooth = new Wolf();
        toothMaster.getName();
        toothMaster.getSurname();
        toothMaster.birthday();
        toothMaster.education();
        toothMaster.getSpecialization();
        toothMaster.getWorkExperience();
        toothMaster.toothOut(sharpTooth);
    }
}
