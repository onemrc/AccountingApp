package com.accounting.one.accountingapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by one on 2018/12/13.
 * 描述：TODO
 */

public class DateUtil {

    //HH:mm
    public static String getFormattedTime(long timeStamp){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date(timeStamp));
    }

    /**
     * 获取今天日期
     * @return
     */
    public static String getFormattedDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
