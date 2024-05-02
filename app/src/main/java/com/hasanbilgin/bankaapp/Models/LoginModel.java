package com.hasanbilgin.bankaapp.Models;

public class LoginModel {

    private int resultMessage;


    private Boolean isResult;

    public int getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(int resultMessage) {
        this.resultMessage = resultMessage;
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
                "resultMessage=" + resultMessage +
                ", isResult=" + isResult +
                '}';
    }







}
