import helpers.ScreenshotListener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static helpers.Driver.driver;
import static helpers.Driver.closeDriver;

@Listeners(ScreenshotListener.class)
public class TestBase {
    final String BASE_URL = "https://demoqa.com";

    @BeforeMethod
    public void setUp() {
        driver();
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}
