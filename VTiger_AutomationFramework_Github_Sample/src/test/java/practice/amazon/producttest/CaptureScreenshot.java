package practice.amazon.producttest;

import org.testng.annotations.Test;

import com.vtiger.crm.generic.fileutility.ExcelFileUtility;
import com.vtiger.crm.generic.webdriverutility.WebdriverUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CaptureScreenshot {
	@Test
	public void screenshotTest() throws IOException
	{
		WebdriverUtility WLib=new WebdriverUtility();
		ExcelFileUtility ELib=new ExcelFileUtility();

		WebDriver driver=new ChromeDriver();
		WLib.maximizeWindow(driver);
		WLib.waitForPageToLoad(driver);
		//URL
		driver.get("https://www.amazon.in/");
		try {
		driver.findElement(By.xpath("//button[.='Continue shopping']")).click();
		}catch(Exception e) {};
		TakesScreenshot ts=(TakesScreenshot)driver;
//		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
//		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./Screenshots/Test.png"));
		driver.quit();
	}
}
