package aooiumtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasicActions {
    public static void main(String[] args){
    AppiumDriver driver = DriverFactory.createDriver();
    
    MobileElement views=driver.findElementByAccessibilityID(using:"views");
    views.click();
    (new TouchAction<>(driver))
    .press(new PointOption().withCoordinates(507, 1675))
    .moveTo(new PointOption().withCoordinates(507, 634))
    .release()
    .perform();

(new TouchAction<>(driver))
    .press(new PointOption().withCoordinates(490, 1743))
    .moveTo(new PointOption().withCoordinates(489, 567))
    .release()
    .perform();

(new TouchAction<>(driver))
    .press(new PointOption().withCoordinates(501, 1712))
    .moveTo(new PointOption().withCoordinates(490, 520))
    .release()
    .perform();
    
    MobileElement textFields=driver.findElementByAccessibilityID(using: "TextFields");
    textFields.click();
    Thread.sleep(millis:3000);
    
    MobileElement editText=driver.findElementByID("io.appium.android.apis:id/edit");
    editText.sendKeys(..args.keysToSend:"hello World");
    Thread.sleep(millis:3000);
    
    editText.clear();
    
    
    


    }
}









