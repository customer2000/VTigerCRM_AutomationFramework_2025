package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectContactPage {
	WebDriver driver;
	public SelectContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchTxtField;
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSearchTxtField() {
		return searchTxtField;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void selectContactName(String U_LAST_NAME )
	{
		searchTxtField.sendKeys(U_LAST_NAME);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.=' "+U_LAST_NAME+"']")).click();
	}
}
