package com.accounting.one.accountingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * Created by one on 2018/12/13.
 * 描述：ViewPager 适配器
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter{

    LinkedList<MainFragment> fragments = new LinkedList<>();
    LinkedList<String> dates = new LinkedList<>();

    private void initFragments(){
        dates.add("2018-12-12");
        dates.add("2018-12-13");
        dates.add("2018-12-14");

        for (String date:dates){
            MainFragment fragment = new MainFragment(date);
            fragments.add(fragment);
        }
    }

    //返回最后一个页面
    public int getLastIndex(){
        return fragments.size() - 1;
    }


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }
}
