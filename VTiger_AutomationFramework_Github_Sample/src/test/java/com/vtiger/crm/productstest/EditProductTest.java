package com.vtiger.crm.productstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;

public class EditProductTest extends BaseClass{
	@Test
	public void editProductTest() throws IOException, InterruptedException {
		//navigate to products module
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//Read product name,search category and product category from excel
		String PRODUCT_NAME= Elib.getDataFromExcelFile("products", 3, 1);
		String SEARCH_CATEGORY= Elib.getDataFromExcelFile("products", 3, 2);
		String PRODUCT_CATEGORY= Elib.getDataFromExcelFile("products", 3, 3);
		//random number generator
		String U_PRODUCT_NAME=PRODUCT_NAME+JLib.getRandomNumber();
		//enter product name
		driver.findElement(By.name("productname")).sendKeys(U_PRODUCT_NAME);
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//edit
		driver.findElement(By.xpath("//a[.='Products']")).click();
		WebElement ele1=driver.findElement(By.id("bas_searchfield"));
		WLib.selectByValue(ele1, SEARCH_CATEGORY);
		driver.findElement(By.name("search_text")).sendKeys(U_PRODUCT_NAME);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[@title='Products' and .='"+U_PRODUCT_NAME+"']")).click();
		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		WebElement ele=driver.findElement(By.name("productcategory"));
		WLib.selectByValue(ele, PRODUCT_CATEGORY);
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verification
		String PRODUCT_CATEGORY_F=driver.findElement(By.id("dtlview_Product Category")).getText();
		if(PRODUCT_CATEGORY_F.equals(PRODUCT_CATEGORY))
			System.out.println(PRODUCT_CATEGORY+" is verified in product name");
		else
			System.out.println(PRODUCT_CATEGORY+" is not verified in product name");
	}
}
