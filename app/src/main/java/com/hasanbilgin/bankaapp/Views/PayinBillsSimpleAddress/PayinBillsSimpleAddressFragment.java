package com.hasanbilgin.bankaapp.Views.PayinBillsSimpleAddress;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasanbilgin.bankaapp.R;

public class PayinBillsSimpleAddressFragment extends Fragment {

    private PayinBillsSimpleAddressViewModel mViewModel;

    public static PayinBillsSimpleAddressFragment newInstance() {
        return new PayinBillsSimpleAddressFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payin_bills_simple_address, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}