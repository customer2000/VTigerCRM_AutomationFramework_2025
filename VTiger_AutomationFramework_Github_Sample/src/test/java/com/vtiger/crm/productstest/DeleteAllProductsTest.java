package com.vtiger.crm.productstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;

public class DeleteAllProductsTest extends BaseClass{
	@Test
	public void deleteAllProductsTest() throws IOException, InterruptedException {
		//navigate to contacts module
		driver.findElement(By.xpath("//a[.='Products']")).click();
		//deleteAll
		driver.findElement(By.xpath("//input[@name='selectall']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		WLib.switchToAlertAndAccept(driver);
		System.out.println("All products deleted successfully");
	}
}
