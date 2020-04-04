package com.example.demo.test.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        Date time = calendar.getTime();
        System.out.println(time.getTime());
        String timeString = new SimpleDateFormat("yyyyMMdd").format(time);
        System.out.println(timeString);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String s = "";
        try {
            String a = ",, ,,";
            for (String s1 : a.split(",")) {
                System.out.println("result: \"" + s1 + "\"");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println(s);
    }
}
