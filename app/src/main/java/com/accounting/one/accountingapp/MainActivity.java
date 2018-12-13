package com.accounting.one.accountingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;





public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //把ActionBar的阴影去掉
        getSupportActionBar().setElevation(0);

    }
}
