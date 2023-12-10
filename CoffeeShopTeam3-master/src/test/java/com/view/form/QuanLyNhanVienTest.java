package com.view.form;

import com.view.model.CapBac;
import junit.framework.TestCase;

public class QuanLyNhanVienTest extends TestCase {

//    Test case chức năng xóa nhân viên thành công
    public void testDeleteNhanVien_Success() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        assertEquals(true,quanLyNhanVien.deleteNhanVien(1,"NV21"));
    }

    //    Test case chức năng xóa nhân viên thành công
    public void testDeleteNhanVien_NotSuccess() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        assertEquals(false,quanLyNhanVien.deleteNhanVien(-1,"NV21"));
    }

    //Test Case thêm nhân viên thành công
    public void testSave_Success() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(true,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , để trống tên
    public void testSave_NameNull() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , không hợp lệ, tên chứa số
    public void testSave_Name_Invalid() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài123","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , tên vượt quá độ dài cho phép
    public void testSave_Name_Max() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , tên chứa ký tự đặc biệt
    public void testSave_Name_KTDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài@","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , tài khoản đã tồn tại
    public void testSave_AccountExit() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài", "Nam",
                "2003-12-21", "Hà Nội", "0988786546", "Taik3", "123456", capBac, 1, image));
    }

    //Test Case thêm nhân viên không thành công , tài khoản chứa ký tự đặc biệt
    public void testSave_Account_Invalid() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài", "Nam",
                "2003-12-21", "Hà Nội", "0988786546", "Taik3@@", "123456", capBac, 1, image));
    }

    //Test Case thêm nhân viên không thành công , tài khoản chứa khoảng trắng ở hai đầu
    public void testSave_Account_Invalid_space() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài", "Nam",
                "2003-12-21", "Hà Nội", "0988786546", " Tai123 ", "123456", capBac, 1, image));
    }

    //Test Case thêm nhân viên không thành công , ngày sinh sai định dạng
    public void testSave_NgaySinh() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "abc","Hà Nội","0988786546","T","123456",capBac,1,image));
    }


    //Test Case thêm nhân viên không thành công , số điện thoại sai định dạng
    public void testSave_SDT_Invalid() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","12345","T","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , số điện thoại chứa ký tự đặc biệt
    public void testSave_SDT_KYDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","098877643@","T","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , số điện thoại đã tồn tại
    public void testSave_SDT_Exit() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","0666666666","T","123456",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , mật khẩu chứa ký tự đặc biệt
    public void testSave_MK_KYDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","0988776432","T","123456@",capBac,1,image));
    }

    //Test Case thêm nhân viên không thành công , địa chỉ quá dài vượt quá mức cho phép
    public void testSave_DiaChi_Max() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa","0988776432","T","123456",capBac,1,image));
    }
    //Test Case thêm nhân viên không thành công , địa chỉ chứa ký tự đặc biệt
    public void testSave_DiaChi_KTDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.save("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội@","0988776432","T","123456",capBac,1,image));
    }

// Test case chức năng tìm kiếm không thành công
    public void testSearchNhanVien() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        assertEquals(false,quanLyNhanVien.searchNhanVien("NV55"));
    }

//    Test case cập nhật thành công
    public void testUpdate_Success() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(true,quanLyNhanVien.update("Nguyễn Tuấn Tú","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , để trống tên
    public void testUpdate_NameNull() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , không hợp lệ, tên chứa số
    public void testUpdate_Name_Invalid() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài123","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image,"NV1"));
    }



    //Test Case sửa nhân viên không thành công , tên vượt quá độ dài cho phép
    public void testUpdate_Name_Max() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , tên chứa ký tự đặc biệt
    public void testUpdate_Name_KTDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài@","Nam",
                "2003-12-21","Hà Nội","0988786546","Taik3","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , tài khoản đã tồn tại
    public void testUpdate_AccountExit() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài", "Nam",
                "2003-12-21", "Hà Nội", "0988786546", "Taik3", "123456", capBac, 1, image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , tài khoản chứa ký tự đặc biệt
    public void testUpdate_Account_Invalid() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài", "Nam",
                "2003-12-21", "Hà Nội", "0988786546", "Taik3@@", "123456", capBac, 1, image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , tài khoản chứa khoảng trắng ở hai đầu
    public void testUpdate_Account_Invalid_space() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài", "Nam",
                "2003-12-21", "Hà Nội", "0988786546", " Tai123 ", "123456", capBac, 1, image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , ngày sinh sai định dạng
    public void testUpdate_NgaySinh() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài","Nam",
                "abc","Hà Nội","0988786546","T","123456",capBac,1,image,"NV1"));
    }


    //Test Case sửa nhân viên không thành công , số điện thoại sai định dạng
    public void testUpdate_SDT_Invalid() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","12345","T","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , số điện thoại chứa ký tự đặc biệt
    public void testUpdate_SDT_KYDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","098877643@","T","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , số điện thoại đã tồn tại
    public void testUpdate_SDT_Exit() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","0666666666","T","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , mật khẩu chứa ký tự đặc biệt
    public void testUpdate_MK_KYDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội","0988776432","T","123456@",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , địa chỉ quá dài vượt quá mức cho phép
    public void testUpdate_DiaChi_Max() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaaa","0988776432","T","123456",capBac,1,image,"NV1"));
    }
    //Test Case sửa nhân viên không thành công , địa chỉ chứa ký tự đặc biệt
    public void testUpdate_DiaChi_KTDB() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("Nguyễn Tuấn Tài","Nam",
                "2003-12-21","Hà Nội@","0988776432","T","123456",capBac,1,image,"NV1"));
    }

    //Test Case sửa nhân viên không thành công , tất cả trường dữ liệu để trống
    public void testUpdate_NuLL() {
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        CapBac capBac = new CapBac();
        capBac.setId("5FCC7087-2F6C-440B-883E-1737CBF6A8FF");
        byte[] image = new byte[100];
        assertEquals(false,quanLyNhanVien.update("","",
                "","","","","",capBac,1,image,""));
    }
}