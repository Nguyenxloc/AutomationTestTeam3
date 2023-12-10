package com.view.form_Template;

import junit.framework.TestCase;
import model.KhuyenMai;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Form_KhuyenMaiTest extends TestCase {

//    Test case thêm khuyến mãi thành công
    @Test
    public void testAddKhuyenMai_Success() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "27-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "28-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
             ngayBatDau = simpleDateFormat.parse(ngayBDString);
             ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(true,km.addKhuyenMai("KM022","Giảm giá Noel","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }

// Test case thêm khuyến mãi không thành công với mã khuyến mãi để trống
    @Test
    public void testAddKhuyenMai_CheckMaKmNull() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("","Giảm giá Noel","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }

    // Test case thêm khuyến mãi không thành công với mã khuyến mãi đã tồn tại
    @Test
    public void testAddKhuyenMai_CheckMaKmExit() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM003","Giảm giá Noel","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }

    // Test case thêm khuyến mãi không thành công với giá khuyến mãi quá lớn
    @Test
    public void testAddKhuyenMai_CheckGiaMaKm() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM0025","Giảm giá Noel","%","80",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }

    // Test case thêm khuyến mãi không thành công với giá khuyến mãi không đúng định dạng, giá là  là số âm
    @Test
    public void testAddKhuyenMai_CheckGiaKM() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "23-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "26-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM007","Giảm giá Noel","%","-2",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }

    // Test case thêm khuyến mãi không thành công với giá khuyến mãi chứa ký tự đặc biệt
    @Test
    public void testAddKhuyenMai_CheckGiaKM_KTDB() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "23-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "26-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM007","Giảm giá Noel","%","20@",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }

    // Test case thêm khuyến mãi không thành công với giá khuyến mãi là chuỗi ký tự
    @Test
    public void testAddKhuyenMai_CheckGiaKM_String() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "23-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "26-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM007","Giảm giá Noel","%","hai muoi",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }
    // Test case thêm khuyến mãi không thành công với ngày bắt đầu trong quá khứ
    @Test
    public void testAddKhuyenMai_CheckNgayBD() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "20-01-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM009","Giảm giá Noel","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }

    // Test case thêm khuyến mãi không thành công với ngày bắt đầu phải trước ngày kết thúc
    @Test
    public void testAddKhuyenMai_CheckNgayBD_Before_NgayKT() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "29-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM009","Giảm giá Noel","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }


    // Test case thêm khuyến mãi không thành công với tên khuyến mãi chứa ký tự đặc biệt
    @Test
    public void testAddKhuyenMai_CheckTenKM() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "26-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM009","Giảm giá Noel@","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }


    // Test case thêm khuyến mãi không thành công với tên khuyến mãi để trống
    @Test
    public void testAddKhuyenMai_CheckTenKMNull() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "22-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "26-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.addKhuyenMai("KM009","","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));
    }




    // Test case xóa khuyến mãi thành công
    @Test
    public void testDeleteKhuyeMai_Success(){
        Form_KhuyenMai km = new Form_KhuyenMai();
        Assert.assertEquals(true,km.deleteKhuyeMai(1,"KM003"));
    }

    // Test Case xóa khuyến mãi không thành công
    @Test
    public void testDeleteKhuyeMai_NotSuccess(){
        Form_KhuyenMai km = new Form_KhuyenMai();
        Assert.assertEquals(false,km.deleteKhuyeMai(-1,"KM003"));
    }

//    Test case sửa khuyến mãi thành công
    @Test
    public void testUpdateKhuyenMai_Success() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "27-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "28-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(true,km.updateKhuyenMai("KM005","Tết đoàn viên","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));

    }

    //    Test case sửa khuyến mãi thành công với mã khuyến mãi không tồn tại
    @Test
    public void testUpdateKhuyenMai_MaKM_NotExit() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "27-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "28-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.updateKhuyenMai("KM009","Tết đoàn viên","%","20",ngayBatDau,ngayKetThuc,"Đang hoạt động"));

    }

    //    Test case sửa khuyến mãi thành công với giá trị khuyến mãi quá lớn
    @Test
    public void testUpdateKhuyenMai_GiaKM_Max() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "27-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "28-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.updateKhuyenMai("KM005","Tết đoàn viên","%","90",ngayBatDau,ngayKetThuc,"Đang hoạt động"));

    }

    //    Test case sửa khuyến mãi thành công với giá trị khuyến mãi là số âm
    @Test
    public void testUpdateKhuyenMai_GiaKM_SoAm() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "23-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "26-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.updateKhuyenMai("KM005","Tết đoàn viên","%","-10",ngayBatDau,ngayKetThuc,"Đang hoạt động"));

    }

    // Test case sửa khuyến mãi thành công với giá trị khuyến mãi là chứa ký tự đặc biệt
    @Test
    public void testUpdateKhuyenMai_GiaKM_KTDB() {
        Form_KhuyenMai km = new Form_KhuyenMai();
        String ngayBDString = "23-11-2023"; // Chuỗi ngày cần chuyển đổi
        String ngayKTString = "26-11-2023"; // Chuỗi ngày cần chuyển đổi
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ngayBatDau = null;
        Date ngayKetThuc = null;
        try {
            ngayBatDau = simpleDateFormat.parse(ngayBDString);
            ngayKetThuc = simpleDateFormat.parse(ngayKTString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(false,km.updateKhuyenMai("KM005","Tết đoàn viên","%","10@",ngayBatDau,ngayKetThuc,"Đang hoạt động"));

    }

// Test Case sửa khuyến mãi thành công
    public void testSearchKhuyenMai() {
        Form_KhuyenMai form_khuyenMai = new Form_KhuyenMai();
        assertEquals(true,form_khuyenMai.searchKhuyenMai("KM005"));
    }


}