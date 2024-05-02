package com.hasanbilgin.bankaapp.Views.LoginIndividual;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hasanbilgin.bankaapp.Other.ChangeFragment;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.BankStatement.BankStatementFragment;
import com.hasanbilgin.bankaapp.Views.MyAccounts.MyAccountsFragment;
import com.hasanbilgin.bankaapp.databinding.FragmentLoginIndividualBinding;

public class LoginIndividualFragment extends Fragment {

    private LoginIndividualViewModel viewModel;

    private FragmentLoginIndividualBinding binding;

    public static LoginIndividualFragment newInstance() {
        return new LoginIndividualFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(requireActivity()).get(LoginIndividualViewModel.class);
        binding = FragmentLoginIndividualBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.cepteKazanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.passwodEditText.getText().toString().equals("")){
                    String tc="12345678910";
                    viewModel.loginuser(tc,binding.passwodEditText.getText().toString());
                    viewModel.resultMessage.observe(getViewLifecycleOwner(), resultMesaj -> {
                        switch (resultMesaj.toString()) {
                            case "0":
                                //Toast mesajları gelmiyor kontrol edelim
                                //Toast.makeText(getContext(), "Giriş Başarısız", Toast.LENGTH_SHORT).show();
                                break;
                            case "1":
                                //Toast.makeText(getContext(), "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                                ChangeFragment changeFragment = new ChangeFragment(getContext(), new BankStatementFragment(), "BankStatementFragment", R.id.content_FrameLayout);
                                changeFragment.change();
                                break;
                            case "2":
                                //Toast.makeText(getContext(), "Kullanıcı Adı yada şifre hatalıdır", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    });
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}