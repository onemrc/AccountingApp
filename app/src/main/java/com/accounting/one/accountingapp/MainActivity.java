package com.accounting.one.accountingapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;





public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MainViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //把ActionBar的阴影去掉
        getSupportActionBar().setElevation(0);

        viewPager =  findViewById(R.id.view_pager);
        pagerAdapter =  new MainViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.notifyDataSetChanged();

        viewPager.setAdapter(pagerAdapter);
        //从最新一页开始
        viewPager.setCurrentItem(pagerAdapter.getLastIndex());

    }
}
