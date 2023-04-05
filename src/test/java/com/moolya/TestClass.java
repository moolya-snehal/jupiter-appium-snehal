package com.moolya;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class TestClass {
    //TesNG - it is a testing framework used in automation testing
    //@BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod, @Test, @AfterMethod,
    //@AfterClass, @AfterTest, @AfterSuite
    protected AppiumDriver driver;
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5556");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/apple/Desktop/Android-MyDemoAppRN.1.3.0.build-244.apk");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void successfulLogin(){
        MobileElement openMenu = driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView");
        openMenu.click();
        MobileElement loginMenu = driver.findElementByAccessibilityId("menu item log in");
        loginMenu.click();
        MobileElement loginSuccess = driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"bob@example.com-autofill\"]/android.widget.TextView");
        loginSuccess.click();
        MobileElement loginButton = driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Login button\"]/android.widget.TextView");
        loginButton.click();

        MobileElement productsTitle = driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView");
        Assert.assertFalse(productsTitle.isDisplayed());
        Assert.assertTrue(productsTitle.isDisplayed());
    }

    @Test
@@ -74,7 +74,7 @@ public void lockedOutUser() {
        MobileElement error = driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView");
        String actualErrorText = error.getText();

        String expectedErrorText = "Wrong user name";
        String expectedErrorText = "Sorry, this user has been locked out.";

        Assert.assertEquals(actualErrorText, expectedErrorText);

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}