package org.myframeworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.myframeworks.driver.DriverManager.getDriver;

public class BasePage {

    private final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public void waitForElementToBeClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBePresent(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void clickElement(By by){
        try {
            waitForElementToBeClickable(by);
            WebElement element = getDriver().findElement(by);
            element.click();
        } catch (Exception e) {
            System.err.println("Failed to click element: " + by + " - " + e.getMessage());
            throw e;
        }
    }

    public void enterText(By by, String text){
        try {
            waitForElementToBePresent(by);
            WebElement element = getDriver().findElement(by);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.err.println("Failed to enter text in element: " + by + " - " + e.getMessage());
            throw e;
        }
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }
}