package com.view.component;

import SingletonClass.LstChiTietDoUong_singleton;
import com.view.form_Template.Form_BanHang;
import com.view.main.LoginFrame;
import junit.framework.TestCase;
import model.ChiTietDoUong;
import viewModel.ChiTietDoUongNoIMG;

import java.util.ArrayList;

public class Sell_02 extends TestCase {
    ArrayList<ChiTietDoUong> lstChiTietDoUongs = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs;
    Form_BanHang sellFrame = new Form_BanHang();
    LoginFrame login = new LoginFrame();
    paneOfProduct paneProduct = new paneOfProduct(lstChiTietDoUongs, sellFrame.getTblDrinkDetail(), sellFrame.getLocalHoaDon(), sellFrame.getLblTotalCash());

    ChiTietDoUong drinkDetail = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs.get(1);
    ChiTietDoUong drinkDetail1 = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs.get(2);
    ChiTietDoUong drinkDetail2 = LstChiTietDoUong_singleton.getInstance().lstChiTietDoUongs.get(3);

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
        //bước 3 : thêm 3 đồ uống khác nhau vào hóa đơn
        ChiTietDoUongNoIMG drinkDetailNoIMG = new ChiTietDoUongNoIMG(drinkDetail.getId(), drinkDetail.getTenDoUong(), drinkDetail.getGiaNhap(),
                drinkDetail.getGiaBan(), drinkDetail.getMoTa(), drinkDetail.getLoaiDoUong(), drinkDetail.getKhuyenMai());
        ChiTietDoUongNoIMG drinkDetailNoIMG1 = new ChiTietDoUongNoIMG(drinkDetail1.getId(), drinkDetail1.getTenDoUong(), drinkDetail1.getGiaNhap(),
                drinkDetail1.getGiaBan(), drinkDetail1.getMoTa(), drinkDetail1.getLoaiDoUong(), drinkDetail1.getKhuyenMai());
        ChiTietDoUongNoIMG drinkDetailNoIMG2 = new ChiTietDoUongNoIMG(drinkDetail2.getId(), drinkDetail2.getTenDoUong(), drinkDetail2.getGiaNhap(),
                drinkDetail2.getGiaBan(), drinkDetail2.getMoTa(), drinkDetail2.getLoaiDoUong(), drinkDetail2.getKhuyenMai());
        EnterAmountFrame enterAmount = new EnterAmountFrame(drinkDetailNoIMG, sellFrame.getTblDrinkDetail(), sellFrame.getLblTotalCash());
        EnterAmountFrame enterAmount1 = new EnterAmountFrame(drinkDetailNoIMG1, sellFrame.getTblDrinkDetail(), sellFrame.getLblTotalCash());
        EnterAmountFrame enterAmount2 = new EnterAmountFrame(drinkDetailNoIMG2, sellFrame.getTblDrinkDetail(), sellFrame.getLblTotalCash());
        assertEquals(true, enterAmount.addDrinkDetail("5"));
        assertEquals(true, enterAmount1.addDrinkDetail("5"));
        assertEquals(true, enterAmount2.addDrinkDetail("5"));
    }
}