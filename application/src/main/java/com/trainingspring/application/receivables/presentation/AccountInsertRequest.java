package com.trainingspring.application.receivables.presentation;

// bir account ı insert etmek için ne lazımsa, SADECE onu veririz.
public class AccountInsertRequest {

    private String accountName;
    private  double totalBalance;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }


}
