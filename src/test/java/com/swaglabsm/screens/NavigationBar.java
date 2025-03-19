package com.swaglabsm.screens;

import org.openqa.selenium.WebElement;

import com.swaglabsm.base.BaseScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NavigationBar extends BaseScreen {
    
    @AndroidFindBy(accessibility = "Home")
    private WebElement homeButton;
    
    @AndroidFindBy(accessibility = "Webview")
    private WebElement webviewButton;
    
    @AndroidFindBy(accessibility = "Login")
    private WebElement loginButton;
    
    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsButton;
    
    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeButton;
    
    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragButton;
    
    public NavigationBar(AndroidDriver driver) {
        super(driver);
    }
    
    public void navigateToHome() {
        tap(homeButton);
    }
    
    public void navigateToWebview() {
        tap(webviewButton);
    }
    
    public void navigateToLogin() {
        tap(loginButton);
    }
    
    public void navigateToForms() {
        tap(formsButton);
    }
    
    public void navigateToSwipe() {
        tap(swipeButton);
    }
    
    public void navigateToDrag() {
        tap(dragButton);
    }
    
    public boolean isTabVisible(String tab) {
        switch (tab.toLowerCase()) {
            case "home":
                return isElementVisible(homeButton);
            case "webview":
                return isElementVisible(webviewButton);
            case "login":
                return isElementVisible(loginButton);
            case "forms":
                return isElementVisible(formsButton);
            case "swipe":
                return isElementVisible(swipeButton);
            case "drag":
                return isElementVisible(dragButton);
            default:
                return false;
        }
    }
}