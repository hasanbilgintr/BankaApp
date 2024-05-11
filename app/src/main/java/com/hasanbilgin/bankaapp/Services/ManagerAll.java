package com.hasanbilgin.bankaapp.Services;



import android.util.Log;
import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Models.LoginModel;
import com.hasanbilgin.bankaapp.Models.MoneyMovementsModel;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<LoginModel> loginUser(String tc,String password) {
        Call<LoginModel> a = getRestApi().loginUser(tc,password, Constants.ApiParams.dbhost, Constants.ApiParams.dbusername,Constants.ApiParams.dbpassword,Constants.ApiParams.dbname);
        return a;
    }

    public Call<List<MoneyMovementsModel>> moneyMovementsList(int accountId) {
        Call<List<MoneyMovementsModel>>  a = getRestApi().moneyMovementsList(accountId,Constants.ApiParams.dbhost, Constants.ApiParams.dbusername,Constants.ApiParams.dbpassword,Constants.ApiParams.dbname);
        return a;
    }







}
