package com.hyrenet.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    private By email = By.xpath("//input[@type='email']");
    private By password = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button");

    public void login(String userEmail, String userPassword) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys(userEmail);

        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .sendKeys(userPassword);

        // WAIT for React to enable button
        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(loginButton)
        );

        // JS click (bypasses React issues)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);
    }
}
