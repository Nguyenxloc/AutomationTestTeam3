package GioHang;

public class GioHang {

    private String id;

    private String tenSP;

    private Float gia;

    private Integer soLuong;

    public GioHang() {
    }

    public GioHang(String id, String tenSP, Float gia, Integer soLuong) {
        this.id = id;
        this.tenSP = tenSP;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
