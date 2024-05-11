package com.hasanbilgin.bankaapp.Models;

import com.hasanbilgin.bankaapp.Views.SendMoney.SendMoneyFragment;


import java.text.DateFormat;
import java.util.Date;

public class MoneyMovementsModel {

    private int id;
    private int accountId;
    private String movementType;
    private Double amount;
    private Date date;
    private int moneyTransferId;

    private String currency;

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

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                ", movementType='" + movementType + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", moneyTransferId=" + moneyTransferId +
                ", currency='" + currency + '\'' +
                ", resultMessageInt=" + resultMessageInt +
                ", isResult=" + isResult +
                '}';
    }

}
