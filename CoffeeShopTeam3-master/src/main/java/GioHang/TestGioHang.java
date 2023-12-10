package GioHang;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TestGioHang extends Component {

    ArrayList<GioHang> list = new ArrayList<>();

    public void list() {
        list.add(new GioHang("1", "Áo phông", (float) 120, 11));
        list.add(new GioHang("2", "Áo sơ mi", (float) 320, 11));
        list.add(new GioHang("3", "Áo gió", (float) 330, 11));
        list.add(new GioHang("4", "Áo nắng", (float) 180, 11));
    }

    public boolean addGioHang(String id, String tensp, Float giaTien, Integer soLuong){
        boolean status = false;
        GioHang gioHang = new GioHang(id, tensp, giaTien, soLuong);
        list.add(gioHang);

        if(id.equals("")){
            System.out.println("Nhap vao ten san pham");
            return false;
        }else {
            status = true;
        }
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
        if (gioHang!=null) {
            System.out.println("Thêm thành công");
            status = true;
        }
        return status;
    }

    public boolean updateGioHang(String id, String tensp, Float giaTien, Integer soLuong){
        boolean status = false;
        GioHang gioHang = new GioHang(id, tensp, giaTien, soLuong);
        list.add(gioHang);

        if(id.equals("")){
            System.out.println("Nhap vao ten san pham");
            return false;
        }else {
            status = true;
        }
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
        if (gioHang!=null) {
            System.out.println("Sửa thành công");
            status = true;
        }
        return status;
    }


}
