package com.view.component;

import com.view.form_Template.Form_BanHang;
import junit.framework.TestCase;


public class Sell_01 extends TestCase {
    Form_BanHang  sale = new Form_BanHang();
    CreateBillPane createBill = new CreateBillPane(sale.tblHoaDon, sale.tblDangPhaChe);
    public void testSave() {
        assertEquals(true,createBill.save("1"));
    }

    public void testSaveFaield(){
        assertEquals(true,createBill.save("a"));
    }
}