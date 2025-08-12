package com.vtiger.crm.productstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.objectrepositoryutility.HomePage;

public class AddProductTest extends BaseClass{
	@Test
	public void addProductTest() throws IOException, InterruptedException {
		//navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//Read contact name from excel
		String PRODUCT_NAME= Elib.getDataFromExcelFile("products", 1, 1);
		//random number generator
		String U_PRODUCT_NAME=PRODUCT_NAME+JLib.getRandomNumber();
		//enter org name
		driver.findElement(By.name("productname")).sendKeys(U_PRODUCT_NAME);
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String MSG_HEADER=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		String PRODUCT_NAME_F=driver.findElement(By.id("dtlview_Product Name")).getText();
		//verification
		Assert.assertEquals(PRODUCT_NAME_F, U_PRODUCT_NAME, U_PRODUCT_NAME+" is not verified in product name");
		Assert.assertTrue(MSG_HEADER.contains(U_PRODUCT_NAME), U_PRODUCT_NAME+" is not verified in product name");
	}
}
