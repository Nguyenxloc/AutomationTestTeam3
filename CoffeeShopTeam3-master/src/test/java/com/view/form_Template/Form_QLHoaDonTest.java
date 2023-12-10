package com.view.form_Template;

import junit.framework.TestCase;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Form_QLHoaDonTest extends TestCase {

    public void testLoadDataTheoTime() throws ParseException {
        Form_QLHoaDon qlHoaDon = new Form_QLHoaDon();
        String sDate1 = "01-01-2023";
        String sDate2 = "01-03-2023";
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");

//        Date d1 = formatter1.parse(sDate1).getTime();
//        System.out.println(d1);
        Date d2 = (Date) formatter1.parse(sDate2);
        System.out.println(d2);
        try {
//            assertEquals(true, qlHoaDon.loadDataTheoTime(
//                d1, d2
//            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void testTimKiem() {
        Form_QLHoaDon form_qlHoaDon = new Form_QLHoaDon();
        assertEquals(true, form_qlHoaDon.timKiem("HD100"));
    }

    public void testTimKiemRong() {
        Form_QLHoaDon form_qlHoaDon = new Form_QLHoaDon();
        assertEquals(true, form_qlHoaDon.timKiem(""));
    }
}