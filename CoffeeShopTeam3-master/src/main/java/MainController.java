/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.view.main.LoginFrame;

/**
 *
 * @author 84374
 */
public class MainController {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {    
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
