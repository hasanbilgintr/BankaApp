package com.hasanbilgin.bankaapp.Views.HomePage;

import androidx.lifecycle.Observer;
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
import com.hasanbilgin.bankaapp.Adapters.SendMoneyAdapter;
import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Models.MoneyMovementsModel;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.BankStatement.BankStatementFragmentDirections;
import com.hasanbilgin.bankaapp.Views.LoginIndividual.LoginIndividualViewModel;
import com.hasanbilgin.bankaapp.databinding.FragmentHomePageBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginIndividualBinding;

import java.util.ArrayList;
import java.util.List;

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
        viewModel.resultAccountInfo.observe(getViewLifecycleOwner(), resultMessageInt -> {
            switch (resultMessageInt) {
                case 0:  Toast.makeText(getContext(), "Hesap Bilgileri getirilemedi Lütfen Tekrar deneyiniz", Toast.LENGTH_SHORT).show();
                    break;
                case 1:

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