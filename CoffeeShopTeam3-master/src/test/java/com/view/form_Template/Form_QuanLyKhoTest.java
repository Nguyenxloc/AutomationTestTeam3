package com.view.form_Template;

import junit.framework.TestCase;
import model.NhanVien;
import service.NhapKhoService;
import viewModel.QLNhapKho;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Form_QuanLyKhoTest extends TestCase {

    //Test chức năng quản lý kho
    Form_QuanLyKho quanLyKho = new Form_QuanLyKho();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    NhanVien nhanVien = new NhanVien();
    NhapKhoService nhapKhoService = new NhapKhoService();


    public void testNhapKho() {
        try {
            //Test chức năng thêm nguyên liệu vào kho
            //Test 1: Nhập nguyên liệu thành công
            //Test 2: Nhập nguyên liệu với trường dữ liệu trống -> Mong muốn nhập thất bại
            //Test 3: Nhập nguyên liệu với trường số lượng là số âm -> Mong muốn nhập thất bại
            nhanVien.setId("7A49333E-6EE2-4FFF-9D36-18107A3488DB");
            assertEquals(true, quanLyKho.nhapKho(
                    nhanVien,
                    "Cam",
                    new Date(sdf.parse("22/11/2023").getTime()),
                    "kg",
                    -8,
                    new BigDecimal(150000)
            ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Test chức năng sửa thông tin nguyên liệu
    public void testSua() {
        try {
            //Test chức năng sửa thông tin nguyên liệu
            //Test 1: Sửa nguyên liệu thành công
            //Test 2: Sửa thông tin nguyên liệu với trường dữ liệu trống -> Mong muốn sửa thất bại
            //Test 3: Sửa thông tin nguyên liệu với trường số lượng là số âm -> Mong muốn sửa thất bại
            nhanVien.setId("7A49333E-6EE2-4FFF-9D36-18107A3488DB");
            assertEquals(true, quanLyKho.sua(
                    "2319EA83-3170-432B-A4DA-4BA4F44D507F",
                    nhanVien,
                    "Táo",
                    new Date(sdf.parse("22/11/2023").getTime()),
                    "kg",
                    -8,
                    new BigDecimal(150000)
            ));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Test chức năng xóa nguyên liệu
    public void testXoa() {
        //Xóa thành công
        assertEquals(true, quanLyKho.xoa("152BF33B-D46F-4870-8B6A-8A8F7ADF1B12"));
    }

    //Test chức năng tìm kiếm nguyên liệu
    public void testTimKiem() {
        //Tạo 1 list danh sách nguyên liệu khi tìm được nguyên liệu tương ứng sẽ in ra nguyên liệu đó
        List<QLNhapKho> listQLNhapKho = nhapKhoService.getALL();
        try {
            for (QLNhapKho qlNhapKho : listQLNhapKho){
                assertEquals(true, quanLyKho.timKiem(
                        "",   //Tìm theo tên sản phẩm
                        null,  //Ngày bắt đầu
                        null,   //Ngày kết thúc
                        1,
                        10
                ));
                //Khi tìm được nguyên liệu có giá trị trùng với giá trị mình nhập vào thì sẽ in nguyên liệu đó ra
                //Tìm theo tên sản phẩm là cam -> Tìm được 3 sản phẩm có tên cam
                //Tìm theo khoảng ngày nhập nguyên liệu
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}