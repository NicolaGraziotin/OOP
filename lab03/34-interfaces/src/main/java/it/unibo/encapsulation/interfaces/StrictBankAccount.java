package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {

    private static double ATM_TRANSACTION_FEE = 0.1;
    private static double ATM_MANAGEMENT_FEE = 5;

    private final int id;
    private double balance;
    private int transactions;

    public StrictBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getid() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void deposit(final int id, final double amount) {
        checkId(id, amount);
    }

    public void withdraw(final int id, final double amount) {
        if (amount < this.balance) {
            checkId(id, -amount);
        }
    }

    public void depositFromATM(final int id, final double amount) {
        checkId(id, (amount - ATM_TRANSACTION_FEE));
    }

    public void withdrawFromATM(final int id, final double amount) {
        if (amount < this.balance) {
            checkId(id, -(amount + ATM_TRANSACTION_FEE));
        }
    }

    public void chargeManagementFees(final int id) {
        checkId(id, -(ATM_MANAGEMENT_FEE + this.transactions*ATM_TRANSACTION_FEE));
    }

    private void checkId(final int id, final double amount) {
        if (this.id == id) {
            this.transactions++;
            this.balance += amount;
        }
    }
}
