package com.accounting.one.accountingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.accounting.one.accountingapp.db.RecordBean;

import java.util.LinkedList;

/**
 * Created by one on 2018/12/13.
 * 描述：
 */

public class MainFragment extends Fragment {


    private View rootView;
    private TextView textView;
    private ListView listView;
    private ListViewAdapter listViewAdapter;

    private LinkedList<RecordBean> records = new LinkedList<>();

    private String date = "";

    @SuppressLint("ValidFragment")
    public MainFragment(String date) {
        this.date = date;

        records.add(new RecordBean());
        records.add(new RecordBean());
        records.add(new RecordBean());
        records.add(new RecordBean());
    }

    //获取根视图
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main,container,false);
        initView();
        return rootView;
    }

    private void initView(){
        textView = rootView.findViewById(R.id.day_text);
        listView = rootView.findViewById(R.id.listView);

        textView.setText(date);
        listViewAdapter = new ListViewAdapter(getContext());
        listViewAdapter.setData(records);
        listView.setAdapter(listViewAdapter);

        if (listViewAdapter.getCount() > 0){
            rootView.findViewById(R.id.no_record_layout).setVisibility(View.INVISIBLE);
        }
    }


}
