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

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
