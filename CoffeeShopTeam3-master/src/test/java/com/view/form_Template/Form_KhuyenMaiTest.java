package com.view.form_Template;

import junit.framework.TestCase;
import model.KhuyenMai;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Form_KhuyenMaiTest extends TestCase {

    public void testAddKhuyenMai() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMaKM("KM001");
        khuyenMai.setTenKM("Giảm giá 20%");
        khuyenMai.setLoaiKM("Giảm giá");
        khuyenMai.setGiaTri(20);

//        khuyenMai.setNgayBatDau(new SimpleDateFormat("dd-MM-yyyy").parse("21-12-2003"));
//        khuyenMai.setNgayKetThuc(new SimpleDateFormat("dd-MM-yyyy").parse("31-12-2023"));
        khuyenMai.setTrangThai("Hoạt động");

//        assertTrue();
//        assertEquals(true,km.addKhuyenMai(khuyenMai));
    }


//    public void testDeleteKhuyeMai_Case01(){
//        Form_KhuyenMai km = new Form_KhuyenMai();
//        Assert.assertEquals(true,km.deleteKhuyeMai(3,"KM06"));
//    }
//
//    public void testDeleteKhuyeMai() {


//        Form_KhuyenMai km = new Form_KhuyenMai();
//        Assert.assertEquals(true,km.deleteKhuyeMai(1,"KM04"));
//
//
//        Assert.assertEquals(true,km.deleteKhuyeMai(2,"KM05"));
//
//        Assert.assertEquals(true,km.deleteKhuyeMai(3,"KM06"));
//
//
//    }

}