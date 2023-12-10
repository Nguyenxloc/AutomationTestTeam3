package com.view.component;

import com.view.form_Template.Form_BanHang;
import junit.framework.TestCase;


public class Sell_01 extends TestCase {
    //Test case: tạo hóa đơn
    Form_BanHang  sale = new Form_BanHang();
    CreateBillPane createBill = new CreateBillPane(sale.tblHoaDon, sale.tblDangPhaChe);
    public void testSave() {
        //tạo hóa đơn với số bàn nhập vào là số hợp lệ
        assertEquals(true,createBill.save("1"));
    }

    public void testSaveFaield(){
        //tạo hóa đơn với số bàn nhập vào là số không hợp le
        assertEquals(true,createBill.save("a"));
    }
}