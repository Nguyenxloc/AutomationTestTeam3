package GioHang;

import junit.framework.TestCase;

public class TestGioHangTest extends TestCase {


    public void testTestAddGioHangDung() {
        TestGioHang testGioHang = new TestGioHang();
        assertEquals(true, testGioHang.addGioHang("5", "Áo len", (float) 220, 9));
    }

    public void testTestAddGioHangSai() {
        TestGioHang testGioHang = new TestGioHang();
        assertEquals(true, testGioHang.addGioHang("", "", (float) 220, 9));
    }

    public void testUpdateGioHangDung() {
        TestGioHang testGioHang = new TestGioHang();
        assertEquals(true, testGioHang.updateGioHang("5", "Áo len", (float) 250, 10));
    }

    public void testUpdateGioHangSai() {
        TestGioHang testGioHang = new TestGioHang();
        assertEquals(true, testGioHang.updateGioHang("", "", (float) 250, 10));
    }
}