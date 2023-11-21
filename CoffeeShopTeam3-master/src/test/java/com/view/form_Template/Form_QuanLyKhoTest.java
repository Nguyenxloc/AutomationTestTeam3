package com.view.form_Template;

import junit.framework.TestCase;
import model.NhanVien;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Form_QuanLyKhoTest extends TestCase {

    public void testNhapKho() {
        try {
            Form_QuanLyKho qlKho = new Form_QuanLyKho();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId("B73798D8-52E6-45AC-9FF1-367CEB664764");
            assertEquals(true, qlKho.nhapKho(
                    nhanVien,
                    "Táo",
                    new Date(sdf.parse("20/11/2023").getTime()),
                    "kg",
                    10,
                    new BigDecimal(300000)
            ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testSua() {
        try {
            Form_QuanLyKho qlKho = new Form_QuanLyKho();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId("B73798D8-52E6-45AC-9FF1-367CEB664764");
            assertEquals(true, qlKho.sua(
                    "0DF3E258-E0D5-461F-8F33-312458B16862",
                    nhanVien,
                    "Táo",
                    new Date(sdf.parse("20/11/2023").getTime()),
                    "kg",
                    10,
                    new BigDecimal(300000)
            ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testXoa() {
        Form_QuanLyKho qlKho = new Form_QuanLyKho();
        assertEquals(true, qlKho.xoa("0DF3E258-E0D5-461F-8F33-312458B16862"));
    }
}