package com.hasanbilgin.bankaapp.Other;

public class MainClass {

    public static String getMoon(String moonInt) {
        switch (moonInt) {
            case "01":
                return "Ocak";
            case "02":
                return "Şubat";
            case "03":
                return "Mart";
            case "04":
                return "Nisan";
            case "05":
                return "Mayıs";
            case "06":
                return "Haziran";
            case "07":
                return "Temmuz";
            case "08":
                return "Ağustos";
            case "09":
                return "Eylül";
            case "10":
                return "Ekim";
            case "11":
                return "Kasım";
            case "12":
                return "Aralık";
            default:
                return "";
        }
    }

    public static String getCommaAndZero(String sayi) {
        int amountLength = sayi.length();
        String amount = sayi.replace('.', ',');
        int amountIndex = amount.indexOf(',');

        if (amountLength - amountIndex == 2) {
            return amount + "0";
        }
        return amount;
    }

    public static String getSpace(String word) {
        String newWord =word.substring(0,4)+" ";
        newWord=newWord+word.substring(4,8)+" ";
        newWord=newWord+word.substring(8,12)+" ";
        newWord=newWord+word.substring(12,16)+" ";
        newWord=newWord+word.substring(16,20)+" ";
        newWord=newWord+word.substring(20,24)+" ";
        newWord=newWord+word.substring(24,26);
        return  newWord;
    }
}
