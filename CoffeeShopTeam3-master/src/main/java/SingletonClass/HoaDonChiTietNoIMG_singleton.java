/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SingletonClass;

import viewModel.HoaDonChiTietNoIMG;

/**
 *
 * @author 84374
 */
public class HoaDonChiTietNoIMG_singleton {

    private static HoaDonChiTietNoIMG_singleton single_instance = null;

    // Declaring a variable of type String
    public HoaDonChiTietNoIMG hoaDonChiTietNoIMG;

    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private HoaDonChiTietNoIMG_singleton() {
        hoaDonChiTietNoIMG = null;
    }

    // Static method
    // Static method to create instance of Singleton class
    public static synchronized HoaDonChiTietNoIMG_singleton getInstance() {
        if (single_instance == null) {
            single_instance = new HoaDonChiTietNoIMG_singleton();
        }
        return single_instance;
    }
}
