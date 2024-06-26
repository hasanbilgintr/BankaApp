package com.hasanbilgin.bankaapp.Views.PayinBillsIban;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.Login.LoginViewModel;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentPayinBillsBinding;
import com.hasanbilgin.bankaapp.databinding.FragmentPayinbillsIbanBinding;

import java.util.ArrayList;
import java.util.List;

public class PayinBillsIbanFragment extends Fragment {

    private PayinBillsIbanViewModel viewModel;
    private FragmentPayinbillsIbanBinding binding;
    List<String> sendType;

    public static PayinBillsIbanFragment newInstance() {
        return new PayinBillsIbanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(PayinBillsIbanViewModel.class);
        binding = FragmentPayinbillsIbanBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        formLoad();
        buttonOnclick();
        addTextChanged();
    }

    private void addTextChanged() {
        binding.descriptionTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(s.length());
                binding.descriptionLenghtTextView.setText(s.length()+" / 200");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void buttonOnclick() {
        senderOnclick();
        allBalanceOnClick();
    }

    private void allBalanceOnClick() {
        binding.allBalanceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ammountTextView.setText(Constants.defaultAccount.defaultBalance);
            }
        });
    }

    private void senderOnclick() {
        binding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //System.out.println(" binding.sendButton.setOnClickListener(");
//                System.out.println(""+ binding.sendTypeSpinner.getSelectedItem().toString());
                if ((!binding.ibanTextView.getText().toString().equals("") && binding.ibanTextView.getText().toString().length()==26) & !binding.ammountTextView.getText().toString().equals("")) {
                    viewModel.PayingBills(binding.ibanTextView.getText().toString(), Integer.parseInt(binding.ammountTextView.getText().toString()), binding.descriptionTextView.getText().toString(), binding.sendTypeSpinner.getSelectedItem().toString());
                    viewModel.resultPayingBillsModel.observe(getViewLifecycleOwner(), resultPayingBillsModel -> {
                        switch (resultPayingBillsModel.getResultMessageInt()) {
                            case 0:
                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    });
                } else {
                    Toast.makeText(getContext(), "Lütfen Boş alanları dolduralım", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void formLoad() {
        sendType = new ArrayList<>();
        sendType.add("Bireysel Ödeme");
        sendType.add("Para Transferi");
        sendType.add("Aidat");
        sendType.add("Diğer Kira Ödemesi");
        sendType.add("Eğitim");
        sendType.add("E-Ticaret");
        ArrayAdapter<String> turListAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, sendType);
        turListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.sendTypeSpinner.setAdapter(turListAdapter);
    }
}