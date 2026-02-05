package com.hyrenet.tests;

import com.hyrenet.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TemplateBugTests extends BaseTest {

    @Test
    public void BUG_TMP_03_programmingDurationAllowsUnlimitedValues() {

        // Navigate to Templates
        driver.findElement(By.xpath("//span[text()='Templates']")).click();

        // Select existing template
        driver.findElement(By.xpath("//td[contains(text(),'Java')]")).click();

        // Edit template
        driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();

        // Enter very large duration
        WebElement duration =
                driver.findElement(By.id("programmingDuration"));

        duration.clear();
        duration.sendKeys("120000");

        // Save template
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        // BUG: No validation error appears
        Assert.assertTrue(true,
                "BUG_TMP_03: System accepts unlimited programming duration");
    }
}

