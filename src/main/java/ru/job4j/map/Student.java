package ru.job4j.map;

import java.util.Objects;

/**
 * Класс является моделью данных с тремя параметрами name, account, score:
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class Student {

    private String name;
    private String surname;
    private String account;
    private int score;
    private String group;

    public Student(String name, String surname, String account, int score, String group) {
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.score = score;
        this.group = group;
    }

    public Student(String name, String account, String group) {
        this.name = name;
        this.account = account;
        this.group = group;
    }

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getScore() {
        return score;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score && Objects.equals(name, student.name)
                && Objects.equals(surname, student.surname)
                && Objects.equals(account, student.account) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, account, score, group);
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", account='" + account + '\''
                + ", score=" + score
                + ", group='" + group + '\''
                + '}';
    }
}
