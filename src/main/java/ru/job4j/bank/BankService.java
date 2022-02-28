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
     * Метод для добавления пользователя в систему.
     * В аргументе принимаем экземпляр класса
     * @see User
     */
    public void addUser(User user) {
        List<Account> acc = new ArrayList<Account>();
        users.putIfAbsent(user, acc);
    }

    /**
     * Метод для удаления пользователя из системы.
     * В аргументе (в качестве ключа нашего списка) принимаем экземпляр класса
     * @see User
     * По ключу стандартным методом Map.remove удаляем пользователя
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * Метод для добавления аккаунта пользователя в систему.
     * В аргументах принимаем экземпляр класса
     * @see Account
     * и аргумент паспорт типа String, данные которого будут добавлены в систему через метод
     * {@link #findByPassport(String)}
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
     * В аргументах принимаем поле паспорт типа String
     * После проверки на наличие введенных данных в системе
     * @return паспортные данные
     * или значение null, если пользователь не найден
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }
/* OUTDATE CODE
    public User findByPassport(String passport) {
        for (User el : users.keySet()) {
            if (passport.equals(el.getPassport())) {
                return el;
            }
        }
        return null;
    }
 */

    /**
     * Метод для поиска пользователя в системе по реквизитам
     * В аргументах принимаем поле паспорт типа String и поле реквизиты типа String
     * @return аккаунт пользователя (если такой существует в системе)
     * или значение null, если пользователь не найден
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
/* OUTDATE CODE
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
     */

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
