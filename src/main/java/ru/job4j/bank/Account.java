package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банковской системы на стороне банка по двум параметрам: реквизиты и баланс
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class Account {
    /**
     * У пользователя банковской системы на стороне банка есть два параметра: реквизиты и баланс
     */
    private String requisite;
    private double balance;

    /**
     * Для автоматической инициализации переменных конструктор явно изменен
     * на конструктор с указанием полей реквизитов и баланса
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для чтения реквизитов пользователя
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для записи реквизитов пользователя
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения баланса счета пользователя
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для изменения баланса счета пользователя
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределяем метод сравнения реквизитов пользователя
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределяем метод чтобы найти паспорт в коллекции.
     * Согласно рукописи Д.Блоха "Вы должны переопределить hashCode() в каждом классе,
     * который переопределяет equals(). Несоблюдение этого требования приведет
     * к нарушению общего договора для Object.hashCode(),
     * что предотвратит правильное функционирование вашего класса в сочетании со всеми коллекциями на основе хешей,
     * включая HashMap, HashSet и Hashtable."
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
