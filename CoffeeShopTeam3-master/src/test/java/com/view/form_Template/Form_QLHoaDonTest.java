package com.view.form_Template;

import junit.framework.TestCase;


import java.sql.Date;
import java.text.SimpleDateFormat;


public class Form_QLHoaDonTest extends TestCase {

    public void testLoadDataTheoTime() {
        try {
            Form_QLHoaDon qlHoaDon = new Form_QLHoaDon();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            assertEquals(true, qlHoaDon.loadDataTheoTime(
                new Date(sdf.parse("01-07-2023").getTime()),
                new Date(sdf.parse("20-07-2023").getTime())
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}