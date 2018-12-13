package com.accounting.one.accountingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.accounting.one.accountingapp.db.RecordBean;

import java.util.LinkedList;

/**
 * Created by one on 2018/12/13.
 * 描述：ListView 适配器
 */

public class ListViewAdapter extends BaseAdapter {

    private LinkedList<RecordBean> records = new LinkedList<>();

    private LayoutInflater inflater;

    private Context context;

    public ListViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(LinkedList<RecordBean> records){
        this.records = records;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return records.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.cell_list_view,null);

            RecordBean recordBean = (RecordBean) getItem(position);
            holder = new ViewHolder(convertView,recordBean);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}

class ViewHolder{
    TextView remarkText;
    TextView amountText;
    TextView timeText;
    ImageView categoryicone;

    public ViewHolder(View itemView,RecordBean record) {
        remarkText = itemView.findViewById(R.id.textView_remark);
        amountText = itemView.findViewById(R.id.textView_amount);
        timeText = itemView.findViewById(R.id.textView_time);
        categoryicone = itemView.findViewById(R.id.imageView_category);
    }
}