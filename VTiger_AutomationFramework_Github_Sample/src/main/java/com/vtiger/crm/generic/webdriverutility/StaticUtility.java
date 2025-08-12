package com.vtiger.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class StaticUtility {
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	public static void setDriver(WebDriver actDriver)
	{
		driver.set(actDriver);
	}
	public static ExtentTest getTest()
	{
		return test.get();
	}
	public static void setTest(ExtentTest actTest)
	{
		test.set(actTest);
	}
}
