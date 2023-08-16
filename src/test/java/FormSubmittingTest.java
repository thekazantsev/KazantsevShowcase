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
        driver().get(BASE_URL.concat("/automation-practice-form"));

        //Act
        PracticeFormPage.fillFormWith(generatedData);
        PracticeFormPage.clickSubmitButton();

        //Assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(ModalWindow.title(), ModalWindow.expectedTitle());
        softAssert.assertEquals(ModalWindow.studentNameValue(), generatedData.studentName);
        softAssert.assertEquals(ModalWindow.studentEmailValue(), generatedData.email);
        softAssert.assertEquals(ModalWindow.genderValue(), generatedData.gender);
        softAssert.assertEquals(ModalWindow.mobileValue(), generatedData.mobile);
        softAssert.assertEquals(ModalWindow.dateOfBirthValue(), generatedData.dateOfBirth);
        softAssert.assertEquals(ModalWindow.subjectsValue(), PracticeFormPage.subjectsFieldValue());
        softAssert.assertEquals(ModalWindow.pictureValue(), generatedData.pictureName);
        softAssert.assertEquals(ModalWindow.addressValue(), generatedData.currentAddress);
        softAssert.assertEquals(ModalWindow.stateAndCityValue(), generatedData.stateAndCityExpected);
        softAssert.assertAll();
    }
}
