package com.hasanbilgin.bankaapp.Views.SendMoney;

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

import com.hasanbilgin.bankaapp.Adapters.SendMoneyAdapter;
import com.hasanbilgin.bankaapp.Models.SendMoneyModel;
import com.hasanbilgin.bankaapp.databinding.FragmentSendMoneyBinding;

import java.util.ArrayList;

public class SendMoneyFragment extends Fragment {

    private SendMoneyViewModel viewModel;

    private FragmentSendMoneyBinding binding;
    ArrayList<SendMoneyModel> sendSpeedMoneyModelArrayList;
    ArrayList<SendMoneyModel> getDataTransferTransactionsModelArrayList;

    public static SendMoneyFragment newInstance() {
        return new SendMoneyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(SendMoneyViewModel.class);
        binding = FragmentSendMoneyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getData();
    }

    private void getData() {
        getDataSendSpeedMoney();
        getDatatransferTransactions();
    }

    private void getDataSendSpeedMoney() {

        //Data Hızlı para gönder
        sendSpeedMoneyModelArrayList = new ArrayList<>();
        SendMoneyModel kayitliIslem = new SendMoneyModel(1, "Kayıtlı İşlemler");
        SendMoneyModel AkilliTransfer = new SendMoneyModel(2, "Akıllı transfer");
        sendSpeedMoneyModelArrayList.add(kayitliIslem);
        sendSpeedMoneyModelArrayList.add(AkilliTransfer);

        binding.sendSpeedMoneyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SendMoneyAdapter sendSpeedMoneyAdapter = new SendMoneyAdapter(sendSpeedMoneyModelArrayList, "sendSpeedMoneyRecyclerView", new SendMoneyAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int id, String recyclerViewName) {

            }
        });
        binding.sendSpeedMoneyRecyclerView.setAdapter(sendSpeedMoneyAdapter);
    }

    private void getDatatransferTransactions() {

        getDataTransferTransactionsModelArrayList = new ArrayList<>();
        SendMoneyModel hesaplarimArasi = new SendMoneyModel(1, "Hesaplarım Arası");
        SendMoneyModel baskaAliciyaHavale = new SendMoneyModel(2, "Başka Alıcıya Havale/EFT/FAST");
        SendMoneyModel digerBankadanGetir = new SendMoneyModel(3, "Diğer Bankadan PAra Getir");
        SendMoneyModel odemeIste = new SendMoneyModel(4, "Ödeme İste");
        SendMoneyModel Isme = new SendMoneyModel(5, "İsme (Havale/EFT)");
        SendMoneyModel dovizTransferi = new SendMoneyModel(6, "Döviz Transferi (SWIFT)");
        SendMoneyModel cebeParaGonder = new SendMoneyModel(7, "Cebe Para Gönder");
        SendMoneyModel KumbaraParaGonder = new SendMoneyModel(8, "Kumbara Para Gönder");

        getDataTransferTransactionsModelArrayList.add(hesaplarimArasi);
        getDataTransferTransactionsModelArrayList.add(baskaAliciyaHavale);
        getDataTransferTransactionsModelArrayList.add(digerBankadanGetir);
        getDataTransferTransactionsModelArrayList.add(odemeIste);
        getDataTransferTransactionsModelArrayList.add(Isme);
        getDataTransferTransactionsModelArrayList.add(dovizTransferi);
        getDataTransferTransactionsModelArrayList.add(cebeParaGonder);
        getDataTransferTransactionsModelArrayList.add(KumbaraParaGonder);

        binding.transferTransactionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SendMoneyAdapter transferTransactionsAdapter = new SendMoneyAdapter(getDataTransferTransactionsModelArrayList, "transferTransactionsRecyclerView", new SendMoneyAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int id, String recyclerViewName) {
                if (recyclerViewName == "transferTransactionsRecyclerView") {
                    switch (id) {
                        case 2:
                            NavDirections action = SendMoneyFragmentDirections.actionSendMoneyFragmentToPayinBillsFragment();
                            Navigation.findNavController(binding.getRoot()).navigate(action);
                            break;
                        default:
                    }
                }
            }
        });

        binding.transferTransactionsRecyclerView.setAdapter(transferTransactionsAdapter);

    }

}