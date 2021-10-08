package ru.job4j.oop;

public class Programmer extends Engineer {

    private String programmerSkills;
    private String gitLink;

    public Programmer(String programmerSkills, String gitLink) {
        super();
        this.programmerSkills = programmerSkills;
        this.gitLink = gitLink;
    }

    public String writeTheCode(Pioneer pioneer) {
        return null;
    }

    public boolean procrastination() {
        return true;
    }

    public static void main(String[] args) {
        Programmer javaStudent = new Programmer("ZeroSkill", "https://github.com/Futsey");
        Pioneer petya = new Pioneer();
        javaStudent.getName();
        javaStudent.getSurname();
        javaStudent.birthday();
        javaStudent.education();
        javaStudent.getSpecialization();
        javaStudent.getWorkExperience();
        javaStudent.writeTheCode(petya);
        javaStudent.procrastination();
    }
}
