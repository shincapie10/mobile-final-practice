package com.swaglabsm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabsm.base.BaseTest;
import com.swaglabsm.screens.LoginScreen;
import com.swaglabsm.screens.NavigationBar;
import com.swaglabsm.utils.Helper;

/**
 * Test class for verifying sign-up functionality.
 * Tests successful user registration with valid credentials.
 */
public class SignUpTest extends BaseTest {

    /**
     * Tests the sign-up process with valid credentials.
     */
    @Test
    public void testSignUpWithValidCredentials() {
        NavigationBar navigationBar = new NavigationBar(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        
        navigationBar.navigateToLogin();
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed(), "Login screen should be displayed");
        
        String email = Helper.generateRandomEmail();
        String password = Helper.getDefaultPassword();
        
        loginScreen.signUp(email, password);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        Assert.assertTrue(loginScreen.isSignUpSuccessPopupDisplayed(), "Sign up should be successful");
        loginScreen.closePopup();
    }
}
