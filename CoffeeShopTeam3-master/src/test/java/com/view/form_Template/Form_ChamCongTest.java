package com.view.form_Template;

import junit.framework.TestCase;
import model.NhanVien;

import java.util.Date;

public class Form_ChamCongTest extends TestCase {

    public void testChamCongGioVao() {
        Form_ChamCong form_chamCong = new Form_ChamCong();

        Date ngayVao = new Date();

        assertEquals(true, form_chamCong.chamCongGioVao("NV1", ngayVao, 4, 07, 29));


    }

    public void testChamCongGioVao_khongthanhcong() {
        Form_ChamCong form_chamCong = new Form_ChamCong();

        Date ngayVao = new Date();

        assertEquals(true, form_chamCong.chamCongGioVao("N", ngayVao, 4, 07, 29));


    }

    public void testChamCongGioRa() {
        Form_ChamCong form_chamCong = new Form_ChamCong();

        Date ngayVao = new Date();

        assertEquals(false, form_chamCong.chamCongGioVao("NV01", ngayVao, 4, 07, 29));

    }

    public void testChamCongGioRa_khongthanhcong() {
        Form_ChamCong form_chamCong = new Form_ChamCong();

        Date ngayVao = new Date();

        assertEquals(false, form_chamCong.chamCongGioVao("N", ngayVao, 4, 07, 29));

    }

}