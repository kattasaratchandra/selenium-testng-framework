package org.myframeworks.pages;

import org.myframeworks.enums.WaitStrategy;
import org.myframeworks.extentreports.ExtentLogger;
import org.myframeworks.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.myframeworks.driver.DriverManager.getDriver;

public class BasePage {

    public void clickElement(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.waitForElement(by, waitStrategy);
        element.click();
        ExtentLogger.pass(elementName + " clicked successfully", true);
    }

    public void enterText(By by, String text, WaitStrategy waitStrategy, String elementName) {
            WebElement element = ExplicitWaitFactory.waitForElement(by, waitStrategy);
            element.clear();
            element.sendKeys(text);
            ExtentLogger.pass("Text '" + text + "' entered successfully in element: " + elementName, true);
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }
}