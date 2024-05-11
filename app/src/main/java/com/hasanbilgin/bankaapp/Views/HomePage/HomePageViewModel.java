package com.hasanbilgin.bankaapp.Views.HomePage;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Models.MoneyMovementsModel;
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

    public void moneyMovementsList() {
        resultMessageInt = new MutableLiveData<>();
        resultMoneyMovementsList = new MutableLiveData<>();
        Call<List<MoneyMovementsModel>> moneyMovementsList = ManagerAll.getInstance().moneyMovementsList(Constants.login.accounID);
        moneyMovementsList.enqueue(new Callback<List<MoneyMovementsModel>>() {
            @Override
            public void onResponse(Call<List<MoneyMovementsModel>> call, Response<List<MoneyMovementsModel>> response) {
                if (response.isSuccessful()) {
                    if(response.body().get(0).getResult()){
                        resultMoneyMovementsList.setValue(response.body());
                        System.out.println(response.body().toString());
                    }
                    resultMessageInt.setValue(response.body().get(0).getResultMessageInt());
                }else{
                    resultMessageInt.setValue(0);
                    System.out.println("isSuccessful.else");
                }
            }
            @Override
            public void onFailure(Call<List<MoneyMovementsModel>> call, Throwable t) {
                resultMessageInt.setValue(0);
                Log.i("adsviewmodellogtest94",t.toString());
            }
        });
    }
}