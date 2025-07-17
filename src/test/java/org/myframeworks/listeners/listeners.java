package org.myframeworks.listeners;

import org.myframeworks.annotations.FrameWorkAnnotation;
import org.myframeworks.extentreports.ExtentLogger;
import org.myframeworks.extentreports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class listeners implements ITestListener{
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod().
                getAnnotation(FrameWorkAnnotation.class).author());
        ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().
                getAnnotation(FrameWorkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + ": " + "passed" , true );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed" ,  true);
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + ": " + "skipped", true  );

    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.flushReports();
    }
}
