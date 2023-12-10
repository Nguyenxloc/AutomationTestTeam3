package com.view.component;

import SingletonClass.IdHD_singleton;
import SingletonClass.LstChiTietDoUong_singleton;
import com.view.form_Template.Form_BanHang;
import com.view.main.LoginFrame;
import junit.framework.TestCase;
import model.ChiTietDoUong;
import viewModel.ChiTietDoUongNoIMG;

import java.util.ArrayList;

public class Sell_05 extends TestCase {
    ArrayList<ChiTietDoUong> lstChiTietDoUongs = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs;
    Form_BanHang sellFrame = new Form_BanHang();
    LoginFrame login = new LoginFrame();
    paneOfProduct paneProduct = new paneOfProduct(lstChiTietDoUongs, sellFrame.getTblDrinkDetail(), sellFrame.getLocalHoaDon(), sellFrame.getLblTotalCash());

    public void testShowDetailHoaDonTab() {
        //TestCas SELL_05 thêm mã giảm giá với mã giảm giá hợp lệ
        //Bước 1: login vào hệ thống
        assertEquals(true, login.checkingPort("nguyenloc", "123456"));
        //Bước 2: chọn hóa đơn
        sellFrame.LoadlstProduct();
        sellFrame.loadHoaDonTbl();
        sellFrame.loadHoaDonDangPhaChe();
        sellFrame.loadBucketHoaDonChiTietNoIMG();
        assertEquals(true, sellFrame.showDetailHoaDonTab(0));
        //Ấn thanh toán
        BillFrame billFrame = new BillFrame(IdHD_singleton.getInstance().id,sellFrame.getTblHoaDon(),sellFrame.getTblDangPhaChe(),sellFrame.getTblHoaDonCho());
        //Nhập mã giảm giá
        assertEquals(true,billFrame.updateDiscount("MH3751"));
    }
}