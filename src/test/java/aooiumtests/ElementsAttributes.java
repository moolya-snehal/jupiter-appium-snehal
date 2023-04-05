package aooiumtests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import org.openqa.selenium.by;

public class ElementsAttributes {

	public static void main(String[] args) throws MalformedURLException{
		AppiumDriver AppiumDriverdriver = DriverFactory.createDriver();
		By accessibility=MobileBy.AccessibilityID("Accessibility");
		System.out.println(driver.findElement(accessibility).getText());
		System.out.println(driver.findElement(accessibility).getAttribute(name:"text"));
		System.out.println(driver.findElement(accessibility).getAttribute(name:"clickable"));
		System.out.println(driver.findElement(accessibility).getAttribute(name:"selected"));
		
		driver.findElement(accessibility).isDisplayed();
		driver.findElement(accessibility).isSelected();
		driver.findElement(accessibility).isEnabled();
		
		
		
		
	}
	
}
