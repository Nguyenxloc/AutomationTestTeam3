package com.view.form_Template;

import DoUong_HoaDon_ThongKe_Model.ChiTietDoUong;
import DoUong_HoaDon_ThongKe_Model.LoaiDoUong;
import junit.framework.TestCase;

import java.io.IOException;

public class Form_QLDoUongTest extends TestCase {

    public void testSave() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("Nước cam ép");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
        chiTietDoUong.setGiaNhap(15000);
        chiTietDoUong.setGiaBan(25000);
        chiTietDoUong.setMoTa("Ngon, thơm, mát");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.save(chiTietDoUong, "15000", "20000"));
    }

    public void testSaveRong() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
        chiTietDoUong.setGiaNhap(15000);
        chiTietDoUong.setGiaBan(25000);
        chiTietDoUong.setMoTa("");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.save(chiTietDoUong, "15000", "20000"));
    }

    public void testSaveKhongPhaiLaSo() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
//        chiTietDoUong.setGiaNhap(15000);
//        chiTietDoUong.setGiaBan(25000);
        chiTietDoUong.setMoTa("");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.save(chiTietDoUong, "muoilamngin", "haimuoinghin"));
    }

    public void testUpdate() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("Nước ép cam");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
        chiTietDoUong.setGiaNhap(10000);
        chiTietDoUong.setGiaBan(15000);
        chiTietDoUong.setMoTa("Thơm, ngon, mát");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.update(chiTietDoUong, "10000", "15000"));
    }

    public void testUpdateRong() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
        chiTietDoUong.setGiaNhap(10000);
        chiTietDoUong.setGiaBan(15000);
        chiTietDoUong.setMoTa("");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.update(chiTietDoUong, "10000", "15000"));
    }

    public void testUpdateKhongPhaiLaSo() {
        LoaiDoUong loaiDoUong = new LoaiDoUong();
        loaiDoUong.setTenLoaiDoUong("Nước ép");
        ChiTietDoUong chiTietDoUong = new ChiTietDoUong();
        chiTietDoUong.setHinhAnh(new byte[100]);
        chiTietDoUong.setTenDoUong("Nước ép cam");
        chiTietDoUong.setLoaiDoUong(loaiDoUong);
//        chiTietDoUong.setGiaNhap(10000);
//        chiTietDoUong.setGiaBan(15000);
        chiTietDoUong.setMoTa("Thơm, ngon, mát");
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.update(chiTietDoUong, "mười nghìn", "mười lăm nghìn"));
    }

    public void testTimKiem() {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.timKiem("Bạc xỉu"));
    }

    public void testTimKiemRong() {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.timKiem(""));
    }

    public void testXuatFileExcel() throws IOException {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.xuatFileExcel());
    }


    public void testInMenu() {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.inMenu());
    }

    public void testTestTimKiem() {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.timKiem("Nước ép cam"));
    }

    public void testTestTimKiemRong() {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.timKiem(""));
    }

    public void testTestXuatFileExcel()  {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
//        assertEquals(true, form_qlDoUong.xuatFileExcel());
    }

    public void testTestInMenu() {
        Form_QLDoUong form_qlDoUong = new Form_QLDoUong();
        assertEquals(true, form_qlDoUong.inMenu());
    }
}