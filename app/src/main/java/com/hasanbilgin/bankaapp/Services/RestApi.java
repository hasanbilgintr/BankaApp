package com.hasanbilgin.bankaapp.Services;



import android.provider.ContactsContract;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Models.LoginModel;
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

}
