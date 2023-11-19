/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view.main;

import SingletonClass.NV_singleton;
import com.view.DAO1.NhanVienDao;
import com.view.model.NhanVien;

import java.io.File;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import model.CapBac;
import repository.DAO_CapBac;
import ultilities.DBConnection;
import ultilities.DBConnection1;

public class LoginFrame extends javax.swing.JFrame {

    private DBConnection connection = new DBConnection();
    private NhanVienDao dao = new NhanVienDao();
    private DAO_CapBac daoCapBac = new DAO_CapBac();
    private String dir = null;

    ////// query sql -- get vaiTro
    //select *from taikhoan
    // if vaiTro=1--->sv--->form sv
    // if vaiTro=2--->gv--->form gv
    // if vaiTro=3--->cb--->form cb

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        String path = "CoffeeShopTeam3-master\\src\\main\\java\\com\\view\\icon\\";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        dir = absolutePath;
        initComponents();
        setLocationRelativeTo(null);
        btnLogin.setkBorderRadius(30);
        System.out.println("test dir: " + dir);
    }

    public boolean checkingPort(String userName, String pass) {
        DBConnection dbConn = new DBConnection();
        String us = userName;
        String ps = pass;
        String sql = "	select * from NhanVien where TaiKhoan =? and MatKhau = ?";
        boolean status = false;
        try (Connection con = connection.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, us);
            st.setString(2, ps);
            ResultSet rs = st.executeQuery();
            DAO_CapBac dao_capBac = new DAO_CapBac();
            if (rs.next()) {
                System.out.println("test nv singleton1");
                System.out.println(rs);
                CapBac capBac = dao_capBac.selectByID(rs.getString("IdCB"));
                String vaiTro = capBac.getTenCB();
                NV_singleton.getInstance().nv = new model.NhanVien(rs.getString("Id"), rs.getString("Ma"), rs.getNString("Ten"),
                        rs.getNString("TenDem"), rs.getNString("Ho"), rs.getNString("GioiTinh"), rs.getDate("NgaySinh"),
                        rs.getNString("DiaChi"), rs.getString("Sdt"), rs.getString("TaiKhoan"),
                        rs.getString("MatKhau"), capBac, rs.getInt("TrangThai"), rs.getBytes("HinhAnh"), rs.getString("NgayTao"));
                if (vaiTro.strip().equalsIgnoreCase("Quản lý")) {
                    System.out.println("case 1");
                    this.setVisible(false);
                    MainTemplate view = new MainTemplate();
                    view.setVisible(true);
                    status = true;
                } else {
                    System.out.println("case 2 ");
                    this.setVisible(false);
                    MainOfNV viewNV = new MainOfNV();
                    viewNV.setVisible(true);
                    status = false;
                }
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
            } else {
                // JOptionPane.showMessageDialog(null, "Username or Password không chính xác");
                String manv = txtUser.getText().trim();
                String matKhau = new String(txtPassword.getPassword()).trim();
                NhanVien nhanVien = dao.selectByAccount(manv);
                Pattern regex = Pattern.compile("[^A-Za-z0-9]");
                if (txtUser.getText().equals("") && txtPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "Chưa nhập thông tin đăng nhập!");
                    txtUser.requestFocus();
                    status = false;

                } else if (txtUser.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
                    txtUser.requestFocus();
                    status = false;
                } else if (regex.matcher(manv).find()) {
                    JOptionPane.showMessageDialog(this, "Tài khoản chứa ký tự đặc biệt!");
                    txtUser.setText("");
                    txtUser.requestFocus();
                    status = false;
                } else if (txtPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu!");
                    txtPassword.requestFocus();
                    status = false;
                } else if (regex.matcher(matKhau).find()) {
                    JOptionPane.showMessageDialog(this, "Mật khẩu chứa ký tự đặc biệt!");
                    txtPassword.setText("");
                    txtPassword.requestFocus();
                    status = false;
                } else if (nhanVien == null) {
                    JOptionPane.showMessageDialog(this, "Sai tài khoản");
                    status = false;
                } else if (!ps.equals("12345")) {
                    JOptionPane.showMessageDialog(this, " Sai mật khẩu");
                    txtPassword.requestFocus();
                    status = false;
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        btnLogin = new com.k33ptoo.components.KButton();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        lblMessUser = new javax.swing.JLabel();
        lblMessPass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setAlignmentX(1.0F);
        kGradientPanel1.setAlignmentY(1.0F);
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 153));
        kGradientPanel1.setkGradientFocus(150);
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 153, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN FORM");

        lblPassword.setText("password");

        lblUsername.setText("username");

        btnLogin.setBorder(null);
        btnLogin.setText("Login");
        btnLogin.setAlignmentX(1.0F);
        btnLogin.setAlignmentY(1.0F);
        btnLogin.setDisplayedMnemonicIndex(1);
        btnLogin.setIconTextGap(6);
        btnLogin.setkBackGroundColor(new java.awt.Color(0, 0, 204));
        btnLogin.setkBorderRadius(30);
        btnLogin.setkEndColor(new java.awt.Color(0, 102, 255));
        btnLogin.setkHoverColor(new java.awt.Color(0, 0, 0));
        btnLogin.setkHoverEndColor(new java.awt.Color(102, 255, 255));
        btnLogin.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btnLogin.setkHoverStartColor(new java.awt.Color(102, 255, 255));
        btnLogin.setkIndicatorThickness(7);
        btnLogin.setkPressedColor(new java.awt.Color(255, 255, 255));
        btnLogin.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btnLogin.setkStartColor(new java.awt.Color(51, 102, 255));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setIcon(new javax.swing.ImageIcon(dir + "\\baomat2.png"));

        lblMessUser.setForeground(new java.awt.Color(255, 0, 0));

        lblMessPass.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)
                                                .addComponent(jLabel3))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                                                        .addComponent(txtPassword)
                                                        .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblMessUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblMessPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(lblUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMessUser, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPassword)
                                .addGap(4, 4, 4)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lblMessPass, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 410, 520));

        jLabel1.setIcon(new javax.swing.ImageIcon(dir + "\\baomat1.png"));
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 520, 340));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html>HAVE GOOD DAY !");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 270, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void SercurityPort() {
        DBConnection dbConn = new DBConnection();
        String us = txtUser.getText();
        String ps = txtPassword.getText();
        String sql = "	select * from NhanVien where TaiKhoan =? and MatKhau = ?";
        try (Connection con = connection.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, us);
            st.setString(2, ps);
            ResultSet rs = st.executeQuery();
            DAO_CapBac dao_capBac = new DAO_CapBac();
            if (rs.next()) {
                System.out.println("test nv singleton1");
                System.out.println(rs);
                CapBac capBac = dao_capBac.selectByID(rs.getString("IdCB"));
                String vaiTro = capBac.getTenCB();
                NV_singleton.getInstance().nv = new model.NhanVien(rs.getString("Id"), rs.getString("Ma"), rs.getNString("Ten"),
                        rs.getNString("TenDem"), rs.getNString("Ho"), rs.getNString("GioiTinh"), rs.getDate("NgaySinh"),
                        rs.getNString("DiaChi"), rs.getString("Sdt"), rs.getString("TaiKhoan"),
                        rs.getString("MatKhau"), capBac, rs.getInt("TrangThai"), rs.getBytes("HinhAnh"), rs.getString("NgayTao"));
                if (vaiTro.strip().equalsIgnoreCase("Quản lý")) {
                    System.out.println("case 1");
                    this.setVisible(false);
                    MainTemplate view = new MainTemplate();
                    view.setVisible(true);
                } else {
                    System.out.println("case 2 ");
                    this.setVisible(false);
                    MainOfNV viewNV = new MainOfNV();
                    viewNV.setVisible(true);
                }
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
            } else {
                // JOptionPane.showMessageDialog(null, "Username or Password không chính xác");
                String manv = txtUser.getText().trim();
                String matKhau = new String(txtPassword.getPassword()).trim();
                NhanVien nhanVien = dao.selectByAccount(manv);
                Pattern regex = Pattern.compile("[^A-Za-z0-9]");
                if (txtUser.getText().equals("") && txtPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "Chưa nhập thông tin đăng nhập!");
                    txtUser.requestFocus();
                    return;

                } else if (txtUser.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
                    txtUser.requestFocus();
                    return;
                } else if (regex.matcher(manv).find()) {
                    JOptionPane.showMessageDialog(this, "Tài khoản chứa ký tự đặc biệt!");
                    txtUser.setText("");
                    txtUser.requestFocus();
                    return;
                } else if (txtPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu!");
                    txtPassword.requestFocus();
                    return;
                } else if (regex.matcher(matKhau).find()) {
                    JOptionPane.showMessageDialog(this, "Mật khẩu chứa ký tự đặc biệt!");
                    txtPassword.setText("");
                    txtPassword.requestFocus();
                    return;
                } else if (nhanVien == null) {
                    JOptionPane.showMessageDialog(this, "Sai tài khoản");
                    return;
                } else if (!ps.equals("12345")) {
                    JOptionPane.showMessageDialog(this, " Sai mật khẩu");
                    txtPassword.requestFocus();
                    return;
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
//         MainTemplate view = new MainTemplate();
//         view.setVisible(true);
        String userN = txtUser.getText();
        String pass = txtPassword.getText();
        checkingPort(userN, pass);
//        SercurityPort();
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblMessPass;
    private javax.swing.JLabel lblMessUser;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    public boolean check() {
        String manv = txtUser.getText().trim();
        String matKhau = new String(txtPassword.getPassword()).trim();
        NhanVien nhanVien = dao.selectByAccount(manv);
        Pattern regex = Pattern.compile("[^A-Za-z0-9]");
        if (txtUser.getText().equals("") && txtPassword.getPassword().length == 0) {

            JOptionPane.showMessageDialog(this, "Chưa nhập thông tin đăng nhập!");
            txtUser.requestFocus();
            return true;

        } else if (txtUser.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
            txtUser.requestFocus();
            return true;
        } else if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu!");
            txtPassword.requestFocus();
            return true;
        } else if (regex.matcher(matKhau).find()) {
            JOptionPane.showMessageDialog(this, "Mật khẩu chứa ký tự đặc biệt!");
            txtPassword.setText("");
            txtPassword.requestFocus();
            return true;
        } else if (nhanVien == null) {
            JOptionPane.showMessageDialog(this, "Sai tài khoản");
            return true;
        } else if (!matKhau.equals(nhanVien.getPass())) {
            JOptionPane.showMessageDialog(this, " Sai mật khẩu");
            txtPassword.requestFocus();
            return true;
        }
        return false;
    }

    private void login() {

        String manv = txtUser.getText();
        String matKhau = new String(txtPassword.getPassword());

        try {
            NhanVien User = dao.selectByAccount(manv);
            if (User != null) {
                String matKhau2 = User.getPassword();
                CapBac capBac = daoCapBac.selectByID(User.getCapBac().getId());
                String vaiTro = capBac.getTenCB();
                if (matKhau.equals(matKhau2)) {
                    //ShareHelper.USER = User;
                    if (vaiTro.strip().equalsIgnoreCase("Quản lý")) {
                        System.out.println("case 1");
                        MainTemplate view = new MainTemplate();
                        view.setVisible(true);
                        this.dispose();
                    } else {
                        System.out.println("case 2 ");
                        MainOfNV viewNV = new MainOfNV();
                        viewNV.setVisible(true);
                        this.dispose();
                    }

                } else {
                    //alert("Sai mật khẩu!");
                    JOptionPane.showMessageDialog(this, "Sai maatj khaau");

                }
            } else {
                //alert("Tài khoản này không tồn tại");
                JOptionPane.showMessageDialog(this, "ktt");

            }
        } catch (Exception e) {
            //alert("Lỗi truy vấn dữ liệu!");
            JOptionPane.showMessageDialog(this, "ktt");
        }
    }

}
