package com.vtiger.crm.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	WebDriver driver;
	public EmailPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Compose")
	private WebElement composeLink;
	@FindBy(name="selectall")
	private WebElement selectAllCB;
	@FindBy(xpath="//input[@value=' Delete']")
	private WebElement deleteBtn;
	
	public WebElement getComposeLink() {
		return composeLink;
	}
	public WebElement getSelectAllCB() {
		return selectAllCB;
	}
	
	public int getEmailCount()
	{
		List<WebElement> total_email_count=driver.findElements(By.xpath("//div[@id='rssScroll']/descendant::tr"));
		int count=1;
		for(WebElement email_count:total_email_count) {count++;}
		int totalEmailCount=count;
		return totalEmailCount;
	}
	
	public void deleteEmail() {
		deleteBtn.click();
		driver.switchTo().alert().accept();
	}
}
