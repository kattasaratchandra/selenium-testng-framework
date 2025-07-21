package org.myframeworks.extentreports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentReportManager {
    /**
     * 1. ExtentReportManager class to manage the ExtentReports instance.
     * 2. This class is intended to be used by the ExtentReport class to set and getProperty the ExtentReports instance.
     * 3. The ExtentReports instance is stored in a ThreadLocal variable to ensure that each thread has its own instance of ExtentReports.
     * 4. The unload method is used to remove the ExtentReports instance from the ThreadLocal variable.
     */
    private ExtentReportManager() {
    }

    private static final ThreadLocal<ExtentTest> threadLocalExtent = ThreadLocal.withInitial(() -> null);

    static ExtentTest getExtent() {
        return threadLocalExtent.get();
    }

    static void setExtentTest(ExtentTest extentTest) {
        if (Objects.nonNull(extentTest)) {
            threadLocalExtent.set(extentTest);
        }
    }

    static void unload() {
        threadLocalExtent.remove();
    }

}
