package com.swaglabsm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabsm.base.BaseTest;
import com.swaglabsm.screens.LoginScreen;
import com.swaglabsm.screens.NavigationBar;
import com.swaglabsm.utils.Helper;

/**
 * Test class for verifying login functionality.
 * Tests successful login with valid credentials.
 */
public class LoginTest extends BaseTest {
    
    /**
     * Tests the login process with valid credentials.
     */
    @Test
    public void testLoginWithValidCredentials() {
        NavigationBar navigationBar = new NavigationBar(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        
        navigationBar.navigateToLogin();
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed(), "Login screen should be displayed");
        
        loginScreen.login("alice@example.com", "mypassword");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        Assert.assertTrue(loginScreen.isLoginSuccessPopupDisplayed(), "Login should be successful");
    }
}
