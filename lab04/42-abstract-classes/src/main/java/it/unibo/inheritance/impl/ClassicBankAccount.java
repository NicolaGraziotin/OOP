package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount {

    public ClassicBankAccount(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    protected double computeFees() {
        return MANAGEMENT_FEE;
    }

    @Override
    protected boolean isWithdrawAllowed(double amount) {
        return true;
    }
    
}
