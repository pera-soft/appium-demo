package com.demo.appium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // empty
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // empty
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // empty
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // empty
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // empty
    }

    @Override
    public void onStart(ITestContext context) {
        // empty
    }

    @Override
    public void onFinish(ITestContext context) {
        // empty
    }

}