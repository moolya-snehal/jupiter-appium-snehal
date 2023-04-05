package com.moolya;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    protected static AppiumDriver<MobileElement> driver;
    protected static Properties properties;
    InputStream inputStream;

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Parameters({"platformVersion", "platformName", "udid"})
    @BeforeMethod
    public void setUp(String platformVersion, String platformName, String udid) throws IOException {
        properties = new Properties();

        inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        properties.load(inputStream);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("androidAutomationName"));

        URL appUrl = getClass().getClassLoader().getResource(properties.getProperty("androidAppPath"));
        desiredCapabilities.setCapability(MobileCapabilityType.APP, appUrl);

        URL url = new URL(properties.getProperty("appiumServerUrl"));

        driver = new AndroidDriver<>(url, desiredCapabilities);

    }

    //Explicit wait reusable method
    public void waitForVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //click reusable method
    public void click(MobileElement element) {
        waitForVisibility(element);
        element.click();
    }

    //sendkeys reusable method
    public void sendKeys(MobileElement element, String txt) {
        waitForVisibility(element);
        element.sendKeys(txt);
    }

    //getAttribute reusable method
    public String getAttribute(MobileElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}