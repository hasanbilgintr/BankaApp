package com.hasanbilgin.bankaapp.Views.BankStatement.BankStatementHome;

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
import com.hasanbilgin.bankaapp.databinding.FragmentBankStatementBinding;

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
        SectionsPagerMyAccountsAdapter sectionsPagerMyAccountsAdapter = new SectionsPagerMyAccountsAdapter(getActivity().getApplicationContext(), requireActivity().getSupportFragmentManager());
        binding.viewPagerBankStatement.setAdapter(sectionsPagerMyAccountsAdapter);
        binding.tabBankStatement.setupWithViewPager(binding.viewPagerBankStatement);

        //tablara icon ekleme
        binding.tabBankStatement.getTabAt(0).setIcon(R.drawable.baseline_add_home_24);
        binding.tabBankStatement.getTabAt(1).setIcon(R.drawable.baseline_attach_money_24);
        binding.tabBankStatement.getTabAt(2).setIcon(R.drawable.baseline_app_settings_alt_24);
        binding.tabBankStatement.getTabAt(3).setIcon(R.drawable.baseline_clear_all_24);
        binding.viewPagerBankStatement.setCurrentItem(0); // 0'dan başlayarak ikinci sekmeye geçiş yapar
    }
}