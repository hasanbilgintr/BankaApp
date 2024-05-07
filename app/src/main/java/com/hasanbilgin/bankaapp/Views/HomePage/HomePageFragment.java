package com.hasanbilgin.bankaapp.Views.HomePage;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.BankStatement.BankStatementFragmentDirections;
import com.hasanbilgin.bankaapp.Views.LoginIndividual.LoginIndividualViewModel;
import com.hasanbilgin.bankaapp.databinding.FragmentHomePageBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginIndividualBinding;

public class HomePageFragment extends Fragment {

    private HomePageViewModel viewModel;


    private FragmentHomePageBinding binding;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(HomePageViewModel.class);
        binding = FragmentHomePageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonOnclik(view);

        //getTblMoneyMovements
    }

    private void buttonOnclik(View view) {
        sendMoneyOnclick(view);
    }

    private void sendMoneyOnclick(View view) {
        binding.sendMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = BankStatementFragmentDirections.actionBankStatementFragmentToSendMoneyFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}