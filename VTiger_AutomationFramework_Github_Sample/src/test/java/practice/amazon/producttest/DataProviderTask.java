package practice.amazon.producttest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.crm.generic.fileutility.ExcelFileUtility;
import com.vtiger.crm.generic.webdriverutility.WebdriverUtility;

public class DataProviderTask {
	@Test
	public void addProductInfoTest() throws EncryptedDocumentException, IOException
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
		
		String brandName="samsung";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);
		//store all the product details in xls
		FileInputStream fis=new FileInputStream("./testData/Amazon.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("product");
		List<WebElement> pnames=driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
		int i=1;
		for(WebElement pname:pnames)
		{
			sheet.createRow(i).createCell(0).setCellValue(brandName);
			i++;
		}
		i=1;
		for(WebElement pname:pnames)
		{
			sheet.createRow(i).createCell(1).setCellValue(pname.getText());
			i++;
		}
		FileOutputStream fos=new FileOutputStream("./testData/Amazon.xlsx");
		book.write(fos);
		book.close();
		fos.close();
		/* (dependsOnMethods="addProductInfoTest", dataProvider="getData") */
	}

	@Test (dataProvider="getData")
	public void getProductInfoTest(String b, String p) throws EncryptedDocumentException, IOException
	{
		System.out.println(b+" "+p);
		/*
		 * FileInputStream fis=new FileInputStream("./testData/Amazon.xlsx"); Workbook
		 * book=WorkbookFactory.create(fis); Sheet sheet=book.getSheet("product"); int
		 * rn=sheet.getLastRowNum(); // Object[][] obj=new Object[rn][5]; try { for(int
		 * x=0;x<rn;x++) { int cn=sheet.getRow(x+1).getLastCellNum();
		 * System.out.println(x+" last cell num"+cn); for(int y=0;y<cn;y++) {
		 * System.out.println(y); String
		 * value=sheet.getRow(x+1).getCell(y+1).getStringCellValue();
		 * System.out.println(value); // if(y==0) // obj[x][y]="samsung"; // if(y==1) //
		 * obj[x][y]=value; } }} catch(Exception e) {System.ou
		 *//* t.println("null=");} */
//		WebdriverUtility WLib=new WebdriverUtility();
//
//		WebDriver driver=new ChromeDriver();
//		WLib.maximizeWindow(driver);
//		WLib.waitForPageToLoad(driver);
//		driver.get("https://www.amazon.in/");
//		try {
//			driver.findElement(By.xpath("//button[.='Continue shopping']")).click();
//			}catch(Exception e) {};
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(b, Keys.ENTER);
//		System.out.println(driver.findElement(By.xpath("//span[.='"+p+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span[1]/span[2]/span[2]")).getText());
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./testData/Amazon.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("product");
		int rn=sheet.getLastRowNum();
		Object[][] obj=new Object[rn][];
		try {
		for(int x=0;x<rn;x++)
		{
			int cn=sheet.getRow(x+1).getLastCellNum();
			for(int y=0;y<cn;y++)
			{
				if(y==0)
				obj[x][y]="samsung";
				if(y==1)
				obj[x][y]=sheet.getRow(x+1).getCell(y).getStringCellValue();
;
			}
		}}
		catch(Exception e) {}
		return obj;
	}
}
