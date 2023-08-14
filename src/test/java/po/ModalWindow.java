package po;

import org.openqa.selenium.By;

import static helpers.Driver.driver;

public class ModalWindow {
    private static final By modalWindowTitle  = By.cssSelector(".modal-title");
    private static final By studentNameValue  = By.xpath("//td[.='Student Name']/following-sibling::td");
    private static final By studentEmailValue = By.xpath("//td[.='Student Email']/following-sibling::td");
    private static final By genderValue       = By.xpath("//td[.='Gender']/following-sibling::td");
    private static final By mobileValue       = By.xpath("//td[.='Mobile']/following-sibling::td");
    private static final By dateOfBirthValue  = By.xpath("//td[.='Date of Birth']/following-sibling::td");
    private static final By subjectsValue     = By.xpath("//td[.='Subjects']/following-sibling::td");
    private static final By pictureValue      = By.xpath("//td[.='Picture']/following-sibling::td");
    private static final By addressValue      = By.xpath("//td[.='Address']/following-sibling::td");
    private static final By stateAndCityValue = By.xpath("//td[.='State and City']/following-sibling::td");

    public static String title() {
        return driver()
                .findElement(modalWindowTitle)
                .getText();
    }

    public static String studentNameValue() {
        return driver()
                .findElement(studentNameValue)
                .getText();
    }

    public static String studentEmailValue() {
        return driver()
            .findElement(studentEmailValue)
            .getText();
    }

    public static String genderValue() {
        return driver()
            .findElement(genderValue)
            .getText();
    }

    public static String mobileValue() {
        return driver()
            .findElement(mobileValue)
            .getText();
    }

    public static String dateOfBirthValue() {
        return driver()
            .findElement(dateOfBirthValue)
            .getText();
    }

    public static String subjectsValue() {
        return driver()
            .findElement(subjectsValue)
            .getText();
    }

    public static String pictureValue() {
        return driver()
            .findElement(pictureValue)
            .getText();
    }

    public static String addressValue() {
        return driver()
            .findElement(addressValue)
            .getText();
    }

    public static String stateAndCityValue() {
        return driver()
            .findElement(stateAndCityValue)
            .getText();
    }
}
