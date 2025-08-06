package com.tcs.app;

import java.util.List;

public class AccountController {
    private final AccountService service = new AccountService();

    // Simulate API methods
    public Account create(String name, double balance) {
        return service.createAccount(name, balance);
    }

    public Account read(int id) {
        return service.getAccount(id);
    }

    public List<Account> readAll() {
        return service.getAllAccounts();
    }

    public boolean update(int id, String name, double balance) {
        return service.updateAccount(id, name, balance);
    }

    public boolean delete(int id) {
        return service.deleteAccount(id);
    }

    // Demo main
    public static void main(String[] args) {
        AccountController ctrl = new AccountController();
        Account a1 = ctrl.create("Alice", 1000);
        Account a2 = ctrl.create("Bob", 2000);
        System.out.println("All: " + ctrl.readAll());
        ctrl.update(a1.getId(), "Alice Smith", 1500);
        System.out.println("Updated: " + ctrl.read(a1.getId()));
        ctrl.delete(a2.getId());
        System.out.println("All after delete: " + ctrl.readAll());
    }
}
