package com.swaglabsm.screens;

import org.openqa.selenium.WebElement;

import com.swaglabsm.base.BaseScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Screen object representing the Login and Sign Up screen of the app.
 * Provides methods to interact with login and registration functionality.
 */
public class LoginScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    private WebElement loginFormTitle;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    private WebElement loginTab;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    private WebElement signUpTab;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement emailInput;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement passwordInput;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement confirmPasswordInput;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LOGIN\")")
    private WebElement loginButton;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SIGN UP\")")
    private WebElement signUpButton;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"biometrics\")")
    private WebElement biometricsText;
    
    // Login success popup elements
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Success\")")
    private WebElement loginSuccessTitle;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You are logged in!\")")
    private WebElement loginSuccessMessage;
    
    // Signup success popup elements
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Signed Up!\")")
    private WebElement signUpSuccessTitle;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You successfully signed up!\")")
    private WebElement signUpSuccessMessage;
    
    // OK button for both popups
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    private WebElement okButton;

    /**
     * Constructor for the LoginScreen.
     *
     * @param driver The AndroidDriver instance
     */
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    /**
     * Checks if the Login Screen is displayed.
     *
     * @return true if the screen is displayed, false otherwise
     */
    public boolean isLoginScreenDisplayed() {
        return isElementVisible(loginFormTitle) && 
               isElementVisible(loginTab) && 
               isElementVisible(signUpTab);
    }
    
    /**
     * Navigates to the Login tab.
     */
    public void goToLoginTab() {
        tap(loginTab);
    }
    
    /**
     * Navigates to the Sign Up tab.
     */
    public void goToSignUpTab() {
        tap(signUpTab);
    }
    
    /**
     * Enters an email in the email input field.
     *
     * @param email The email to enter
     */
    public void enterEmail(String email) {
        typeText(emailInput, email);
    }
    
    /**
     * Enters a password in the password input field.
     *
     * @param password The password to enter
     */
    public void enterPassword(String password) {
        typeText(passwordInput, password);
    }
    
    /**
     * Enters a password in the confirm password input field.
     *
     * @param password The password to confirm
     */
    public void enterConfirmPassword(String password) {
        typeText(confirmPasswordInput, password);
    }
    
    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        tap(loginButton);
    }
    
    /**
     * Clicks the sign up button.
     */
    public void clickSignUpButton() {
        tap(signUpButton);
    }
    
    /**
     * Checks if the biometrics text is displayed.
     *
     * @return true if the text is displayed, false otherwise
     */
    public boolean isBiometricsTextDisplayed() {
        return isElementVisible(biometricsText);
    }
    
    /**
     * Checks if the login success popup is displayed.
     *
     * @return true if the popup is displayed, false otherwise
     */
    public boolean isLoginSuccessPopupDisplayed() {
        return isElementVisible(loginSuccessTitle) && isElementVisible(loginSuccessMessage);
    }
    
    /**
     * Checks if the sign up success popup is displayed.
     *
     * @return true if the popup is displayed, false otherwise
     */
    public boolean isSignUpSuccessPopupDisplayed() {
        return isElementVisible(signUpSuccessTitle) && isElementVisible(signUpSuccessMessage);
    }
    
    /**
     * Closes the currently displayed popup.
     */
    public void closePopup() {
        tap(okButton);
    }
    
    /**
     * Performs the login process with the provided credentials.
     *
     * @param email The email to use for login
     * @param password The password to use for login
     */
    public void login(String email, String password) {
        goToLoginTab();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    
    /**
     * Performs the sign up process with the provided credentials.
     *
     * @param email The email to use for sign up
     * @param password The password to use for sign up
     */
    public void signUp(String email, String password) {
        goToSignUpTab();
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        clickSignUpButton();
    }
}

