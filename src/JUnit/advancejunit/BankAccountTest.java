package com.capgeminitraining.week4.day5regexjunit.junit.advancejunit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0); // Initial balance: 100
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.01, "Balance should be updated after deposit.");
    }

    @Test
    void testWithdraw() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.01, "Balance should be updated after withdrawal.");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
        assertEquals("Insufficient funds", exception.getMessage(), "Should throw an error for insufficient funds.");
    }

    @Test
    void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
        assertEquals("Deposit amount must be positive", exception.getMessage(), "Should throw an error for negative deposit.");
    }

    @Test
    void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5.0));
        assertEquals("Withdrawal amount must be positive", exception.getMessage(), "Should throw an error for negative withdrawal.");
    }

    @Test
    void testInitialNegativeBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BankAccount(-50.0));
        assertEquals("Initial balance cannot be negative", exception.getMessage(), "Should not allow negative initial balance.");
    }
}
