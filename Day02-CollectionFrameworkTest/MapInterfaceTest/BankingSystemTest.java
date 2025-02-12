package com.capgeminitraining.week4.day2.MapInterface;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankingSystemTest {
    private BankingSystem bank;

    @BeforeEach
    void setUp() {
        bank = new BankingSystem();
        bank.createAccount(101, 5000.0);
        bank.createAccount(102, 3000.0);
    }

    @Test
    void testCreateAccount() {
        bank.createAccount(103, 7000.0);
        bank.deposit(103, 0.0); // Checking if account exists without throwing an error
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(104, 1000.0));
    }

    @Test
    void testDeposit() {
        bank.deposit(101, 1500.0);
        bank.deposit(102, 500.0);
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(105, 200.0));
    }

    @Test
    void testRequestWithdrawal() {
        bank.requestWithdrawal(101);
        bank.requestWithdrawal(102);
        assertThrows(IllegalArgumentException.class, () -> bank.requestWithdrawal(105));
    }

    @Test
    void testProcessWithdrawals() {
        bank.requestWithdrawal(101);
        bank.requestWithdrawal(102);
        assertDoesNotThrow(() -> bank.processWithdrawals());
    }
}