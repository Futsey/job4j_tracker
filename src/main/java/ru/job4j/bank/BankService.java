package ru.job4j.bank;

import java.util.*;

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
        Optional<User> accExist = findByPassport(passport);
        if (accExist.isPresent()) {
            List<Account> newAcc = users.get(accExist.get());
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

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод для поиска пользователя в системе по реквизитам
     * В аргументах принимаем поле паспорт типа String и поле реквизиты типа String
     * @return аккаунт пользователя (если такой существует в системе)
     * или значение null, если пользователь не найден
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод для пополнения баланса пользователя со счета другого пользователя, где задействован метод:
     *{@link #findByRequisite(String, String)}, с помощью которого находим пользователей
     * Далее проводим валидацию на наличие необходимой суммы и оформляем списание\зачисление
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if ((srcAcc.isPresent()) && (destAcc.isPresent()) && (srcAcc.get().getBalance() >= amount)) {
                srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
                destAcc.get().setBalance(destAcc.get().getBalance() + amount);
                return true;
                }
        return false;
    }
}