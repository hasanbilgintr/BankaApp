package com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsSimpleAddress;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasanbilgin.bankaapp.R;

public class PayingBillsSimpleAddressFragment extends Fragment {

    private PayingBillsSimpleAddressViewModel mViewModel;

    public static PayingBillsSimpleAddressFragment newInstance() {
        return new PayingBillsSimpleAddressFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_paying_bills_simple_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}