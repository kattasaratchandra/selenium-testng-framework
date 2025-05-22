package org.myframeworks.factories;

import org.myframeworks.constants.FrameworkConstants;
import org.myframeworks.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.myframeworks.driver.DriverManager.getDriver;

public class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
        // Private constructor to prevent instantiation
    }

    public static WebElement waitForElement(By by, WaitStrategy waitStrategy){
        switch (waitStrategy) {
            case CLICKABLE:
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                        .until(ExpectedConditions.elementToBeClickable(by));
            case PRESENCE:
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                        .until(ExpectedConditions.presenceOfElementLocated(by));
            case VISIBLE:
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
            case NONE:
                return getDriver().findElement(by);
            default:
                throw new IllegalArgumentException("Invalid wait strategy: " + waitStrategy);
        }
    }
}
