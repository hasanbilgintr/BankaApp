package com.hasanbilgin.bankaapp.Views.PayinBillsIban;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.Login.LoginViewModel;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentPayinBillsBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentPayinbillsIbanBinding;

import java.util.ArrayList;
import java.util.List;

public class PayinBillsIbanFragment extends Fragment {

    private PayinBillsIbanViewModel viewModel;
    private FragmentPayinbillsIbanBinding binding;
    List<String> sendType;
    public static PayinBillsIbanFragment newInstance() {
        return new PayinBillsIbanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(PayinBillsIbanViewModel.class);
        binding = FragmentPayinbillsIbanBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            formLoad();
    }

    private void formLoad() {
        sendType = new ArrayList<>();
        sendType.add("Bireysel Ödeme");
        sendType.add("Para Transferi");
        sendType.add("Aidat");
        sendType.add("Diğer Kira Ödemesi");
        sendType.add("Eğitim");
        sendType.add("E-Ticaret");
        ArrayAdapter<String> turListAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, sendType);
        turListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.sendTypeSpinner.setAdapter(turListAdapter);
    }
}