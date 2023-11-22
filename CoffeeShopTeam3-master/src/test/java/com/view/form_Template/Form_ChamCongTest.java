package com.view.form_Template;

import junit.framework.TestCase;
import model.NhanVien;

import java.util.Date;

public class Form_ChamCongTest extends TestCase {

    public void testChamCongGioVao() {
        Form_ChamCong form_chamCong = new Form_ChamCong();
//        NhanVien nv = new NhanVien();
//        nv.setMa("NV01");
//        System.out.println(nv);
//        boolean result = form_chamCong.chamCongGioRa(nv);
        Date ngayVao = new Date();

        assertEquals(true, form_chamCong.chamCongGioVao("NV1", ngayVao, 4, 07, 29));
//        assertEquals(true, result);

    }

    public void testChamCongGioRa() {
    }
}