package KiemThu;

import junit.framework.TestCase;

public class TestCaseTest extends TestCase {

    public void testAddGioHang() {
        KiemThu.TestCase  testCase = new KiemThu.TestCase();
        assertEquals(true, testCase.addGioHang("ưer", 3.3, 5));
    }

    public void testUpdateGioHang() {
        KiemThu.TestCase  testCase = new KiemThu.TestCase();
        assertEquals(true, testCase.updateGioHang("", 3.3, 5));
    }

    public void testDeleteGioHang() {
        KiemThu.TestCase  testCase = new KiemThu.TestCase();
        assertEquals(true, testCase.deleteGioHang("túi"));
    }
}