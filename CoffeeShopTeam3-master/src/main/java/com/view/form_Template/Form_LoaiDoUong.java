/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.view.form_Template;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ILoaiDoUongService;
import service.LoaiDoUongService;
import viewModel.QLLoaiDoUong;

/**
 *
 * @author MSI-G8
 */
public class Form_LoaiDoUong extends javax.swing.JPanel {

    private ILoaiDoUongService loaiDoUongService = new LoaiDoUongService();
    private int current = 0;
    /**
     * Creates new form Form_LoaiDoUong
     */
    public Form_LoaiDoUong() {
        initComponents();
        loadTable();
    }

    public void loadTable(){
        List<QLLoaiDoUong> ds = loaiDoUongService.getALL();
        DefaultTableModel dtm = (DefaultTableModel) tblTable.getModel();
        dtm.setRowCount(0);
        for(QLLoaiDoUong ql : ds){
            Object[] rowData = {ql.getId(), ql.getMa(), ql.getTen()};
            dtm.addRow(rowData);
        }
    }
    
    public void clear(){
        txtID.setText("");
        txtMa.setText("");
        txtTen.setText("");
    }
    
    public void mouseClick(){
        int row = tblTable.getSelectedRow();
        
        txtID.setText(tblTable.getValueAt(row, 0).toString());
        txtMa.setText(tblTable.getValueAt(row, 1).toString());
        txtTen.setText(tblTable.getValueAt(row, 2).toString());
    }
    
    private QLLoaiDoUong getForm(){
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        
        if(ma.trim().equals("") || ten.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        
        if(!ma.matches("[a-zA-Z0-9]+$")){
            JOptionPane.showMessageDialog(this, "Mã không hợp lệ");
            return null;
        }
        
        if(ten.trim().length() != ten.length()){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
            return null;
        }
        
        if(!ten.matches("^[\\p{L}\\p{M}0-9 ]+$")){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
            return null;
        }
//        else{
//           
//        }   
        QLLoaiDoUong ql = new QLLoaiDoUong();
        ql.setMa(ma);
        ql.setTen(ten);
        
        return ql;
    
    }
    
    private void  upDateTimKiem(List<QLLoaiDoUong> list){
        DefaultTableModel dtm = (DefaultTableModel) tblTable.getModel();
        dtm.setRowCount(0);
        for(QLLoaiDoUong ql : list){
            Object[] rowData = {ql.getId(), ql.getMa(), ql.getTen()};
            dtm.addRow(rowData);
        }
    }
    
    public void setModel(QLLoaiDoUong ld){
        txtID.setText(ld.getId());
        txtMa.setText(ld.getMa());
        txtTen.setText(ld.getTen());
    }


    public boolean checkingThem(String ma, String ten){
//         ma = txtMa.getText();
//         ten = txtTen.getText();
        boolean status = false;
        if(ma.trim().equals("") || ten.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        }

        if(!ma.matches("[a-zA-Z0-9]+$")){
            JOptionPane.showMessageDialog(this, "Mã không hợp lệ");
            return false;
        }

        if(ten.trim().length() != ten.length()){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
            return false;
        }

        if(!ten.matches("^[\\p{L}\\p{M}0-9 ]+$")){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
            return false;
        }

        QLLoaiDoUong ql = new QLLoaiDoUong();
        ql.setMa(ma);
        ql.setTen(ten);

        if(ql != null){
            loaiDoUongService.them(ql);
            loadTable();
            clear();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm không thành công");
        }

        return true;
    }

    public boolean checkingUpdate(Integer vitri,String tenUpdate,String maUpdate){
//        String ma = txtMa.getText();
//        String ten = txtTen.getText();
        boolean status = false;
        if( tenUpdate.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return false;
        }

        if(!maUpdate.matches("[a-zA-Z0-9]+$")){
            JOptionPane.showMessageDialog(this, "Mã không hợp lệ");
            return false;
        }

        if(tenUpdate.trim().length() != tenUpdate.length()){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
            return false;
        }

        if(!tenUpdate.matches("^[\\p{L}\\p{M}0-9 ]+$")){
            JOptionPane.showMessageDialog(this, "Tên không hợp lệ");
            return false;
        }

        QLLoaiDoUong ld = new QLLoaiDoUong();

        ld.setTen(tenUpdate);
        ld.setMa(maUpdate);

        int row = tblTable.getSelectedRow();
        if(vitri == -1){
            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để sửa");
            return false;
        }
        if(ld != null){
            loaiDoUongService.sua(ld);
            loadTable();
            clear();
            return true;
        }else{
            JOptionPane.showMessageDialog(this, "Sửa không thành công");
            return false;
        }


    }

    public boolean checkingDelete(String id){
        boolean status = false;
        if(id.equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn id");
            return false;
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loaiDoUongService.xoa(id);
            loadTable();
            clear();
            return true;
        }
//        return true;
    }

    public boolean checkingTimKiem(String timkiem){
        String timKiem = timkiem.trim().equals("")? "%" : timkiem;
        upDateTimKiem(loaiDoUongService.timKiem(timKiem, timKiem));
        return true;
    }


    
//    private void updatePreNext() {
//        // Xóa tất cả các dòng trong dtm
//        DefaultTableModel dtm = (DefaultTableModel) tblTable.getModel();
//        dtm.setRowCount(0);
//        // Lấy thông tin về các cột từ ResultSet
//        int columnCount = tblTable.getSelectedColumnCount();
//        for (int i = 1; i <= columnCount; i++) {
//            dtm.addColumn(columnCount);
//        }
//        // Thêm các bản ghi vào dtm từ ResultSet
//        List<QLLoaiDoUong> list = loaiDoUongService.getALL();
//        for(QLLoaiDoUong ql : list) {
//            Object[] rowData = {ql.getId(), ql.getMa(), ql.getTen()};
//            for (int i = 0; i < columnCount; i++) {
//                rowData[i] = list.get(i + 1);
//            }
//            dtm.addRow(rowData);
//        }
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        btnTKiem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("LOẠI ĐỒ UỐNG");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("ID -");

        jLabel3.setText("Mã: ");

        jLabel4.setText("Tên: ");

        txtID.setEditable(false);
        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        btnTKiem.setText("Tìm Kiếm");
        btnTKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(381, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnTKiem))
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtID, txtMa, txtTen});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên"
            }
        ));
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(265, 265, 265))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem)
                        .addGap(26, 26, 26)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addContainerGap())))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClear, btnSua, btnThem, btnXoa});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//        int row = tblTable.getSelectedRow();
