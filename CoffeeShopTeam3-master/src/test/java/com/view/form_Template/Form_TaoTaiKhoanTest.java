package com.view.form_Template;

import junit.framework.TestCase;
import model.CapBac;

import java.util.Date;

public class Form_TaoTaiKhoanTest extends TestCase {

    public void testCreateAccount() {
        Form_TaoTaiKhoan form_taoTaiKhoan = new Form_TaoTaiKhoan();
        assertEquals(true, form_taoTaiKhoan.createAccount("1", "1", new Date("23/04/2003"), "1", "1", "1", "", "1"));

    }
}