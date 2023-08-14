import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import po.ModalWindow;
import po.PracticeFormPage;

import static helpers.Driver.driver;

public class FormSubmittingTest extends BaseTest{

    @Test
    public void formSubmittingTest() {
        //Arrange
        String firstName = "Aleksei";
        String lastName = "Kazantsev";
        String studentName = firstName + " " + lastName;
        String email = "djacidk@gmail.com";
        String gender = "Male";
        String mobile = "9144154627";
        String dateOfBirth = "20 October,1984";
        String subjects = "com";
        String pictureName = "selenium.png";
        String currentAddress = "Planet Earth";
        String state = "Uttar Pradesh";
        String city = "Lucknow";
        String stateAndCityExpected = state + " " + city;
        String modalWindowsExpectedTitle = "Thanks for submitting the form";

        driver().get("https://demoqa.com/automation-practice-form");

        //Act
        PracticeFormPage.fillFirstName(firstName);
        PracticeFormPage.fillLastName(lastName);
        PracticeFormPage.fillEmail(email);
        PracticeFormPage.setGender(gender);
        PracticeFormPage.fillMobile(mobile);
        PracticeFormPage.fillDateOfBirth(dateOfBirth);
        PracticeFormPage.fillSubjects(subjects);
        PracticeFormPage.uploadPicture(pictureName);
        PracticeFormPage.fillAddressField(currentAddress);
        PracticeFormPage.selectState(state);
        PracticeFormPage.selectCity(city);
        PracticeFormPage.clickSubmitButton();

        //Assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(ModalWindow.title(), modalWindowsExpectedTitle);
        softAssert.assertEquals(ModalWindow.studentNameValue(), studentName);
        softAssert.assertEquals(ModalWindow.studentEmailValue(), email);
        softAssert.assertEquals(ModalWindow.genderValue(), gender);
        softAssert.assertEquals(ModalWindow.mobileValue(), mobile);
        softAssert.assertEquals(ModalWindow.dateOfBirthValue(), dateOfBirth);
        softAssert.assertEquals(ModalWindow.subjectsValue(), PracticeFormPage.subjectsFieldValue());
        softAssert.assertEquals(ModalWindow.pictureValue(), pictureName);
        softAssert.assertEquals(ModalWindow.addressValue(), currentAddress);
        softAssert.assertEquals(ModalWindow.stateAndCityValue(), stateAndCityExpected);
        softAssert.assertAll();
    }
}
