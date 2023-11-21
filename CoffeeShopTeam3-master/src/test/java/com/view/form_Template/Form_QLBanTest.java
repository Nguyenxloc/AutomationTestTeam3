package com.view.form_Template;

import junit.framework.TestCase;
import viewModel.QLBan;

public class Form_QLBanTest extends TestCase {

    public void testThemBan() {
        Form_QLBan qlBan = new Form_QLBan();
        assertEquals(true, qlBan.themBan(14, "bàn 14"));
    }


    public void testSuaBan() {
        Form_QLBan qlBan = new Form_QLBan();
        assertEquals(true, qlBan.suaBan(5, "Bàn 15"));
    }

    public void testXoaBan() {
        Form_QLBan qlBan = new Form_QLBan();
        assertEquals(true, qlBan.xoaBan(5));
    }
}