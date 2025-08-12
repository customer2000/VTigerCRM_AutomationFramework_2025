package practice.amazon.producttest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.crm.generic.fileutility.ExcelFileUtility;
import com.vtiger.crm.generic.webdriverutility.WebdriverUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetProductInfoTest {
	@Test
	public void addProductInfoTest() throws EncryptedDocumentException, IOException
	{
		WebdriverUtility WLib=new WebdriverUtility();
		ExcelFileUtility ELib=new ExcelFileUtility();
	
		WebDriver driver=new ChromeDriver();
		WLib.maximizeWindow(driver);
		WLib.waitForPageToLoad(driver);
		//URL
		driver.get("https://www.google.com/");
		try {
		driver.findElement(By.xpath("//span[.='Stay signed out']")).click();
		}catch(Exception e) {};
		
		driver.findElement(By.xpath("//*[local-name()='svg']/*[name()='image']")).click();

	}
}
