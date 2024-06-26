    package com.hasanbilgin.bankaapp.Models;

    public class PayingBillsModel {

    private String ibanNo;
    private Double ammount;
    private String description;
    private String submissionType;
    private int resultMessageInt;
    //model değişken türü farklı ise istekte hata alırız 
    private String resultMessage;
    private Boolean isResult;

    public String getIbanNo() {
    return ibanNo;
    }

    public void setIbanNo(String ibanNo) {
    this.ibanNo = ibanNo;
    }

    public Double getAmmount() {
    return ammount;
    }

    public void setAmmount(Double ammount) {
    this.ammount = ammount;
    }

    public String getDescription() {
    return description;
    }

    public void setDescription(String description) {
    this.description = description;
    }

    public String getSubmissionType() {
    return submissionType;
    }

    public void setSubmissionType(String submissionType) {
    this.submissionType = submissionType;
    }

    public int getResultMessageInt() {
    return resultMessageInt;
    }

    public void setResultMessageInt(int resultMessageInt) {
    this.resultMessageInt = resultMessageInt;
    }
    public String getResultMessage() {
    return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
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
    return "PayingBillsModel{" +
    "ibanNo='" + ibanNo + '\'' +
    ", ammount=" + ammount +
    ", description='" + description + '\'' +
    ", submissionType='" + submissionType + '\'' +
    ", resultMessageInt=" + resultMessageInt +
    ", resultMessage=" + resultMessage +
    ", isResult=" + isResult +
    '}';
    }

    }
