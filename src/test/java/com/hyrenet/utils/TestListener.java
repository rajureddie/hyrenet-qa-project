package com.hyrenet.utils;

import com.hyrenet.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTest.getDriver();
        ScreenshotUtil.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );
    }
}
