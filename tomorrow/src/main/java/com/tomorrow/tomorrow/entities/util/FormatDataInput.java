package com.tomorrow.tomorrow.entities.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class FormatDataInput{

    protected String NUMBER_FORMAT(String number){
        return number.replaceAll("[^0-9]+", "");
    }

    protected String NAME_FORMAT(String name){
        name = name.trim();
        name = name.toUpperCase();
        return name;
    }

    protected Date DATE_FORMAT(){
        Date date = new Date();
        String dateFormat;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM HH:mm:ss");
        dateFormat = sdf.format(date);
        try {
            date = sdf.parse(dateFormat);
        }catch(ParseException parseException){
            parseException.printStackTrace();
        }
        return date;

    }
}