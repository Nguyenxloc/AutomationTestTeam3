package com.view.form_Template;

import junit.framework.TestCase;
import model.CapBac;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;

public class Form_TaoTaiKhoanTest extends TestCase {

    public void testCreateAccount() {
        Form_TaoTaiKhoan form_taoTaiKhoan = new Form_TaoTaiKhoan();
        CapBac capBac = new CapBac();
        capBac.setTenCB("Nhân viên order");

        // Tạo một đối tượng LocalDate
        LocalDate localDate = LocalDate.of(2003, 4, 23);

        // Chuyển đổi LocalDate thành Date
        Date ngaySinh = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Chắc chắn rằng createAccount trả về boolean
        boolean result = form_taoTaiKhoan.createAccount("Đỗ Thị Hải", "Nữ", ngaySinh, "Hà Nội", "0987654321", "Hai0987654321", capBac, "haihaihuoc");

        assertEquals(true, result);

    }



}