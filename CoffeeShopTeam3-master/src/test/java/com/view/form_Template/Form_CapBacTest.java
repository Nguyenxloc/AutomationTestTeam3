package com.view.form_Template;

import junit.framework.TestCase;

public class Form_CapBacTest extends TestCase {

    public void testCheckingThem() {
        Form_CapBac form_capBac = new Form_CapBac();
        assertEquals(true,form_capBac.checkingThem("NV100","Lao công","1234"));
    }

    public void testCheckingUpdate() {
        Form_CapBac form_capBac = new Form_CapBac();
        assertEquals(true,form_capBac.checkingUpdate("9FBAA217-7E5C-40FB-8252-206BC56B9223","NV100","Lao công","350"));
    }

    public void testCheckingDelete() {
        Form_CapBac form_capBac = new Form_CapBac();
        assertEquals(true,form_capBac.checkingDelete("C6FB2DF0-3614-430A-B54C-7CEF648AEB11"));
    }
}