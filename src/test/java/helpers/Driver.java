package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Driver {
     private static WebDriver webDriver;

     private Driver() {
     }

     public static WebDriver driver() {
         if (webDriver == null) {
             ChromeOptions options = new ChromeOptions();
             options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
             webDriver = new ChromeDriver(options);
         }
         return webDriver;
     }
}
