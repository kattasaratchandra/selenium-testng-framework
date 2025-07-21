package org.myframeworks.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;


public final class DriverManager {
    /**
     * 1. DriverManager class to manage the WebDriver instance using ThreadLocal.
     * 2. This class is intended to be used by the Driver class to set and getProperty the WebDriver instance.
     * 3. The WebDriver instance is stored in a ThreadLocal variable to ensure that each thread has its own instance of WebDriver.
     * 4. The unload method is used to remove the WebDriver instance from the ThreadLocal variable.
     */

    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> threadLocalDriver = ThreadLocal.withInitial(() -> null);

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    static void setDriver(WebDriver driver) {
        if (Objects.nonNull(driver)) {
            threadLocalDriver.set(driver);
        }
    }

    static void unload() {
        threadLocalDriver.remove();
    }

    /* we can set the initial value of thread local driver to chrome driver. the default
    value is null.
    code:
    "private static final ThreadLocal<WebDriver> threadLocalDriver = ThreadLocal.withInitial(() -> new ChromeDriver());"
    * */
}
