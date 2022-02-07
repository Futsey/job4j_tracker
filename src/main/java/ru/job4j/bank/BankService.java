package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс описывает банковские операции, которые может совершать класс:
 * @see User
 * Также для совершения банковских операций пользователь должен быть зарегистрирован в системе и иметь:
 * @see Account
 * @author ANDREW PETRUSHIN (JOB4J Project)
 * @version 1.0
 */
public class BankService {
    /**
     * Для идентификации пользователя используется два поля
     * @see User
     * @see Account
     * Так как поля два, для хранения используем коллекцию Map (ключ, значение)
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления пользователя в систему
     */
    public void addUser(User user) {
        List<Account> acc = new ArrayList<Account>();
        users.putIfAbsent(user, acc);
    }

    /**
     * Метод для удаления пользователя из системы
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * Метод для добавления аккаунта пользователя в систему
     */
    public void addAccount(String passport, Account account) {
        User accExist = findByPassport(passport);
        if (accExist != null) {
            List<Account> newAcc = users.get(accExist);
            if (!newAcc.contains(account)) {
                newAcc.add(account);
            }
        }
    }

    /**
     * Метод для поиска пользователя в системе по паспортным данным
     * @return паспортные данные
     */
    public User findByPassport(String passport) {
        for (User el : users.keySet()) {
            if (passport.equals(el.getPassport())) {
                return el;
            }
        }
        return null;
    }

    /**
     * Метод для поиска пользователя в системе по реквизитам
     * @return аккаунт пользователя (если такой существует в системе)
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> account = users.get(user);
            for (Account accToFind : account) {
                if (requisite.equals(accToFind.getRequisite())) {
                    return accToFind;
                }
            }
        }
        return null;
    }

    /**
     * Метод для пополнения баланса пользователя со счета другого пользователя, где задействован метод:
     *{@link #findByRequisite(String, String)}, с помощью которого находим пользователей
     * Далее проводим валидацию на наличие необходимой суммы и оформляем списание\зачисление
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if ((srcAcc != null) && (destAcc != null) && (srcAcc.getBalance() >= amount)) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
        }
        return false;
    }
}
