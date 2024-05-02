package com.hasanbilgin.bankaapp.Views.LoginCommercial;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.hasanbilgin.bankaapp.databinding.FragmentLoginCommercialBinding;

public class LoginCommercialFragment extends Fragment {

    private LoginCommercialViewModel viewModel;

    private FragmentLoginCommercialBinding binding;


    public static LoginCommercialFragment newInstance() {
        return new LoginCommercialFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        viewModel = new ViewModelProvider(requireActivity()).get(LoginCommercialViewModel.class);
        binding = FragmentLoginCommercialBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}