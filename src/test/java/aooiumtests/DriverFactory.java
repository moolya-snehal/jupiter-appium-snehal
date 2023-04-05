package aooiumtests;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	public static AppiumDriver createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		return null;
	}

}
