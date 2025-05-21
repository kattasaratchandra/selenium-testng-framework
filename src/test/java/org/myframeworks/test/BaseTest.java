package org.myframeworks.test;

import org.myframeworks.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * 1. BaseTest class to initialize and quit the WebDriver before and after each test method.
 * This class is intended to be extended by other test classes.
 * 2. null checking is done to avoid re-initializing the driver if it is already set.
 * 3. code duplication is avoided by using the BaseTest class.
 */

public abstract class BaseTest {

    protected BaseTest() {}

    @BeforeMethod
    public void initDriver() {
            Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
            Driver.quitDriver();
    }
}