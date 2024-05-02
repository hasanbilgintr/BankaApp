package com.hasanbilgin.bankaapp.Views.LoginIndividual;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasanbilgin.bankaapp.Models.LoginModel;
import com.hasanbilgin.bankaapp.Services.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginIndividualViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    public MutableLiveData<Integer> resultMessage;

    public void loginuser(String tc, String password) {
        resultMessage = new MutableLiveData<>();

        try {
            Call<LoginModel> login = ManagerAll.getInstance().loginUser(tc, password);
            login.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getResult()) {
                            resultMessage.setValue(1);
                        } else {
                            resultMessage.setValue(0);
                        }
                    }
                }
                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    Log.i(t.toString(), "Throwable");
                    resultMessage.setValue(0);
                }
            });
        } catch (Exception ignored) {
            Log.i(ignored.toString(), "ignored" );
        }
    }
}