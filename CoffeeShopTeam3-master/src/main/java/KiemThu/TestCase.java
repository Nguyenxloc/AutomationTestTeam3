package KiemThu;

import java.util.ArrayList;
import java.util.List;

public class TestCase {
    List<GioHang> listGH = new ArrayList<>();

    public TestCase() {
        listGH.add(new GioHang("Túi sách", 5000.0, 5));
        listGH.add(new GioHang("Giày", 6000.0, 5));
        listGH.add(new GioHang("Ví", 2000.0, 5));
    }

    public boolean addGioHang(String tensp, Double giaTien, Integer soLuong){
        boolean status = false;
        GioHang gioHang = new GioHang(tensp, giaTien, soLuong);
        listGH.add(gioHang);
        if(tensp.equals("")){
            System.out.println("Nhap vao ten san pham");
            return false;
        }else {
            status = true;
        }
        if(giaTien.equals("")){
            System.out.println("Nhap vao ten gia tien");
            return false;
        }else {
            status = true;
        }
        if(soLuong.equals("")){
            System.out.println("Nhap vao so luong");
           return false;
        }else {
            status = true;
        }
        return status;
    }

    public boolean updateGioHang(String tensp, Double giaTien, Integer soLuong){
        boolean status = false;
        GioHang gioHang = new GioHang(tensp, giaTien, soLuong);
        listGH.add(gioHang);
        if(tensp.equals("")){
            System.out.println("Nhap vao ten san pham");
            return false;
        }else {
            status = true;
        }
        if(giaTien.equals("")){
            System.out.println("Nhap vao ten gia tien");
            return false;
        }else {
            status = true;
        }
        if(soLuong.equals("")){
            System.out.println("Nhap vao so luong");
            return false;
        }else {
            status = true;
        }
        return status;
    }

    public boolean deleteGioHang(String tensp){
        GioHang gioHang = null;
        boolean status = false;
        listGH.add(gioHang);
        if(tensp.equals("")){
            status = false;
            System.out.println("Xoa that bai");
        }else {
            status = true;
            listGH.remove(1);
            System.out.println("xoa thanh cong");
        }

        return status;
    }
}
