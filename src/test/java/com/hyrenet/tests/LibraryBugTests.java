package com.hyrenet.tests;

import com.hyrenet.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryBugTests extends BaseTest {

    @Test
    public void BUG_LIB_01_actionsColumnHiddenAfterHamburgerClick() {

        // Precondition: User already logged in (reuse login utility)

        // Navigate to Library page
        driver.findElement(By.xpath("//span[text()='Library']")).click();

        // Verify Actions column is visible initially
        WebElement actionsColumn =
                driver.findElement(By.xpath("//th[contains(text(),'Actions')]"));
        Assert.assertTrue(actionsColumn.isDisplayed(),
                "Actions column should be visible initially");

        // Click hamburger menu
        driver.findElement(By.xpath("//button[contains(@class,'hamburger')]")).click();

        // Actions column should NOT be visible in viewport
        Assert.assertFalse(actionsColumn.isDisplayed(),
                "BUG_LIB_01: Actions column becomes hidden after hamburger click");
    }
}

