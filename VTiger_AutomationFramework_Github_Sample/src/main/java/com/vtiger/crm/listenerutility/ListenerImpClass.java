package com.vtiger.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.crm.generic.webdriverutility.StaticUtility;

public class ListenerImpClass implements ISuiteListener, ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		String timeStamp=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReports/Test_"+timeStamp);
		spark.config().setDocumentTitle("VTiger CRM Test Results");
		spark.config().setReportName("VTiger CRM");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window 11");
		report.setSystemInfo("BROWSER", "Chrome");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		test = report.createTest(testName);
		StaticUtility.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"======>STARTED<=======");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"======>PASSED<=======");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		String timeStamp=new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ts=(TakesScreenshot)(/*BaseClass.sdriver*/StaticUtility.getDriver());
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+timeStamp);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"======>FAILED<=======");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

}
