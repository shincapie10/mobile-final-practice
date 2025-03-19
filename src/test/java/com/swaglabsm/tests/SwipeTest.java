package com.swaglabsm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabsm.base.BaseTest;
import com.swaglabsm.screens.NavigationBar;
import com.swaglabsm.screens.SwipeScreen;

import io.appium.java_client.AppiumBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Test class for verifying swipe functionality in the app.
 * Tests horizontal card swiping and vertical swiping to find hidden elements.
 */
public class SwipeTest extends BaseTest {
    
    /**
     * Tests the swipe functionality by:
     * 1. Navigating to the Swipe section
     * 2. Verifying horizontal swipes through all cards (Fully Open Source to Compatible)
     * 3. Verifying vertical swipes to find a hidden element
     */
    @Test
    public void testSwipeCards() {
        NavigationBar navigationBar = new NavigationBar(driver);
        SwipeScreen swipeScreen = new SwipeScreen(driver);
        
        navigationBar.navigateToSwipe();
        
        boolean isSwipeScreenDisplayed = swipeScreen.isSwipeScreenDisplayed();
        Assert.assertTrue(isSwipeScreenDisplayed, "Swipe screen should be displayed");
        
        boolean isOpenSourceCardDisplayed = swipeScreen.isOpenSourceCardDisplayed();
        Assert.assertTrue(isOpenSourceCardDisplayed, "Open Source card should be displayed initially");
        
        swipeScreen.swipeHorizontalToTheRight();
        Assert.assertFalse(swipeScreen.isOpenSourceCardDisplayed(), "Open Source card should be hidden after swipe");
        Assert.assertTrue(swipeScreen.isCommunityCardDisplayed(), "Community card should be displayed after first swipe");
        
        swipeScreen.swipeHorizontalToTheRight();
        Assert.assertFalse(swipeScreen.isCommunityCardDisplayed(), "Community card should be hidden after swipe");
        Assert.assertTrue(swipeScreen.isJsFoundationCardDisplayed(), "JS Foundation card should be displayed after second swipe");
        
        swipeScreen.swipeHorizontalToTheRight();
        Assert.assertFalse(swipeScreen.isJsFoundationCardDisplayed(), "JS Foundation card should be hidden after swipe");
        Assert.assertTrue(swipeScreen.isSupportVideosCardDisplayed(), "Support Videos card should be displayed after third swipe");
        
        swipeScreen.swipeHorizontalToTheRight();
        Assert.assertFalse(swipeScreen.isSupportVideosCardDisplayed(), "Support Videos card should be hidden after swipe");
        Assert.assertTrue(swipeScreen.isExtendableCardDisplayed(), "Extendable card should be displayed after fourth swipe");
        
        swipeScreen.swipeHorizontalToTheRight();
        Assert.assertFalse(swipeScreen.isExtendableCardDisplayed(), "Extendable card should be hidden after swipe");
        
        boolean isCompatibleCardDisplayed = swipeScreen.isCompatibleCardDisplayed();
        Assert.assertTrue(isCompatibleCardDisplayed, "Compatible card should be displayed as the last card");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        swipeScreen.swipeToFindHiddenElement();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
        boolean foundMeTextDisplayed = swipeScreen.isFoundMeTextDisplayed();
        boolean robotImageDisplayed = swipeScreen.isRobotImageDisplayed();
        boolean foundHiddenElement = foundMeTextDisplayed || robotImageDisplayed;
        
        try {
            boolean directTextCheck = driver.findElement(io.appium.java_client.AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"You found me\")")).isDisplayed();
            foundHiddenElement = foundHiddenElement || directTextCheck;
        } catch (Exception e) {
            System.out.println("ERROR: Failed to find 'You found me' text element - " + e.getMessage());
        }
        
        try {
            boolean directRobotCheck = driver.findElement(io.appium.java_client.AppiumBy.androidUIAutomator(
                "new UiSelector().descriptionContains(\"robot\")")).isDisplayed();
            foundHiddenElement = foundHiddenElement || directRobotCheck;
        } catch (Exception e) {
            System.out.println("ERROR: Failed to find robot image element - " + e.getMessage());
        }
        
        Assert.assertTrue(foundHiddenElement, "Should find the hidden element 'You found me!!!' or robot image");
    }
}
