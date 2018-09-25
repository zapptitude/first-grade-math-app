package com.zapptitude.firstgrademathapp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zapptitude.firstgrademathapp.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);  // display the background
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Zapptitude.onResume();
    }

    @Override
    protected void onStop() {
//        Zapptitude.onStop();
        super.onStop();
    }
}
