package com.view.main;

import junit.framework.TestCase;

public class LoginFrameTest extends TestCase {

    public void testCheckingPort() {
        LoginFrame login = new LoginFrame();
        assertEquals(true,login.checkingPort("nguyenloc","123456"));
    }

    public void testCheckingPort_khongthanhcong() {
        LoginFrame login = new LoginFrame();
        assertEquals(false,login.checkingPort("nguyenloc","12345"));
    }

}