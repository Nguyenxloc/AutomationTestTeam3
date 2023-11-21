package com.view.form_Template;

import DoUong_HoaDon_ThongKe_Model.ChiTietDoUong;
import DoUong_HoaDon_ThongKe_Model.LoaiDoUong;
import junit.framework.TestCase;

public class Form_QLDoUongTest extends TestCase {

    public void testSave() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("Nước ép cam");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
        chiTietDoUong.setGiaNhap(15000);
        chiTietDoUong.setGiaBan(25000);
        chiTietDoUong.setMoTa("Thơm ngon");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.save(chiTietDoUong));
    }

    public void testUpdate() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("Nước cam");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
        chiTietDoUong.setGiaNhap(12000);
        chiTietDoUong.setGiaBan(20000);
        chiTietDoUong.setMoTa("Thơm ngon");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.update(chiTietDoUong));
    }

    public void testDelete() {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.delete(""));
    }
}