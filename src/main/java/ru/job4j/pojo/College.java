package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student andrew = new Student();
        andrew.setNameSurnameMiddleName("Andrew ibn Sergey Petrushin =)))");
        andrew.setGroup("job4j (trainee)");
        andrew.setFrashmanYear(2021);

        System.out.println("ФИО студента: " + andrew.getNameSurnameMiddleName());
        System.out.println("Зачислен в группу: " + andrew.getGroup());
        System.out.println("Год поступления: " + andrew.getFrashmanYear());
    }
}
