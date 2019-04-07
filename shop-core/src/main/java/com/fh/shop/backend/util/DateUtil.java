package com.fh.shop.backend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String  PATTERN_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";

    public static final String  PATTERN_Y_M_D = "yyyy-MM-dd";

    public static String date2Str(Date date ,String pattern) {
        if (date == null){
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String result = simpleDateFormat.format(date);
        return result;
    }

    public static Date str2Date (String dateStr ,String pattern ){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date result = null;
        try {
            result = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result ;
    }



}
