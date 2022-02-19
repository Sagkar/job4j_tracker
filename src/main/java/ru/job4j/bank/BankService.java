package ru.job4j.bank;

import java.util.*;

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
     *
     * @param user пользователь который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавляет новый счет к пользователю, если такого счёта у ещё нет
     *
     * @param passport паспорт пользователя, к которому привязывается счёт
     * @param account  счёт который привязывается к пользователю
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(accounts)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Этот метод осуществляет поиск пользователя по паспорту
     *
     * @param passport номер паспорта искомого пользователя
     * @return возвращает пользователя или null, если ничего не найдено
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(k -> k.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счёт пользователя по реквизитам
     *
     * @param passport  паспорт пользователя, счёт которого ищем
     * @param requisite реквизиты искомого счёта
     * @return возвращает счёт пользователя или null,
     * если не найден такой пользователь и счёт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent()) {
            if (src.get().getBalance() - amount >= 0) {
                src.get().setBalance(src.get().getBalance() - amount);
                dest.get().setBalance(dest.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}