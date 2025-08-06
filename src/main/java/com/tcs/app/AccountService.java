package com.tcs.app;

import java.util.*;

public class AccountService {
    private final Map<Integer, Account> accounts = new HashMap<>();
    private int nextId = 1;

    // Create
    public Account createAccount(String name, double balance) {
        Account acc = new Account(nextId++, name, balance);
        accounts.put(acc.getId(), acc);
        return acc;
    }

    // Read
    public Account getAccount(int id) {
        return accounts.get(id);
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts.values());
    }

    // Update
    public boolean updateAccount(int id, String name, double balance) {
        Account acc = accounts.get(id);
        if (acc != null) {
            acc.setName(name);
            acc.setBalance(balance);
            return true;
        }
        return false;
    }

    // Delete
    public boolean deleteAccount(int id) {
        return accounts.remove(id) != null;
    }
}
