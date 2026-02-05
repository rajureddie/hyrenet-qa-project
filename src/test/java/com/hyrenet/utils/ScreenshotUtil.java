package com.hyrenet.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            System.out.println("Driver is null. Screenshot not captured.");
            return;
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now().toString().replace(":", "-");
        String path = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            Files.createDirectories(Path.of("screenshots"));
            Files.copy(source.toPath(), Path.of(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
