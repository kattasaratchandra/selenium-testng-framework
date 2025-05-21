package org.myframeworks.test;

import org.myframworks.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

/**
 * 1. BaseTest class to initialize and quit the WebDriver before and after each test method.
 * This class is intended to be extended by other test classes.
 * 2. null checking is done to avoid re-initializing the driver if it is already set.
 * 3. code duplication is avoided by using the BaseTest class.
 */

public class BaseTest {

    protected BaseTest() {}

    protected WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        if (Objects.isNull(driver)) {
            Driver.setDriver();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (Objects.nonNull(driver)) {
            Driver.quitDriver();
        }
    }
}