package com.swaglabsm.screens;

import org.openqa.selenium.WebElement;

import com.swaglabsm.base.BaseScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Screen object representing the Swipe section of the app.
 * Provides methods to interact with the horizontal and vertical swipe functionality.
 */
public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    private WebElement swipeHorizontalTitle;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Or swipe vertical to find what I'm hiding.\")")
    private WebElement swipeVerticalText;
    
    // Card 1
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"FULLY OPEN SOURCE\")")
    private WebElement openSourceCard;
    
    // Card 2
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"GREAT COMMUNITY\")")
    private WebElement communityCard;
    
    // Card 3
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"JS.FOUNDATION\")")
    private WebElement jsFoundationCard;
    
    // Card 4
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SUPPORT VIDEOS\")")
    private WebElement supportVideosCard;
    
    // Card 5
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"EXTENDABLE\")")
    private WebElement extendableCard;
    
    // Card 6 (Last card)
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"COMPATIBLE\")")
    private WebElement compatibleCard;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You found me!!!\")")
    private WebElement foundMeText;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"robot\")")
    private WebElement robotImage;
    
    /**
     * Constructor for the SwipeScreen.
     *
     * @param driver The AndroidDriver instance
     */
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
    
    /**
     * Checks if the Swipe Screen is displayed.
     *
     * @return true if the screen is displayed, false otherwise
     */
    public boolean isSwipeScreenDisplayed() {
        return isElementVisible(swipeHorizontalTitle) && isElementVisible(swipeVerticalText);
    }
    
    /**
     * Checks if the Open Source card is displayed.
     *
     * @return true if the card is displayed, false otherwise
     */
    public boolean isOpenSourceCardDisplayed() {
        try {
            return isElementVisible(openSourceCard);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"OPEN SOURCE\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Checks if the Community card is displayed.
     *
     * @return true if the card is displayed, false otherwise
     */
    public boolean isCommunityCardDisplayed() {
        try {
            return isElementVisible(communityCard);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"COMMUNITY\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Checks if the JS Foundation card is displayed.
     *
     * @return true if the card is displayed, false otherwise
     */
    public boolean isJsFoundationCardDisplayed() {
        try {
            return isElementVisible(jsFoundationCard);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"JS.FOUNDATION\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Checks if the Support Videos card is displayed.
     *
     * @return true if the card is displayed, false otherwise
     */
    public boolean isSupportVideosCardDisplayed() {
        try {
            return isElementVisible(supportVideosCard);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"SUPPORT VIDEOS\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Checks if the Extendable card is displayed.
     *
     * @return true if the card is displayed, false otherwise
     */
    public boolean isExtendableCardDisplayed() {
        try {
            return isElementVisible(extendableCard);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"EXTENDABLE\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Checks if the Compatible card is displayed.
     *
     * @return true if the card is displayed, false otherwise
     */
    public boolean isCompatibleCardDisplayed() {
        try {
            return isElementVisible(compatibleCard);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"COMPATIBLE\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Swipes horizontally to reveal the card to the right.
     */
    public void swipeHorizontalToTheRight() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        
        swipeCardArea("left");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
    /**
     * Swipes horizontally to reveal the card to the left.
     */
    public void swipeHorizontalToTheLeft() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        
        swipeCardArea("right");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    
    /**
     * Swipes to the last card (Compatible) by following the exact order of cards.
     *
     * @return true if successfully reached the last card, false otherwise
     */
    public boolean swipeToLastCard() {
        int maxAttempts = 3;
        
        for (int i = 0; i < maxAttempts && !isCommunityCardDisplayed(); i++) {
            swipeHorizontalToTheRight();
        }
        if (!isCommunityCardDisplayed()) {
            return false;
        }
        
        for (int i = 0; i < maxAttempts && !isJsFoundationCardDisplayed(); i++) {
            swipeHorizontalToTheRight();
        }
        if (!isJsFoundationCardDisplayed()) {
            return false;
        }
        
        for (int i = 0; i < maxAttempts && !isSupportVideosCardDisplayed(); i++) {
            swipeHorizontalToTheRight();
        }
        if (!isSupportVideosCardDisplayed()) {
            return false;
        }
        
        for (int i = 0; i < maxAttempts && !isExtendableCardDisplayed(); i++) {
            swipeHorizontalToTheRight();
        }
        if (!isExtendableCardDisplayed()) {
            return false;
        }
        
        for (int i = 0; i < maxAttempts && !isCompatibleCardDisplayed(); i++) {
            swipeHorizontalToTheRight();
        }
        return isCompatibleCardDisplayed();
    }
    
    /**
     * Swipes down on the screen.
     */
    public void swipeDown() {
        swipeVertical("down");
    }
    
    /**
     * Swipes up on the screen.
     */
    public void swipeUp() {
        swipeTopOfScreen("up");
    }
    
    /**
     * Checks if the "You found me!!!" text is displayed.
     *
     * @return true if the text is displayed, false otherwise
     */
    public boolean isFoundMeTextDisplayed() {
        try {
            return isElementVisible(foundMeText);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"You found me\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Checks if the robot image is displayed.
     *
     * @return true if the image is displayed, false otherwise
     */
    public boolean isRobotImageDisplayed() {
        try {
            return isElementVisible(robotImage);
        } catch (Exception e) {
            try {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"robot\")")).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    /**
     * Swipes vertically to find the hidden element.
     */
    public void swipeToFindHiddenElement() {
        int maxSwipes = 20;
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        for (int i = 0; i < maxSwipes; i++) {
            if (isFoundMeTextDisplayed()) {
                return;
            }
            
            if (isRobotImageDisplayed()) {
                return;
            }
            
            if (i % 2 == 0) {
                swipeTopOfScreen("up");
            } else {
                swipeTopOfScreen("down");
            }
            
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            
            try {
                boolean foundText = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"You found me\")")).isDisplayed();
                if (foundText) {
                    return;
                }
            } catch (Exception e) {
            }
            
            try {
                boolean foundRobot = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"robot\")")).isDisplayed();
                if (foundRobot) {
                    return;
                }
            } catch (Exception e) {
            }
        }
        
        System.out.println("ERROR: Did not find hidden element after " + maxSwipes + " swipes");
    }
} 