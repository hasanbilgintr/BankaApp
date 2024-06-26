package com.hasanbilgin.bankaapp.Models;

import java.io.Serializable;

public class SendMoneyModel implements Serializable {

    public int id;
    public String name;

    public SendMoneyModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

}




