package com.feng.analysis.app;

import java.time.LocalDateTime;

public class MyTest {
    public static void main(String[] args) throws Exception {
        System.out.println(LocalDateTime.now());
        String str = "人民币123456789012345678901234567890123456789";
        System.out.println(str.substring(0,12));
        System.out.println(str.substring(12,24));
        System.out.println(str.substring(24,36));


        String str2 = "股息入帐(天添利)---";
        System.out.println(str2.length());
        System.out.println(str2.getBytes("UTF8").length);
        System.out.println(str2.indexOf('-'));
        System.out.println(str2.substring(0,str2.indexOf('-')));
    }
}
