package com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsIban;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Other.ChangeFragment;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.BankStatement.HomePage.HomePageFragment;
import com.hasanbilgin.bankaapp.Views.PayingBills.PayingBillsHome.PayingBillsFragmentDirections;
import com.hasanbilgin.bankaapp.Views.Pdf.PayingBillsIbanPdfFragment;
import com.hasanbilgin.bankaapp.databinding.FragmentPayingBillsIbanBinding;

import java.util.ArrayList;
import java.util.List;

public class PayingBillsIbanFragment extends Fragment {

    private PayingBillsIbanViewModel viewModel;
    private FragmentPayingBillsIbanBinding binding;
    List<String> sendType;

    public static PayingBillsIbanFragment newInstance() {
        return new PayingBillsIbanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(PayingBillsIbanViewModel.class);
        binding = FragmentPayingBillsIbanBinding.inflate(inflater, container, false);
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
                String count_ = s.length() + " / 200";
                binding.descriptionLenghtTextView.setText(count_);
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

//                //System.out.println(" binding.sendButton.setOnClickListener(");
////                System.out.println(""+ binding.sendTypeSpinner.getSelectedItem().toString());
//                if ((!binding.ibanTextView.getText().toString().equals("") && binding.ibanTextView.getText().toString().length()==26) & !binding.ammountTextView.getText().toString().equals("")) {
//
//                    viewModel.PayingBills(binding.ibanTextView.getText().toString(), Integer.parseInt(binding.ammountTextView.getText().toString()), binding.descriptionTextView.getText().toString(), binding.sendTypeSpinner.getSelectedItem().toString());
//                    viewModel.resultPayingBillsModel.observe(getViewLifecycleOwner(), resultPayingBillsModel -> {
//                        switch (resultPayingBillsModel.getResultMessageInt()) {
//                            case 0:
//                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
//                                System.out.println(resultPayingBillsModel.getResultMessage());
//                                break;
//                            case 1:
//                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
//                                System.out.println(resultPayingBillsModel.getResultMessage());
//                                break;
//                            case 2:
//                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
//                                System.out.println(resultPayingBillsModel.getResultMessage());
//                                break;
//                            case 3:
//                                Toast.makeText(getContext(), resultPayingBillsModel.getResultMessage(), Toast.LENGTH_SHORT).show();
//                                System.out.println(resultPayingBillsModel.getResultMessage());
//                                break;
//                            default:
//                                break;
//                        }
//                    });
//                } else {
//                    Toast.makeText(getContext(), "Lütfen Boş alanları dolduralım", Toast.LENGTH_SHORT).show();
//                    System.out.println("Lütfen Boş alanları dolduralım");
//                }
                //Constants.viewInfo.viewName = "PayingBillsIbanPdfFragment";
                NavDirections action = PayingBillsFragmentDirections.actionPayinBillsFragmentToPayinBillsIbanPdfFragment();
                Navigation.findNavController(binding.getRoot()).navigate(action);


//                ChangeFragment changeFragment = new ChangeFragment(getContext(), new PayingBillsIbanPdfFragment(), "replaceFragNewUser", R.id.fragmentContainerView);
//                changeFragment.change();

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