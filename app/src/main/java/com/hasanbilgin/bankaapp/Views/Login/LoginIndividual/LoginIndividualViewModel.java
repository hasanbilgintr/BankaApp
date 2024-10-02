package com.hasanbilgin.bankaapp.Views.Login.LoginIndividual;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Models.LoginModel;
import com.hasanbilgin.bankaapp.Services.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginIndividualViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    public MutableLiveData<Integer> resultMessageInt;

    public void loginuser(String tc, String password) {
        resultMessageInt = new MutableLiveData<>();

        try {
            Call<LoginModel> login = ManagerAll.getInstance().loginUser(tc, password);
            login.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getResult()) {
                            //System.out.println("response: "+response.body().toString());
                            Constants.login.accountID = response.body().getAccountId();
                            Constants.login.email = response.body().getEmail();
                            Constants.login.name = response.body().getName();
                            Constants.login.surname = response.body().getSurname();


                        } else {
                            //verinin olmaması
                            //System.out.println("getResult.false" +response.body().toString());
                        }
                        resultMessageInt.setValue(response.body().getResultMessageInt());
                    } else {
                        //System.out.println("isSuccessful. else" +response.body().toString());
                        resultMessageInt.setValue(0);
                    }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    Log.i(t.toString(), "Throwable");
                    resultMessageInt.setValue(0);
                }
            });
        } catch (Exception ignored) {
            Log.i(ignored.toString(), "ignored");
            resultMessageInt.setValue(0);
        }
    }
}