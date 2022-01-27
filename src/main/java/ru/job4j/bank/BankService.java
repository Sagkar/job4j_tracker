package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 */
public class BankService {
    /**
     * Хранение пользователей и привязанных к ним счетов
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя
     * и если такого пользователя ещё нет, добавляет его как нового
     * @param user пользователь который добавляется в коллекцию
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавляет новый счет к пользователю, если такого счёта у ещё нет
     * @param passport паспорт пользователя, к которому привязывается счёт
     * @param account счёт который привязывается к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(accounts)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Этот метод осуществляет поиск пользователя по паспорту
     * @param passport номер паспорта искомого пользователя
     * @return возвращает пользователя или null, если ничего не найдено
     */
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

    /**
     * Метод ищет счёт пользователя по реквизитам
     * @param passport паспорт пользователя, счёт которого ищем
     * @param requisite реквизиты искомого счёта
     * @return возвращает счёт пользователя или null,
     * если не найден такой пользователь и счёт
     */
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

    /**
     * Метод осуществляет перевод средств между счетами пользователей
     * @param srcPassport паспорт пользователя, со счета которого будет производиться перевод
     * @param srcRequisite номер счёта, с которого будут перечислены средства
     * @param destPassport паспорт пользователя, которому будет направлен перевод
     * @param destRequisite номер счёта, на который будут перечислены средства
     * @param amount число переводимых средств
     * @return true если перевод прошёл успешно, false если счёт не найден
     * или не хватает средств на счёте с которого осуществляется перевод
     */
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