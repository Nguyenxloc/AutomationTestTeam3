package com.view.component;

import SingletonClass.IdHD_singleton;
import SingletonClass.LstChiTietDoUong_singleton;
import com.view.form_Template.Form_BanHang;
import com.view.main.LoginFrame;
import junit.framework.TestCase;
import model.ChiTietDoUong;

import java.util.ArrayList;

public class Sell_06 extends TestCase {
    ArrayList<ChiTietDoUong> lstChiTietDoUongs = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs;
    Form_BanHang sellFrame = new Form_BanHang();
    LoginFrame login = new LoginFrame();
    paneOfProduct paneProduct = new paneOfProduct(lstChiTietDoUongs, sellFrame.getTblDrinkDetail(), sellFrame.getLocalHoaDon(), sellFrame.getLblTotalCash());

    public void testShowDetailHoaDonTab() {
        //TestCase Sell_06 thêm mã giảm giá với mã giảm giá không hợp le
        //Bước 1: login vào hệ thống
        assertEquals(true, login.checkingPort("nguyenloc", "123456"));
        //Bước 2: chọn hóa đơn
        sellFrame.LoadlstProduct();
        sellFrame.loadHoaDonTbl();
        sellFrame.loadHoaDonDangPhaChe();
        sellFrame.loadBucketHoaDonChiTietNoIMG();
        assertEquals(true, sellFrame.showDetailHoaDonTab(0));
        //Bước 3: ấn thanh toán
        BillFrame billFrame = new BillFrame(IdHD_singleton.getInstance().id,sellFrame.getTblHoaDon(),sellFrame.getTblDangPhaChe(),sellFrame.getTblHoaDonCho());
        //Bước 4: nhập mã giảm giá
        assertEquals(true,billFrame.updateDiscount(""));
    }
}