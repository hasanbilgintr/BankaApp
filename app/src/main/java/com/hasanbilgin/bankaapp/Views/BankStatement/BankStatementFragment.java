package com.hasanbilgin.bankaapp.Views.BankStatement;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasanbilgin.bankaapp.Adapters.SectionsPagerMyAccountsAdapter;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.Login.LoginViewModel;
import com.hasanbilgin.bankaapp.databinding.FragmentBankStatementBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginBinding;

public class BankStatementFragment extends Fragment {

    private BankStatementViewModel viewModel;

    private FragmentBankStatementBinding binding;

    public static BankStatementFragment newInstance() {
        return new BankStatementFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(BankStatementViewModel.class);
        binding = FragmentBankStatementBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabPageInstance();

    }


    private void tabPageInstance() {

        SectionsPagerMyAccountsAdapter sectionsPagerMyAccountsAdapter = new SectionsPagerMyAccountsAdapter(getContext(), requireActivity().getSupportFragmentManager());
        binding.viewPager2.setAdapter(sectionsPagerMyAccountsAdapter);
        binding.tabs2.setupWithViewPager(binding.viewPager2);

        //tablara icon ekleme
        binding.tabs2.getTabAt(0).setIcon(R.drawable.baseline_add_home_24);
        binding.tabs2.getTabAt(1).setIcon(R.drawable.baseline_attach_money_24);
        binding.tabs2.getTabAt(2).setIcon(R.drawable.baseline_app_settings_alt_24);
        binding.tabs2.getTabAt(3).setIcon(R.drawable.baseline_clear_all_24);
    }

}