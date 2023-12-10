package com.view.form_Template;

import com.view.main.LoginFrame;
import junit.framework.TestCase;
import viewModel.QLBan;

public class Form_QLBanTest extends TestCase {

    //Test chức năng quản lý bàn
    //Cần đăng nhập trước khi thực hiện chức năng
    LoginFrame loginFrame = new LoginFrame();
    Form_QLBan qlBan = new Form_QLBan();

    public void testThemBan() {
        //Đầu tiên đăng nhập hệ thống
        assertEquals(true, loginFrame.checkingPort("nguyenloc", "123456"));

        //Test chức năng thêm bàn
        //Test 1: Thêm bàn thành công
        //Test 2: Thêm bàn với id đã có -> Mong muốn thêm thất bại
        //Test 3: Thêm bàn với tên bàn để trống -> Mong muốn thêm thất bại
        assertEquals(true, qlBan.themBan(10, ""));
    }

    //Tương tự với sửa bàn cũng cần đăng nhập
    public void testSuaBan() {
    //Đầu tiên đăng nhập hệ thống
        assertEquals(true, loginFrame.checkingPort("nguyenloc", "123456"));

        //Test chức năng sửa bàn
        //Test 1: Sửa bàn thành công
        //Test 2: Sửa bàn với id bàn không tồn tại -> mong muốn thất bại
        //Test 3: Sửa bàn với tên bàn để trống -> mong muốn thất bại
        assertEquals(true, qlBan.suaBan(10, ""));

    }

    //Tiếp theo đến chức năng xóa bàn
    public void testXoaBan() {
        //Đầu tiên đăng nhập hệ thống
        assertEquals(true, loginFrame.checkingPort("nguyenloc", "123456"));

        //Test 1: Xóa bàn thành công
        //Test 2: Xóa bàn với id bàn không tồn tại -> mong muốn thất bại
        assertEquals(true, qlBan.xoaBan(55));
    }
}