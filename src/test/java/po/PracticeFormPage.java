package po;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Path;

import static helpers.Driver.driver;

public class PracticeFormPage {
    private static final By firstNameField   = By.id("firstName");
    private static final By lastNameField    = By.xpath("//input[@id='lastName']");
    private static final By emailField       = By.cssSelector("input[id='userEmail']");
    private static final By mobileField      = By.id("userNumber");
    private static final By dateOfBirthField = By.cssSelector(".react-datepicker-wrapper");
    private static final By monthSelector    = By.cssSelector(".react-datepicker__month-select");
    private static final By yearSelector     = By.cssSelector(".react-datepicker__year-select");
    private static final By subjectsField    = By.cssSelector(".subjects-auto-complete__value-container");
    private static final By addressField     = By.id("currentAddress");
    private static final By stateList        = By.xpath("//div[text()='Select State']");
    private static final By cityList         = By.xpath("//div[text()='Select City']");
    private static final By submitButton     = By.id("submit");
    private static String subjectsFieldValue;

    public static void fillFirstName(String firstName) {
        driver()
            .findElement(firstNameField)
            .sendKeys(firstName);
    }

    public static void fillLastName(String lastName) {
        driver()
            .findElement(lastNameField)
            .sendKeys(lastName);
    }

    public static void fillEmail(String email) {
        driver()
            .findElement(emailField)
            .sendKeys(email);
    }

    public static void setGender(String gender) {
        driver()
            .findElement(By.xpath(String.format("//div[@id='genterWrapper']//label[.='%s']", gender)))
            .click();
    }

    public static void fillMobile(String number) {
        driver()
            .findElement(mobileField)
            .sendKeys(number);
    }

    public static void fillDateOfBirth(String date) {
        String[] dateSplit = date.replace(",", " ").split(" ");
        String day   = dateSplit[0];
        String month = dateSplit[1];
        String year  = dateSplit[2];

        driver()
            .findElement(dateOfBirthField)
            .click();

        Select monthSelector = new Select(driver().findElement(PracticeFormPage.monthSelector));
        monthSelector.selectByVisibleText(month);

        Select yearSelector = new Select(driver().findElement(PracticeFormPage.yearSelector));
        yearSelector.selectByVisibleText(year);

        driver()
            .findElement(dateOfBirthField)
            .findElement(By.xpath(String.format("//div[text()='%s']", day)))
            .click();
    }

    public static void fillSubjects(String subjects) {
        WebElement subjectsFieldElement = driver().findElement(subjectsField);
        subjectsFieldElement.click();

        new Actions(driver())
            .sendKeys(subjects)
            .perform();

        new Actions(driver())
            .sendKeys(Keys.ENTER)
            .perform();

        subjectsFieldValue = subjectsFieldElement.getText();
    }

    public static String subjectsFieldValue() {
        return subjectsFieldValue;
    }

    public static void uploadPicture(String pictureName) {
        Path relativePath = Path.of("src", "test", "resources", pictureName);
        String absolutePathString = relativePath.toAbsolutePath().toString();

        driver()
            .findElement(By.id("uploadPicture"))
            .sendKeys(absolutePathString);
    }

    public static void fillAddressField(String address) {
        driver()
            .findElement(addressField)
            .sendKeys(address);
    }

    public static void selectState(String state) {
        driver()
            .findElement(stateList)
            .click();

        driver()
            .findElement(By.xpath(String.format("//div[text()='%s']", state)))
            .click();
    }

    public static void selectCity(String city) {
        driver()
            .findElement(cityList)
            .click();

        driver()
            .findElement(By.xpath(String.format("//div[text()='%s']", city)))
            .click();
    }

    public static void clickSubmitButton() {
        driver()
            .findElement(submitButton)
            .click();
    }
}
