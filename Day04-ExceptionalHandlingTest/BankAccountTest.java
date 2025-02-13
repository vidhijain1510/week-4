package com.capgeminitraining.week4.day4exceptionalhandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        //Setting up a bank account with an initial balance of 500.00
        account = new BankAccount(500.00);
    }

    @Test
    public void testValidWithdrawal() throws InsufficientBalanceException {
        account.withdraw(200); // Withdraw 200.00
        assertEquals(300.00, account.getBalance());
    }

    @Test
    public void testInsufficientBalance() {
        InsufficientBalanceException exception = assertThrows(InsufficientBalanceException.class, () -> {
            account.withdraw(1000); // Attempting to withdraw more than available balance
        });
        assertEquals("Insufficient balance!", exception.getMessage());
    }

    @Test
    public void testNegativeAmount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50); // Attempting to withdraw a negative amount
        });
        assertEquals("Invalid amount!", exception.getMessage());
    }

    @Test
    public void testZeroAmount() throws InsufficientBalanceException {
        account.withdraw(0); // Attempting to withdraw zero
        assertEquals(500.00, account.getBalance()); // Balance should remain the same
    }
}