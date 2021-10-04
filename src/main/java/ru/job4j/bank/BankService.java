package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user.getPassport())) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!user.equals(null)) {
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
            }
            }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            List<Account> reqs = users.get(findByPassport(passport));
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
        if (!src.equals(null) && !dest.equals(null)) {
            if (src.getBalance() - amount >= 0) {
                dest.setBalance(dest.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}