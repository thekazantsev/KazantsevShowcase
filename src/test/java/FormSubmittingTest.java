import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import po.ModalWindow;
import po.PracticeFormPage;

import helpers.FormData;

import static helpers.Driver.driver;

public class FormSubmittingTest extends TestBase {

    @Test
    public void automationPracticeFormTest() {
        //Arrange
        FormData generatedData = FormData.generate();
        driver().get(PracticeFormPage.URL);

        //Act
        PracticeFormPage.fillFormWith(generatedData);
        PracticeFormPage.clickSubmitButton();

        //Assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(ModalWindow.title(), ModalWindow.expectedTitle(), "Title doesn't match expected");
        softAssert.assertEquals(ModalWindow.studentNameValue(), generatedData.studentName, "Name doesn't match expected");
        softAssert.assertEquals(ModalWindow.studentEmailValue(), generatedData.email, "Email doesn't match expected");
        softAssert.assertEquals(ModalWindow.genderValue(), generatedData.gender, "Gender doesn't match expected");
        softAssert.assertEquals(ModalWindow.mobileValue(), generatedData.mobile, "Mobile doesn't match expected");
        softAssert.assertEquals(ModalWindow.dateOfBirthValue(), generatedData.dateOfBirth, "Date of birth doesn't match expected");
        softAssert.assertEquals(ModalWindow.subjectsValue(), PracticeFormPage.subjectsFieldValue(), "Subjects doesn't match expected");
        softAssert.assertEquals(ModalWindow.pictureValue(), generatedData.pictureName, "Picture name doesn't match expected");
        softAssert.assertEquals(ModalWindow.addressValue(), generatedData.currentAddress, "Address doesn't match expected");
        softAssert.assertEquals(ModalWindow.stateAndCityValue(), generatedData.stateAndCityExpected, "State and City doesn't match expected");
        softAssert.assertAll();
    }
}
