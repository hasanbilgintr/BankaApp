package com.hasanbilgin.bankaapp.Models;

import com.hasanbilgin.bankaapp.Views.SendMoney.SendMoneyFragment;


import java.text.DateFormat;
import java.util.Date;

public class MoneyMovementsModel {

    private int id;
    private int accountId;
    private Double amount;
    private String transferDate;
    private int moneyTransferId;
    private String currency;
    private String transferInfo;
    private int resultMessageInt;
    private Boolean isResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public int getMoneyTransferId() {
        return moneyTransferId;
    }

    public void setMoneyTransferId(int moneyTransferId) {
        this.moneyTransferId = moneyTransferId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransferInfo() {
        return transferInfo;
    }

    public void setTransferInfo(String transferInfo) {
        this.transferInfo = transferInfo;
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
        return "MoneyMovementsModel{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", transferDate='" + transferDate + '\'' +
                ", moneyTransferId=" + moneyTransferId +
                ", currency='" + currency + '\'' +
                ", transferInfo='" + transferInfo + '\'' +
                ", resultMessageInt=" + resultMessageInt +
                ", isResult=" + isResult +
                '}';
    }


}
