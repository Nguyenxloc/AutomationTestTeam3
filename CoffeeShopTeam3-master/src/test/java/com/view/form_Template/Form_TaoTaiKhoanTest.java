package com.view.form_Template;

import junit.framework.TestCase;
import model.CapBac;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;

public class Form_TaoTaiKhoanTest extends TestCase {

    public void testCreateAccount() {
        Form_TaoTaiKhoan form_taoTaiKhoan = new Form_TaoTaiKhoan();
        CapBac capBac = new CapBac();
        capBac.setTenCB("Nhân viên order");

        // Tạo một đối tượng LocalDate
        String ngaySinh = "23-11-2023"; // Chuỗi ngày cần chuyển đổi

        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;

        try {
            ngayBatDau = simpleDateFormat.parse(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Chắc chắn rằng createAccount trả về boolean
        boolean result = form_taoTaiKhoan.createAccount("Đỗ Thị Hải", "Nữ", ngayBatDau, "Hà Nội", "0987654321", "Hai0987654321", capBac, "haihaihuoc");

        assertEquals(true, result);

    }

    public void testCreateAccount_null() {
        Form_TaoTaiKhoan form_taoTaiKhoan = new Form_TaoTaiKhoan();
        CapBac capBac = new CapBac();
        capBac.setTenCB("Nhân viên order");

        // Tạo một đối tượng LocalDate
        String ngaySinh = "23-11-2023"; // Chuỗi ngày cần chuyển đổi

        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;

        try {
            ngayBatDau = simpleDateFormat.parse(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Chắc chắn rằng createAccount trả về boolean
        boolean result = form_taoTaiKhoan.createAccount("", "Nữ", ngayBatDau, "Hà Nội", "0987654321", "Hai0987654321", capBac, "duyHung");

        assertEquals(false, result);

    }

}