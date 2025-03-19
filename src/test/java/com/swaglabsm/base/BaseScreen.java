package com.swaglabsm.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Base screen class containing common functionality for all screen objects.
 * Provides methods for element interaction, waiting, and swipe gestures.
 */
public class BaseScreen {

    protected AndroidDriver driver;

    /**
     * Constructor for the BaseScreen.
     *
     * @param driver The AndroidDriver instance
     */
    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    /**
     * Checks if an element is visible on the screen.
     *
     * @param element The WebElement to check
     * @return true if the element is visible, false otherwise
     */
    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Taps on an element after waiting for it to be clickable.
     *
     * @param element The WebElement to tap
     */
    public void tap(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }
    
    /**
     * Types text into an element after waiting for it to be visible.
     *
     * @param element The WebElement to type into
     * @param text The text to type
     */
    public void typeText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Gets the text from an element after waiting for it to be visible.
     *
     * @param element The WebElement to get text from
     * @return The text of the element
     */
    public String getText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }
    
    /**
     * Waits for an element to be visible.
     *
     * @param element The WebElement to wait for
     */
    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * Waits for an element to be clickable.
     *
     * @param element The WebElement to wait for
     */
    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * Performs a horizontal swipe gesture.
     *
     * @param direction The direction to swipe ("left" or "right")
     */
    public void swipeHorizontal(String direction) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        
        Map<String, Object> params = new HashMap<>();
        params.put("left", width / 4);
        params.put("top", height / 2);
        params.put("width", width / 2);
        params.put("height", 10);
        params.put("direction", direction);
        params.put("percent", 0.75);
        
        driver.executeScript("mobile: swipeGesture", params);
    }
    
    /**
     * Performs a vertical swipe gesture.
     *
     * @param direction The direction to swipe ("up" or "down")
     */
    public void swipeVertical(String direction) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        
        Map<String, Object> params = new HashMap<>();
        params.put("left", width / 2);
        params.put("top", height / 4);
        params.put("width", 10);
        params.put("height", height / 2);
        params.put("direction", direction);
        params.put("percent", 0.75);
        
        driver.executeScript("mobile: swipeGesture", params);
    }

    /**
     * Performs a vertical swipe gesture at the top part of the screen.
     *
     * @param direction The direction to swipe ("up" or "down")
     */
    public void swipeTopOfScreen(String direction) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        
        Map<String, Object> params = new HashMap<>();
        params.put("left", width / 2);
        params.put("top", (int)(height * 0.2));
        params.put("width", width / 2);
        params.put("height", (int)(height * 0.3));
        params.put("direction", direction);
        params.put("percent", 0.95);
        
        driver.executeScript("mobile: swipeGesture", params);
    }
    
    /**
     * Performs a vertical swipe gesture in the card area.
     *
     * @param direction The direction to swipe ("up" or "down")
     */
    public void swipeCardVertical(String direction) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        
        Map<String, Object> params = new HashMap<>();
        params.put("left", width / 2);
        params.put("top", (int)(height * 0.6));
        params.put("width", width / 4);
        params.put("height", (int)(height * 0.3));
        params.put("direction", direction);
        params.put("percent", 0.9);
        
        driver.executeScript("mobile: swipeGesture", params);
    }
    
    /**
     * Performs a horizontal swipe gesture in the card area.
     *
     * @param direction The direction to swipe ("left" or "right")
     */
    public void swipeCardArea(String direction) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        
        Map<String, Object> params = new HashMap<>();
        params.put("left", width / 4);
        params.put("top", (int)(height * 0.6));
        params.put("width", width / 2);
        params.put("height", (int)(height * 0.2));
        params.put("direction", direction);
        params.put("percent", 0.9);
        
        driver.executeScript("mobile: swipeGesture", params);
    }
    
    /**
     * Finds an element using UI Automator.
     *
     * @param uiAutomator The UI Automator selector string
     * @return The found WebElement
     */
    public WebElement findElementByUiAutomator(String uiAutomator) {
        return driver.findElement(AppiumBy.androidUIAutomator(uiAutomator));
    }
}
