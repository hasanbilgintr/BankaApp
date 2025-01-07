package com.hasanbilgin.bankaapp.Activities;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.hasanbilgin.bankaapp.Contants.Constants;
import com.hasanbilgin.bankaapp.Other.ChangeFragment;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.BankStatement.BankStatementHome.BankStatementFragment;
import com.hasanbilgin.bankaapp.Views.BankStatement.HomePage.HomePageFragment;
import com.hasanbilgin.bankaapp.Views.Login.LoginHome.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        ChangeFragment changeFragment = new ChangeFragment(MainActivity.this, new HomePageFragment(), "LoginFragment", R.id.main);
//        changeFragment.change();
    }

    //kapatıldı farklı birşeyler düşünülcek
    //navigation ile activityden yönlendirme şart
    @Override
    public void onBackPressed() {

//        switch (Constants.viewInfo.viewName) {
//            case "BankStatementFragment":
//                break;
//            case "PayingBillsIbanPdfFragment":
////                ChangeFragment changeFragment = new ChangeFragment(MainActivity.this, new HomePageFragment(), "HomePageFragment", R.id.main);
////                changeFragment.change();
//
//
//
//
//                break;
//
//            default:
//                super.onBackPressed();
//                break;
//        }
        System.out.println("activity.onBackPressed()");
        super.onBackPressed();
    }


}