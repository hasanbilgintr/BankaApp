package com.hasanbilgin.bankaapp.Models;

public class AccountInfoModel {

    private String accountName;
    private String ibanNo;
    private Double balance;
    private String currency;
    private int resultMessageInt;
    private Boolean isResult;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getIbanNo() {
        return ibanNo;
    }

    public void setIbanNo(String ibanNo) {
        this.ibanNo = ibanNo;
    }

    public Double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getResultMessageInt() {
        return resultMessageInt;
    }

    public void setResultMessageInt(int resultMessageInt) {
        this.resultMessageInt = resultMessageInt;
    }

    public Boolean getResult() {
        return isResult;
    }

    public void setResult(Boolean result) {
        isResult = result;
    }


    @Override
    public String toString() {
        return "AccountInfoModel{" +
                "accountName='" + accountName + '\'' +
                ", ibanNo='" + ibanNo + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                ", resultMessageInt=" + resultMessageInt +
                ", isResult=" + isResult +
                '}';
    }


}
