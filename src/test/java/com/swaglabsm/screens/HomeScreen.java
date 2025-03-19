package com.swaglabsm.screens;

import org.openqa.selenium.WebElement;

import com.swaglabsm.base.BaseScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement robotImage;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"WEBDRIVER\")")
    private WebElement webdriverTitle;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"/O\")")
    private WebElement ioTitle;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Demo app\")")
    private WebElement demoAppText;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Image\").instance(0)")
    private WebElement appleLogo;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Image\").instance(1)")
    private WebElement androidLogo;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Support\")")
    private WebElement supportText;
    
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
    
    public boolean isHomeScreenDisplayed() {
        return isAnyHomeElementVisible();
    }
    
    private boolean isAnyHomeElementVisible() {
        try {
            if (isElementVisible(robotImage)) return true;
        } catch (Exception e) {}
        
        try {
            if (isElementVisible(webdriverTitle)) return true;
        } catch (Exception e) {}
        
        try {
            if (isElementVisible(ioTitle)) return true;
        } catch (Exception e) {}
        
        try {
            if (isElementVisible(demoAppText)) return true;
        } catch (Exception e) {}
        
        try {
            return driver.findElement(
                io.appium.java_client.AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"WEBDRIVER\")"
                )
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean areLogosDisplayed() {
        try {
            return isElementVisible(appleLogo) || isElementVisible(androidLogo);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isSupportTextDisplayed() {
        try {
            return isElementVisible(supportText);
        } catch (Exception e) {
            return false;
        }
    }
}
