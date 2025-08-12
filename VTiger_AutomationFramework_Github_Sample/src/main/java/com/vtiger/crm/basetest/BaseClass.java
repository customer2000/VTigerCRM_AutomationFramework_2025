package com.vtiger.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.crm.generic.databaseutility.DatabaseUtility;
import com.vtiger.crm.generic.fileutility.ExcelFileUtility;
import com.vtiger.crm.generic.fileutility.PropertyFileUtility;
import com.vtiger.crm.generic.webdriverutility.JavaFileUtility;
import com.vtiger.crm.generic.webdriverutility.StaticUtility;
import com.vtiger.crm.generic.webdriverutility.WebdriverUtility;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	//create object
	public PropertyFileUtility PLib=new PropertyFileUtility();
	public ExcelFileUtility Elib=new ExcelFileUtility();
	public WebdriverUtility WLib=new WebdriverUtility();
	public JavaFileUtility JLib=new JavaFileUtility();
	public DatabaseUtility DLib=new DatabaseUtility();
	public WebDriver driver=null;
//	public static WebDriver sdriver=null;
	@BeforeSuite(alwaysRun=true)
	public void configBS() throws SQLException
	{
		System.out.println("===Connect to DB, configure Report===");
		DLib.getConnection();
	}
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun=true)
	public void configBC( /* String browser */ ) throws IOException
	{
		System.out.println("===Launch Browser===");
		String BROWSER = PLib.getDataFromPropertiesFile("browser");
//		String BROWSER = browser;
		if(BROWSER.equalsIgnoreCase("chrome")) { driver=new ChromeDriver(); } else
		if(BROWSER.equalsIgnoreCase("firefox")) { driver=new FirefoxDriver(); } else
		if(BROWSER.equalsIgnoreCase("edge")) { driver=new EdgeDriver(); } else { driver=new ChromeDriver(); } 
		StaticUtility.setDriver(driver);
		
	}
	@BeforeMethod(alwaysRun=true)
	public void configBM() throws IOException
	{
		System.out.println("===Login===");
		String URL = PLib.getDataFromPropertiesFile("url");
		String USERNAME=PLib.getDataFromPropertiesFile("username"); 
		String PASSWORD=PLib.getDataFromPropertiesFile("password");
		LoginPage l= new LoginPage(driver);
		l.loginToApp(URL, USERNAME, PASSWORD);
	}
	@AfterMethod(alwaysRun=true)
	public void configAM()
	{
		System.out.println("===Logout===");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass(alwaysRun=true)
	public void configAC()
	{
		System.out.println("===Close Browser===");
		driver.quit();
	}
	@AfterSuite(alwaysRun=true)
	public void configAS() throws SQLException
	{
		System.out.println("===Disonnect to DB, Report backup===");
		DLib.closeConnection();
	}
	
}
