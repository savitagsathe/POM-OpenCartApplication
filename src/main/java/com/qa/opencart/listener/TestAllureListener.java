package com.qa.opencart.listener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import com.qa.opencart.factory.DriverFactory;


public class TestAllureListener extends DriverFactory implements ITestListener {

	    private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }

	    @Attachment(value = "Page screenshot", type = "image/png")
	    public byte[] saveScreenshotPNG() {
	        return ((TakesScreenshot) getDriver())
	                .getScreenshotAs(OutputType.BYTES);
	    }

	    @Attachment(value = "{0}", type = "text/plain")
	    public static String saveTextLog(String message) {
	        return message;
	    }

	    @Attachment(value = "{0}", type = "text/html")
	    public static String attachHtml(String html) {
	        return html;
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println("Execution Started : " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("Execution Finished : " + context.getName());
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        saveTextLog("Test Started : " + getTestMethodName(result));
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        saveTextLog("Test Passed : " + getTestMethodName(result));
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	        saveTextLog("Test Failed : " + getTestMethodName(result));

	        if (getDriver() != null) {
	            saveScreenshotPNG();
	        }

	        saveTextLog(result.getThrowable().toString());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        saveTextLog("Test Skipped : " + getTestMethodName(result));
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    }
	}
