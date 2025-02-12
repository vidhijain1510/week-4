/*Implement a Banking System
Description:
HashMap stores customer accounts (AccountNumber -> Balance).
TreeMap sorts customers by balance.
Queue processes withdrawal requests.
*/
package com.capgeminitraining.week4.day2.MapInterface;

import java.util.*;

public class BankingSystem {
    private final HashMap<Integer, Double> accounts = new HashMap<>();
    private final TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private final Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber));
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        } else {
            throw new IllegalArgumentException("Account does not exist.");
        }
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            throw new IllegalArgumentException("Account does not exist.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    public void displaySortedAccounts() {
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " Balance: " + entry.getKey());
        }
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 5000.0);
        bank.createAccount(102, 3000.0);
        bank.deposit(101, 1500.0);
        bank.requestWithdrawal(102);
        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}