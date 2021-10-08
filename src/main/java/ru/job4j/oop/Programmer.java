package ru.job4j.oop;

public class Programmer extends Engineer {

    private String gitLink;

    public Programmer(String name, String surname, String education, String birthday,
                      String specialization, int workExperience, String gitLink) {
        super(name, surname, education, birthday, specialization, workExperience);
        this.gitLink = gitLink;
    }

    public String writeTheCode(Pioneer pioneer) {
        return null;
    }

    public boolean procrastination() {
        return true;
    }

    public static void main(String[] args) {
        Programmer javaStudent = new Programmer("Andrew", "Petrushin", "university degree",
                "09 may",  "Java Dev", 0, "https://github.com/Futsey");
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
