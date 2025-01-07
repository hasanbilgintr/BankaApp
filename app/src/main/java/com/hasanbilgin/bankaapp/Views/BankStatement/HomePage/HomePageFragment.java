package com.hasanbilgin.bankaapp.Views.BankStatement.HomePage;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hasanbilgin.bankaapp.Adapters.MoneyMovementsAdapter;
import com.hasanbilgin.bankaapp.Models.MoneyMovementsModel;
import com.hasanbilgin.bankaapp.Other.MainClass;
import com.hasanbilgin.bankaapp.Views.BankStatement.BankStatementHome.BankStatementFragmentDirections;
import com.hasanbilgin.bankaapp.databinding.FragmentHomePageBinding;

import java.util.ArrayList;

public class HomePageFragment extends Fragment {

    private HomePageViewModel viewModel;


    private FragmentHomePageBinding binding;

    ArrayList<MoneyMovementsModel> moneyMovementsList;

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

        buttonOnclik();
        getAccountInfo();
        getMoneyMovementsList();

    }

    private void getMoneyMovementsList() {
        viewModel.moneyMovementsList();
        viewModel.resultMessageInt.observe(getViewLifecycleOwner(), resultMessageInt -> {
            switch (resultMessageInt) {
                case 0:
                    break;
                case 1:
                    viewModel.resultMoneyMovementsList.observe(getViewLifecycleOwner(), resultMoneyMovementsList -> {
                        moneyMovementsList = new ArrayList<>();
                        for (int i = 0; i < resultMoneyMovementsList.size(); i++) {
                            moneyMovementsList.add(resultMoneyMovementsList.get(i));
                        }
                        //System.out.println("getmoney::...." + moneyMovementsList);

                        binding.moneyMovementsrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        MoneyMovementsAdapter moneyMovementsAdapter = new MoneyMovementsAdapter(moneyMovementsList);
                        binding.moneyMovementsrecyclerView.setAdapter(moneyMovementsAdapter);
                    });
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        });
    }

    private void getAccountInfo() {
        viewModel.accountInfo();
        viewModel.resultAccountInfo.observe(getViewLifecycleOwner(), resultAccountInfo -> {
            switch (resultAccountInfo.getResultMessageInt()) {
                case 0:
                    Toast.makeText(getContext(), "Hesap Bilgileri getirilemedi Lütfen Tekrar deneyiniz", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    binding.accountNameTextView.setText(resultAccountInfo.getAccountName());
                    binding.ibanTextView.setText(MainClass.getSpace(resultAccountInfo.getIbanNo()));
                    String balance = MainClass.getCommaAndZero(resultAccountInfo.getBalance().toString());
                    binding.balanceTextView.setText(balance+" "+resultAccountInfo.getCurrency());
                    binding.availableBalanceTextView.setText(balance+" "+resultAccountInfo.getCurrency());
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        });
    }

    private void buttonOnclik() {
        sendMoneyOnclick(binding.getRoot());
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