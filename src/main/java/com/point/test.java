package com.point;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        String dateString = "2020/12/25 ";

        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse(dateString);
            System.out.println(sdf.format(date));
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
