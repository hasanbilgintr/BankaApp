package com.hasanbilgin.bankaapp.Other;

public class MainClass {

    public static String getMoon(int moonInt) {
        switch (moonInt) {
            case 1:
                return "Ocak";
            case 2:
                return "Şubat";
            case 3:
                return "Mart";
            case 4:
                return "Nisan";
            case 5:
                return "Mayıs";
            case 6:
                return "Haziran";
            case 7:
                return "Temmuz";
            case 8:
                return "Ağustos";
            case 9:
                return "Eylül";
            case 10:
                return "Ekim";
            case 11:
                return "Kasım";
            case 12:
                return "Aralık";
            default:
                return "";
        }
    }

    public static String getCommaAndZero(String sayi) {
        int amountLength = sayi.length();
        String amount = sayi.replace('.', ',');
        int amountIndex = amount.indexOf(',');

        System.out.println("amountLength-amountIndex: "+(amountLength-amountIndex));
        switch (amountLength-amountIndex) {
            case 2:
                return amount+"0";
            case 1:
                return amount+"00";
            default:
                return amount;
        }
    }
}
