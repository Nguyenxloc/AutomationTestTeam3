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

public class Sell_08 extends TestCase {
    ArrayList<ChiTietDoUong> lstChiTietDoUongs = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs;
    Form_BanHang sellFrame = new Form_BanHang();
    LoginFrame login = new LoginFrame();
    HoaDonChiTietNoIMG hoaDonChiTietNoIMG = HoaDonChiTietNoIMG_singleton.getInstance().hoaDonChiTietNoIMG;
    public void testShowDetailHoaDonTab() {
        //Testcase: sell_08 sửa số lượng đồ uống với số lượng nhập vào trong vùng lớn vô cùng
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
        System.out.println("test singletonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn: "+HoaDonChiTietNoIMG_singleton.getInstance().hoaDonChiTietNoIMG);
        //Bước 4:chọn chi tiết đồ uống trong hóa đơn
        assertEquals(true,sellFrame.updateDetailBill(1));
        UpdateAmountFrame updateAmountFrame  = new UpdateAmountFrame(HoaDonChiTietNoIMG_singleton.getInstance().hoaDonChiTietNoIMG, sellFrame.getTblDrinkDetail(),sellFrame.getLblTotalCash());
        //Bước 5:Nhập số lượng ở màn hình sửa số lượng đồ uống hóa đơn chi tiết ---> xác nhận
        assertEquals(true,updateAmountFrame.updateDetailBill("1000"));
    }
}