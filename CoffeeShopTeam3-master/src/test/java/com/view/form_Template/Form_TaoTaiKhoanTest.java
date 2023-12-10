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
        String ngSinh = "09-09-2023"; // Chuỗi ngày cần chuyển đổi

        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngaySinh = null;

        try {
            ngaySinh = simpleDateFormat.parse(ngSinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Chắc chắn rằng createAccount trả về boolean
        boolean result = form_taoTaiKhoan.createAccount("Đỗ Văn Tuấn", "Nam", ngaySinh, "Hà Nội", "0989767854", "Tuan8907654321", capBac, "tuandovan1");

        assertEquals(true, result);

    }

    public void testCreateAccount_khongthanhcong() {
        Form_TaoTaiKhoan form_taoTaiKhoan = new Form_TaoTaiKhoan();
        CapBac capBac = new CapBac();
        capBac.setTenCB("Nhân viên order");

        // Tạo một đối tượng LocalDate
        String ngSinh = "09-11-2023"; // Chuỗi ngày cần chuyển đổi

        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngaySinh = null;

        try {
            ngaySinh = simpleDateFormat.parse(ngSinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Chắc chắn rằng createAccount trả về boolean
        boolean result = form_taoTaiKhoan.createAccount("Đỗ Thị Nhung", "Nữ", ngaySinh, "Thanh Hóa", "0987654367", "Nhung0967543567", capBac, "Nhungdzzzz");

        assertEquals(false, result);

    }

}