package com.accounting.one.accountingapp.db;

import java.util.UUID;

/**
 * Created by one on 2018/12/13.
 * 描述：TODO
 */

public class RecordBean {

    private double amount;
    private String category;
    private String remark;
    private String date;
    private long timeStamp;

    private String uuid;

    public RecordBean() {
        uuid = UUID.randomUUID().toString();
        timeStamp = System.currentTimeMillis();
    }
}
