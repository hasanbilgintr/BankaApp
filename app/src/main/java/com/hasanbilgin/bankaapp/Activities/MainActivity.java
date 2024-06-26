package com.hasanbilgin.bankaapp.Activities;

import android.os.Bundle;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hasanbilgin.bankaapp.Other.ChangeFragment;
import com.hasanbilgin.bankaapp.R;
import com.hasanbilgin.bankaapp.Views.Login.LoginFragment;

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


//        ChangeFragment changeFragment = new ChangeFragment(MainActivity.this, new LoginFragment(), "LoginFragment", R.id.content_FrameLayout);
//        changeFragment.change();
    }

    //geri tuşu kapatıldı
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}