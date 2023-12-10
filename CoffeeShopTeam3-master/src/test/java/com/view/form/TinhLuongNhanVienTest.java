package com.view.form;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TinhLuongNhanVienTest extends TestCase {

    public void testLoadLuong() {
        TinhLuongNhanVien tinhLuongNhanVien = new TinhLuongNhanVien();
        Date ngayBatDau = new Date(2023,5,01); // Chuỗi ngày cần chuyển đổi
        Date ngayKetThuc = new Date(2023,9,01); // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        assertEquals(true, tinhLuongNhanVien.loadLuong(ngayBatDau, ngayKetThuc));
    }
}