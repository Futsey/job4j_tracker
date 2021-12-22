package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> acc = new ArrayList<Account>();
        users.putIfAbsent(user, acc);
    }

    public void deleteUser(User user) {
        if (users.containsKey(user)) {
            users.clear();
        }
    }

    public void addAccount(String passport, Account account) {
        List<Account> newAcc = users.get(findByPassport(passport));
        if (!newAcc.contains(account)) {
            newAcc.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User el : users.keySet()) {
            if (passport.equals(el.getPassport())) {
                return el;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if ((srcAcc != null) && (destAcc != null) && (srcAcc.getBalance() >= amount)) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
        }
        return true;
    }
}
