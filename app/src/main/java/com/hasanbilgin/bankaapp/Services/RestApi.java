package com.hasanbilgin.bankaapp.Services;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Models.LoginModel;
import com.hasanbilgin.bankaapp.Models.MoneyMovementsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {


    //region LoginPage
    @FormUrlEncoded
    @POST(Constants.loginFile)
    Call<LoginModel> loginUser(@Field("tc") String tc,@Field("password") String password,@Field("dbhost") String dbhost,@Field("dbusername") String dbusername,@Field("dbpassword") String dbpassword,@Field("dbname") String dbname);
    //endregion


    //region moneyMovementsList
    @FormUrlEncoded
    @POST(Constants.MoneyMovementsListFile)
    Call<List<MoneyMovementsModel>> moneyMovementsList(@Field("accountId") int accountId,@Field("dbhost") String dbhost,@Field("dbusername") String dbusername,@Field("dbpassword") String dbpassword,@Field("dbname") String dbname);
    //endregion
}
