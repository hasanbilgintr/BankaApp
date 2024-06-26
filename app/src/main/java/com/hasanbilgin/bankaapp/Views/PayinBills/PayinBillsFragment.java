package com.hasanbilgin.bankaapp.Views.PayinBills;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasanbilgin.bankaapp.Adapters.SectionsPagerHomePageAdapter;
import com.hasanbilgin.bankaapp.Adapters.SectionsPagerPayinBillsAdapter;
import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.Login.LoginViewModel;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentPayinBillsBinding;

public class PayinBillsFragment extends Fragment {

    private PayinBillsViewModel viewModel;
    private FragmentPayinBillsBinding binding;

    public static PayinBillsFragment newInstance() {
        return new PayinBillsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        viewModel = new ViewModelProvider(requireActivity()).get(PayinBillsViewModel.class);
        binding = FragmentPayinBillsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        SectionsPagerPayinBillsAdapter sectionsPagerPayinBillsAdapter = new SectionsPagerPayinBillsAdapter(getContext(), requireActivity().getSupportFragmentManager());
        binding.viewPagerPayinBills.setAdapter(sectionsPagerPayinBillsAdapter);
        binding.tabPayinBills.setupWithViewPager(binding.viewPagerPayinBills);

        binding.defaultAccountNameTextView.setText(Constants.defaultAccount.defaultAccountName);
        binding.defaultIbanTextView.setText(Constants.defaultAccount.defaultIbanNo);
        binding.defaultBalanceTextView.setText(Constants.defaultAccount.defaultBalance+" "+Constants.defaultAccount.defaultCurrency);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}