//        String id = tblTable.getValueAt(row, 0).toString();
//        if(row == -1){
//            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để xóa");
//            return ;
//        }else{
//            JOptionPane.showMessageDialog(this, "Xóa thành công");
//            loaiDoUongService.xoa(id);
//            loadTable();
//            clear();
//        }
        String id = txtID.getText();
        checkingDelete(id);
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
        mouseClick();
    }//GEN-LAST:event_tblTableMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        QLLoaiDoUong ql = getForm();
//
//        if(ql != null){
//            loaiDoUongService.them(ql);
//            loadTable();
//            clear();
//        }else{
//            JOptionPane.showMessageDialog(this, "Thêm không thành công");
//        }

        String ma = txtMa.getText();
        String ten = txtTen.getText();
        checkingThem(ma,ten);

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
//        QLLoaiDoUong ld = getForm();
//        int row = tblTable.getSelectedRow();
//
//        if(row == -1){
//            JOptionPane.showMessageDialog(this, "Chọn 1 dòng để sửa");
//            return;
//        }
//        if(ld != null){
//            loaiDoUongService.sua(ld);
//            loadTable();
//            clear();
//        }else{
//            JOptionPane.showMessageDialog(this, "Sửa không thành công");
//        }

        int row = tblTable.getSelectedRow();
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        checkingUpdate(row,ten,ma);
        
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKiemActionPerformed
//        String timKiem = txtTimKiem.getText().trim().equals("")? "%" : txtTimKiem.getText();
//        upDateTimKiem(loaiDoUongService.timKiem(timKiem, timKiem));

        String tt = txtTimKiem.getText();
        checkingTimKiem(tt);
        
    }//GEN-LAST:event_btnTKiemActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTKiem;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
