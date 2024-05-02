package com.hasanbilgin.bankaapp.Views.MyAccounts;

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
import com.hasanbilgin.bankaapp.databinding.FragmentMyAccountsBinding;


public class MyAccountsFragment extends Fragment {

    private MyAccountsViewModel viewModel;

    private FragmentMyAccountsBinding binding;

    public static MyAccountsFragment newInstance() {
        return new MyAccountsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(requireActivity()).get(MyAccountsViewModel.class);
        binding = FragmentMyAccountsBinding.inflate(inflater, container, false);


        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabPageInstance();
    }

    private void tabPageInstance() {



    }


}