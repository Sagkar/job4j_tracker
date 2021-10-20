package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(accounts)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User keys : users.keySet()) {
            if (keys.getPassport().equals(passport)) {
                rsl = keys;
                break;
            }
            }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> reqs = users.get(user);
            for (Account req : reqs) {
                if (req.getRequisite().equals(requisite)) {
                    return req;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null) {
            if (src.getBalance() - amount >= 0) {
                src.setBalance(src.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}