package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	@FindBy(linkText="Email")
	private WebElement emailLink;
	@FindBy(linkText="Products")
	private WebElement productsLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	public WebElement getEmailLink() {
		return emailLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public void logout()
	{
		Actions a=new Actions(driver);
		a.moveToElement(adminImg).perform();
		signoutLink.click();
	}
}
