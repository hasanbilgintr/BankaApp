package com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsIban;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hasanbilgin.bankaapp.Models.PayingBillsModel;
import com.hasanbilgin.bankaapp.Services.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayingBillsIbanViewModel extends ViewModel {

    public MutableLiveData<PayingBillsModel> resultPayingBillsModel;

//binding.ibanTextView.getText().toString(),binding.ammountTextView.getText().toString(),binding.descriptionTextView.getText().toString(),binding.sendTypeSpinner.getSelectedItem().toString()
    public void PayingBills(String ibanTextView,int ammountTextView,String descriptionTextView,String sendTypeSpinner) {
        resultPayingBillsModel = new MutableLiveData<>();

        try {
            Call<PayingBillsModel> payingBillsCall = ManagerAll.getInstance().payingBillsCall(ibanTextView,ammountTextView,descriptionTextView,sendTypeSpinner,"Havale/Eft Ödemesi");
            payingBillsCall.enqueue(new Callback<PayingBillsModel>() {
                @Override
                public void onResponse(Call<PayingBillsModel> call, Response<PayingBillsModel> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getResult()) {
                            resultPayingBillsModel.setValue(response.body());
                            System.out.println("PayingBills: "+response.body().toString());
                        } else {
                            //verinin olmaması
                            resultPayingBillsModel.setValue(response.body());
                            System.out.println("PayingBills: "+response.body().toString());
                            System.out.println("getResult.false");
                        }

                    } else {
                        System.out.println("isSuccessful. else" +response.body().toString());
                        //resultMessageInt.setValue(0);
                    }
                }
                @Override
                public void onFailure(Call<PayingBillsModel> call, Throwable t) {
//                    Log.i(t.toString(), "Throwable");
                    System.out.println("Throwable"+t);
                    //resultMessageInt.setValue(0);
                }
            });
        } catch (Exception ignored) {
//            Log.i(ignored.toString(), "ignored");
            //resultMessageInt.setValue(0);
            System.out.println("ignored"+ignored);
        }
    }

}