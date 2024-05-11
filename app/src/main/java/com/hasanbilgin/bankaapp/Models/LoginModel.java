package com.hasanbilgin.bankaapp.Models;

public class LoginModel {

    private int accountId;

    private String email;
    private int resultMessageInt;
    private Boolean isResult;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "LoginModel{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", resultMessageInt=" + resultMessageInt +
                ", isResult=" + isResult +
                '}';
    }





}
