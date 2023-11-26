package com.view.component;

import SingletonClass.HoaDonChiTietNoIMG_singleton;
import SingletonClass.IdHD_singleton;
import SingletonClass.LstChiTietDoUong_singleton;
import com.view.form_Template.Form_BanHang;
import com.view.main.LoginFrame;
import junit.framework.TestCase;
import model.ChiTietDoUong;
import viewModel.HoaDonChiTietNoIMG;

import java.util.ArrayList;

public class Sell_09 extends TestCase {
    ArrayList<ChiTietDoUong> lstChiTietDoUongs = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs;
    Form_BanHang sellFrame = new Form_BanHang();
    LoginFrame login = new LoginFrame();
    HoaDonChiTietNoIMG hoaDonChiTietNoIMG = HoaDonChiTietNoIMG_singleton.getInstance().hoaDonChiTietNoIMG;
    public void testShowDetailHoaDonTab() {
        //Bước 1: login vào hệ thống
        assertEquals(true, login.checkingPort("nguyenloc", "123456"));
        //Bước 2: chọn hóa đơn
        sellFrame.LoadlstProduct();
        sellFrame.loadHoaDonTbl();
        sellFrame.loadHoaDonDangPhaChe();
        sellFrame.loadBucketHoaDonChiTietNoIMG();
        assertEquals(true, sellFrame.showDetailHoaDonTab(0));
        //Show danh sách đồ uống
        assertEquals(true,sellFrame.showLstDrink(IdHD_singleton.getInstance().id));
        //Bước 3: chọn đồ uống từ bảng tblLstDrinkDetail

        //Bước 4: Ấn nút xóa ở bên trái hóa đơn
        assertEquals(true,sellFrame.deleteDrinkDetail(1));
    }
}