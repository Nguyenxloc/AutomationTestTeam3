package KiemThu;


public class GioHang {
     private String tenSP;
     private Double giaTien;
     private Integer soLuong;

    public GioHang() {
    }

    public GioHang(String tenSP, Double giaTien, Integer soLuong) {
        this.tenSP = tenSP;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
