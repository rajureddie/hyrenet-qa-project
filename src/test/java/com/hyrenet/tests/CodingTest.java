package com.hyrenet.tests;

import com.hyrenet.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CodingTest extends BaseTest {

    @Test
    public void verifySampleInputIssueInCodingTest() {

        // 1. Login
        driver.get("https://app.hyrenet.in/");
        driver.findElement(By.id("email")).sendKeys("hyrenet+bugathon@guvi.in");
        driver.findElement(By.id("password")).sendKeys("hyrenettest@123");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        // 2. Navigate to Tests page
        driver.findElement(By.xpath("//span[text()='Tests']")).click();

        // 3. Select Java Quiz template
        driver.findElement(By.xpath("//td[contains(text(),'Java Quiz')]")).click();

        // 4. Click Manage Test
        driver.findElement(By.xpath("//button[contains(text(),'Manage Test')]")).click();

        // 5. Update and Submit
        driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

        // 6. Take Sample Test
        driver.findElement(By.xpath("//button[contains(text(),'Take Sample Test')]")).click();

        // Switch to new window (sample test launches in new tab)
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }

        // 7. Verify sample input is auto-filled
        WebElement sampleInput =
                driver.findElement(By.xpath("//textarea[contains(@placeholder,'Enter your input')]"));

        String inputValue = sampleInput.getText();
        Assert.assertFalse(inputValue.isEmpty(),
                "Sample input should be auto-populated");

        // 8. Run Code
        driver.findElement(By.xpath("//button[contains(text(),'Run Code')]")).click();

        // 9. Verify error message due to incorrect sample input
        WebElement error =
                driver.findElement(By.xpath("//*[contains(text(),'InputMismatchException')]"));

        Assert.assertTrue(error.isDisplayed(),
                "InputMismatchException should be displayed");
    }
}
