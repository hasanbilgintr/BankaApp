package com.hasanbilgin.bankaapp.Views.Login.LoginHome;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasanbilgin.bankaapp.Adapters.SectionsPagerHomePageAdapter;

import com.hasanbilgin.bankaapp.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    private LoginViewModel viewModel;

    private FragmentLoginBinding binding;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(LoginViewModel.class);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SectionsPagerHomePageAdapter sectionsPagerHomePageAdapter = new SectionsPagerHomePageAdapter(getContext(), requireActivity().getSupportFragmentManager());
        binding.viewPagerLogin.setAdapter(sectionsPagerHomePageAdapter);
        binding.tabLogin.setupWithViewPager(binding.viewPagerLogin);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}