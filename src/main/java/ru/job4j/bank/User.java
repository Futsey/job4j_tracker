package ru.job4j.bank;

import java.util.Objects;
/**
 * Класс описывает пользователя банковской системы на стороне клиента по двум параметрам: имя и паспорт
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class User {
    /**
     * У пользователя банковской системы на стороне клиента есть два параметра: имя и паспорт
     */
    private String passport;
    private String username;

    /**
     * Для автоматической инициализации переменных конструктор явно изменен
     * на конструктор с указанием полей имени и паспорта
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для записи личных данных пользователя (паспорт пользователя)
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для чтения личных данных пользователя (паспорт пользователя)
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для записи личных данных пользователя (имя пользователя)
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод для чтения личных данных пользователя (имя пользователя)
     */
    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
