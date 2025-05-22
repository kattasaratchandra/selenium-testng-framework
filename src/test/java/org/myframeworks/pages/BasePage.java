package org.myframeworks.pages;

import org.myframeworks.enums.WaitStrategy;
import org.myframeworks.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.myframeworks.driver.DriverManager.getDriver;

public class BasePage {

    public void clickElement(By by, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.waitForElement(by, waitStrategy);
        element.click();
    }

    public void enterText(By by, String text, WaitStrategy waitStrategy) {
            WebElement element = ExplicitWaitFactory.waitForElement(by, waitStrategy);
            element.clear();
            element.sendKeys(text);
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }
}