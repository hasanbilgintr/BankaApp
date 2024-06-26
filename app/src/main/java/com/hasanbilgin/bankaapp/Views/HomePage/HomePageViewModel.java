package com.hasanbilgin.bankaapp.Views.HomePage;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Models.AccountInfoModel;
import com.hasanbilgin.bankaapp.Models.MoneyMovementsModel;
import com.hasanbilgin.bankaapp.Other.MainClass;
import com.hasanbilgin.bankaapp.Services.ManagerAll;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.transform.sax.SAXResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageViewModel extends ViewModel {


    public MutableLiveData<Integer> resultMessageInt;
    public MutableLiveData<List<MoneyMovementsModel>> resultMoneyMovementsList;
    public MutableLiveData<AccountInfoModel> resultAccountInfo;

    public void moneyMovementsList() {
        resultMessageInt = new MutableLiveData<>();
        resultMoneyMovementsList = new MutableLiveData<>();

        Call<List<MoneyMovementsModel>> moneyMovementsList = ManagerAll.getInstance().moneyMovementsList(Constants.login.accountID);
        try {
            moneyMovementsList.enqueue(new Callback<List<MoneyMovementsModel>>() {
                @Override
                public void onResponse(Call<List<MoneyMovementsModel>> call, Response<List<MoneyMovementsModel>> response) {
                    if (response.isSuccessful()) {
                        if (response.body().get(0).getResult()) {
                            //System.out.println("getResult");
                            resultMoneyMovementsList.setValue(response.body());

                            //System.out.println(response.body().toString());
                        }
                        resultMessageInt.setValue(response.body().get(0).getResultMessageInt());
                    } else {
                        resultMessageInt.setValue(0);
                        //System.out.println("isSuccessful.else");
                    }
                }

                @Override
                public void onFailure(Call<List<MoneyMovementsModel>> call, Throwable t) {
                    resultMessageInt.setValue(0);
                    //Log.i("adsviewmodellogtest94", t.toString());
                }
            });
        } catch (Exception e) {
            System.out.println("e: " + e);
        }
    }

    public void accountInfo() {
        resultAccountInfo = new MutableLiveData<>();
        Call<AccountInfoModel> accountInfo = ManagerAll.getInstance().accountInfo();
        accountInfo.enqueue(new Callback<AccountInfoModel>() {
            @Override
            public void onResponse(Call<AccountInfoModel> call, Response<AccountInfoModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResult()) {
                        resultAccountInfo.setValue(response.body());
                        Constants.defaultAccount.defaultIbanNo =MainClass.getSpace(response.body().getIbanNo());
                        Constants.defaultAccount.defaultAccountName = response.body().getAccountName();
                        Constants.defaultAccount.defaultBalance = MainClass.getCommaAndZero(response.body().getBalance().toString());
                        Constants.defaultAccount.defaultCurrency = response.body().getCurrency();

                        System.out.println("resultAccountInfo" + response.body().toString());
                    } else {
                        System.out.println("getResult else");
                        System.out.println("encode: " + response.body().toString());
                    }
                } else {
                    System.out.println("isSuccessful . else");
                }
            }
            @Override
            public void onFailure(Call<AccountInfoModel> call, Throwable t) {
                System.out.println("Throwable: " + t);
            }
        });


    }
}