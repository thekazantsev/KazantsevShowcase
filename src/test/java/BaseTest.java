import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static helpers.Driver.driver;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        driver();
    }

    @AfterMethod
    public void tearDown() {
        driver().quit();
    }
}
