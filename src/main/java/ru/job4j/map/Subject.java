package ru.job4j.map;

import java.util.Objects;

/**
 * Класс является моделью данных с двумя параметрами name, score:
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class Subject {

    private String name;

    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Subject{"
                + "name='" + name + '\''
                + ", score=" + score
                + '}';
    }
}
