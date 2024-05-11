package com.hasanbilgin.bankaapp.Views.LoginIndividual;

import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Views.Login.LoginFragmentDirections;
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

        binding.adsoyadTextView.setText("Hasan Bilgin");
        editTextChange();
    }

    private void editTextChange() {
        binding.passwodEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //1sn
                try {
                    if (s.length() == 6) {
                        if (!binding.passwodEditText.getText().toString().equals("")) {
                            String tc = "12345678910";
                            viewModel.loginuser(tc, binding.passwodEditText.getText().toString());
                            viewModel.resultMessageInt.observe(getViewLifecycleOwner(), resultMessageInt -> {
                                switch (resultMessageInt) {
                                    case 0:
                                        Toast.makeText(getContext(), "Giriş Başarısız", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 1:
                                        //ChangeFragment changeFragment = new ChangeFragment(getContext(), new BankStatementFragment(), "BankStatementFragment", R.id.content_FrameLayout);
                                        //changeFragment.change();
                                        Toast.makeText(getContext(), "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                                        //Navigation ile
                                        NavDirections action = LoginFragmentDirections.actionLoginFragmentToBankStatementFragment();
                                        Navigation.findNavController(binding.getRoot()).navigate(action);
                                        break;
                                    case 2:
                                        Toast.makeText(getContext(), "Kullanıcı Adı yada şifre hatalıdır", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        break;
                                }
                            });
                        }
                    }
                } catch (Exception e) {

                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }

}