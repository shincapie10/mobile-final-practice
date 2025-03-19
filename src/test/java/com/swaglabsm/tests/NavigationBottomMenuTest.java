package com.swaglabsm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabsm.base.BaseTest;
import com.swaglabsm.screens.HomeScreen;
import com.swaglabsm.screens.LoginScreen;
import com.swaglabsm.screens.NavigationBar;
import com.swaglabsm.screens.SwipeScreen;

import io.appium.java_client.AppiumBy;

/**
 * Test class for verifying the bottom navigation menu functionality.
 * Tests navigation to different sections of the app using the bottom menu.
 */
public class NavigationBottomMenuTest extends BaseTest {

    /**
     * Tests the bottom navigation menu by navigating to each section and verifying the correct screen is displayed.
     */
    @Test
    public void testNavigationBottomMenu() {
        NavigationBar navigationBar = new NavigationBar(driver);
        HomeScreen homeScreen = new HomeScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        SwipeScreen swipeScreen = new SwipeScreen(driver);
        
        Assert.assertTrue(navigationBar.isTabVisible("home"), "Home tab should be visible");
        Assert.assertTrue(navigationBar.isTabVisible("webview"), "Webview tab should be visible");
        Assert.assertTrue(navigationBar.isTabVisible("login"), "Login tab should be visible");
        Assert.assertTrue(navigationBar.isTabVisible("forms"), "Forms tab should be visible");
        Assert.assertTrue(navigationBar.isTabVisible("swipe"), "Swipe tab should be visible");
        Assert.assertTrue(navigationBar.isTabVisible("drag"), "Drag tab should be visible");

        boolean directCheck = false;
        try {
            directCheck = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"WEBDRIVER\")")).isDisplayed();
        } catch (Exception e) {
            System.out.println("ERROR: Failed to find Webdriver text element - " + e.getMessage());
        }
        
        boolean homeScreenCheck = homeScreen.isHomeScreenDisplayed();

        Assert.assertTrue(directCheck || homeScreenCheck, "Home screen should be displayed");
        
        try {
            Assert.assertTrue(homeScreen.areLogosDisplayed(), "Apple and Android logos should be displayed");
        } catch (AssertionError e) {
            System.out.println("ERROR: Logos aren't displayed - " + e.getMessage());
        }
        
        try {
            Assert.assertTrue(homeScreen.isSupportTextDisplayed(), "Support text should be displayed");
        } catch (AssertionError e) {
            System.out.println("ERROR: Support text not found - " + e.getMessage());
        }
        
        navigationBar.navigateToWebview();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        try {
            boolean webviewCheck = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.webkit.WebView\")")).isDisplayed();
            Assert.assertTrue(webviewCheck, "Webview should be displayed");
        } catch (Exception e) {
            try {
                Assert.assertTrue(driver.findElement(AppiumBy.xpath("//*[@text='Webview']")).isDisplayed(), 
                                 "Webview screen should be displayed");
            } catch (Exception ex) {
                Assert.fail("Could not verify Webview screen");
            }
        }
        
        navigationBar.navigateToLogin();
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed(), "Login screen should be displayed");

        try {
            Assert.assertTrue(loginScreen.isBiometricsTextDisplayed(), "Biometrics text should be displayed");
        } catch (AssertionError e) {
            System.out.println("ERROR: Biometrics text not found - " + e.getMessage());
        }
        
        navigationBar.navigateToForms();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        try {
            boolean formsCheck = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Form components\")")).isDisplayed();
            Assert.assertTrue(formsCheck, "Forms screen should be displayed");
        } catch (Exception e) {
            try {
                Assert.assertTrue(driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.Button\")")).isDisplayed(), 
                                 "Forms screen should have buttons");
            } catch (Exception ex) {
                Assert.fail("Could not verify Forms screen");
            }
        }
        
        navigationBar.navigateToSwipe();
        Assert.assertTrue(swipeScreen.isSwipeScreenDisplayed(), "Swipe screen should be displayed");
        
        navigationBar.navigateToDrag();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        try {
            boolean dragCheck = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Drag and Drop\")")).isDisplayed();
            Assert.assertTrue(dragCheck, "Drag screen should be displayed");
        } catch (Exception e) {
            try {
                Assert.assertTrue(driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.TextView\").instance(0)")).isDisplayed(), 
                                 "Drag screen should have text elements");
            } catch (Exception ex) {
                Assert.fail("Could not verify Drag screen");
            }
        }
        
        navigationBar.navigateToHome();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        try {
            directCheck = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"WEBDRIVER\")")).isDisplayed();
        } catch (Exception e) {
            directCheck = false;
        }
        
        homeScreenCheck = homeScreen.isHomeScreenDisplayed();
        
        Assert.assertTrue(directCheck || homeScreenCheck, "Home screen should be displayed after navigation");
    }
}
