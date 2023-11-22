package com.view.component;

import SingletonClass.LstChiTietDoUong_singleton;
import com.view.form_Template.Form_BanHang;
import com.view.main.LoginFrame;
import junit.framework.TestCase;
import model.ChiTietDoUong;
import viewModel.ChiTietDoUongNoIMG;

import java.util.ArrayList;

public class Sell_04 extends TestCase {
    ArrayList<ChiTietDoUong> lstChiTietDoUongs = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs;
    Form_BanHang sellFrame = new Form_BanHang();
    LoginFrame login = new LoginFrame();

    public void testShowDetailHoaDonTab() {
        //Bước 1: login vào hệ thống
        assertEquals(true, login.checkingPort("nguyenloc", "123456"));
        //Bước 2: chọn hóa đơn
        sellFrame.LoadlstProduct();
        sellFrame.loadHoaDonTbl();
        sellFrame.loadHoaDonDangPhaChe();
        sellFrame.loadBucketHoaDonChiTietNoIMG();
        assertEquals(true, sellFrame.showDetailHoaDonTab(0));
//          assertEquals(true,sellFrame.showLstDrink());
        //bước 3 : Click chuyển trạng thái hóa đơn
        assertEquals(true,sellFrame.moveToHoaDonChoTbl());
    }
}