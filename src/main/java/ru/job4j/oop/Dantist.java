package ru.job4j.oop;

public class Dantist extends Doctor {

    private String dantistSpecialization;

    public Dantist() {
        super();
        this.dantistSpecialization = dantistSpecialization;
    }

    public boolean toothOut(Wolf wolf) {
        return true;
    }

    public static void main(String[] args) {
        Dantist toothMaster = new Dantist();
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
