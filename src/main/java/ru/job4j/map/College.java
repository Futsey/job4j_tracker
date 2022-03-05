package ru.job4j.map;

import ru.job4j.bank.User;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Класс описывает оперции, проводимые над классами Student:
 * @see Student
 * и Subject
 * @see Subject
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class College {

    /**
     * Все объекты класса Student для удобства помещены в коллекцию Map:
     * @param students
     * находятся в
     */
    private final Map<Student, Set<Subject>> students;

    /**
     * Для автоматической инициализации переменных
     * конструктор явно изменен в конструктор с входным параметром students:
     * @param students
     */
    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    /**
     * Метод реализует поиск по значению поля account в классе Student:
     * @see Student
     * @param account
     */
    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(a ->  a.getAccount().equals(account))
                .findFirst();
    }

    /**
     * Метод реализует поиск по значению поля name в классе Student:
     * @see Student
     * Поиск производится по ключевому идентификатору account:
     * @param account
     * @param name
     */

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            return students.get(a.get())
                    .stream()
                    .filter(el -> name.equals(el.getName()))
                    .findFirst();
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english);
    }
}