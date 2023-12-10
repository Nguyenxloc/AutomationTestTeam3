package com.view.form_Template;

import junit.framework.TestCase;

public class Form_LoaiDoUongTest extends TestCase {

    public void testCheckingThem() {
        Form_LoaiDoUong form_loaiDoUong = new Form_LoaiDoUong();
        assertEquals(true,form_loaiDoUong.checkingThem("@GGga","dd"));
    }

    public void testCheckingUpdate() {
        Form_LoaiDoUong form_loaiDoUong = new Form_LoaiDoUong();
        assertEquals(true,form_loaiDoUong.checkingUpdate( 1,"Kem que","SP01"));
    }

    public void testCheckingDelete() {
        Form_LoaiDoUong form_loaiDoUong = new Form_LoaiDoUong();
        assertEquals(true,form_loaiDoUong.checkingDelete( "066C9770-B4DF-4459-8ABF-5D73DA4A8671"));
    }

    public void testCheckingTimKiem() {
        Form_LoaiDoUong form_loaiDoUong = new Form_LoaiDoUong();
        assertEquals(true,form_loaiDoUong.checkingTimKiem("Kem"));
    }
}