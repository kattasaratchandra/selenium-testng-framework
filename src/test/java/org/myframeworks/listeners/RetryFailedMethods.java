package org.myframeworks.listeners;

import org.myframeworks.enums.ConfigProperties;
import org.myframeworks.utils.ReadPropertyFileUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.myframeworks.enums.ConfigProperties.RETRY_FAILED_TESTS;

public class RetryFailedMethods implements IRetryAnalyzer {

    private int count = 0;
    private final int retry = Integer.parseInt(ReadPropertyFileUtils.getProperty(ConfigProperties.RETRY.name()));

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        if(ReadPropertyFileUtils.getProperty(RETRY_FAILED_TESTS.name()).equalsIgnoreCase("yes")) {
            value = count < retry;
            count++;
        }
        return value;
    }
}
