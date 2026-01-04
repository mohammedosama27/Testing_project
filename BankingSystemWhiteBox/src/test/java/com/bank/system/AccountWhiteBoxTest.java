package com.bank.system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountWhiteBoxTest {

    @Test
    public void testDepositPositive() {
        Account account = new Account(100, "Verified");
        assertTrue(account.deposit(50)); // normal deposit
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testDepositNegativeAmount() {
        Account account = new Account(100, "Verified");
        assertFalse(account.deposit(-10)); // negative deposit blocked
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testDepositClosedAccount() {
        Account account = new Account(100, "Closed");
        assertFalse(account.deposit(50));
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdrawNormal() {
        Account account = new Account(100, "Verified");
        assertTrue(account.withdraw(50)); // normal withdraw
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testWithdrawOverdraft() {
        Account account = new Account(100, "Verified");
        assertFalse(account.withdraw(150)); // cannot overdraft
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdrawSuspendedAccount() {
        Account account = new Account(100, "Suspended");
        assertFalse(account.withdraw(50)); // cannot withdraw if suspended
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdrawClosedAccount() {
        Account account = new Account(100, "Closed");
        assertFalse(account.withdraw(50)); // cannot withdraw if closed
        assertEquals(100, account.getBalance());
    }
}
