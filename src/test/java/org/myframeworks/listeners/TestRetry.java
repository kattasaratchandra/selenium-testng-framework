package org.myframeworks.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2; // Set the maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
    if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            System.out.println("Retrying test " + result.getName() + " for the " + retryCount + " time.");
            return true; // Retry the test
        }
        return false;
    }
}
