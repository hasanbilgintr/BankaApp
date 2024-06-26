package com.hasanbilgin.bankaapp.Models;

public class LoginModel {

    private int accountId;
    private String email;



    private String name;
    private String surname;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", resultMessageInt=" + resultMessageInt +
                ", isResult=" + isResult +
                '}';
    }


}
