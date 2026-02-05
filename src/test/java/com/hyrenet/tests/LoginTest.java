package com.hyrenet.tests;

import com.hyrenet.base.BaseTest;
import com.hyrenet.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("hyrenet+bugathon@guvi.in", "hyrenettest@123");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(
                currentUrl.contains("login"),
                "Login failed: still on login page"
        );
    }
    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong@email.com", "wrongpassword");


    }
    @Test
    public void verifySampleInputPanelSync() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Scroll to question area
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        // Capture sample input from question
        WebElement sampleLabel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Sample input')]")
                )
        );

        String questionSampleInput = sampleLabel
                .findElement(By.xpath("following-sibling::*"))
                .getText();

        // Capture sample input panel value
        WebElement panelInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//textarea")
                )
        );

        String panelValue = panelInput.getAttribute("value");

        Assert.assertEquals(
                panelValue.trim(),
                questionSampleInput.trim(),
                "Sample input panel not synced with question"
        );
    }







}
