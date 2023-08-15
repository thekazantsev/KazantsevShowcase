package helpers;

import io.qameta.allure.Allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static helpers.Driver.driver;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult testResult) {
        File screenshot = ((TakesScreenshot)driver()).getScreenshotAs(OutputType.FILE);

        try {
            Allure.addAttachment(testResult.getTestName() + " screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
