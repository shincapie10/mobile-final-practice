package com.swaglabsm.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = createAndroidDriver();
    }

    private AndroidDriver createAndroidDriver() throws  MalformedURLException{
        URL url = new URL("http://127.0.0.1:4723");

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("/Users/simon.hincapie/Downloads/android.wdio.native.app.v1.0.8.apk")
                .setDeviceName("emulator-5554")
                .setPlatformName("Android")
                .setPlatformVersion("15")
                .setAutomationName("UiAutomator2");

        return new AndroidDriver(url, options);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
