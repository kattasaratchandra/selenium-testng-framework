package org.myframeworks.pages;

import org.myframeworks.enums.WaitStrategy;
import org.myframeworks.extentreports.ExtentLogger;
import org.myframeworks.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.myframeworks.driver.DriverManager.getDriver;

/**
 * Base class for all page objects in the test framework.
 * Provides common actions such as clicking elements, entering text,
 * and retrieving the page title. Utilizes explicit waits and logging
 * to ensure reliable interactions and traceability in test reports.
 * Intended to be extended by specific page classes to avoid code duplication.
 */
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