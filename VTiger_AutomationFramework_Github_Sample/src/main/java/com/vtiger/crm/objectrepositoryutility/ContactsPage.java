package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage {
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactIcon;
	@FindBy(name="search_text")
	private WebElement searchTxtField;
	@FindBy(id="bas_searchfield")
	private WebElement searchCategoryDD;
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}
	
	public void searchContact(String U_LAST_NAME/* , SEARCH_CATEGORY */)
	{
		searchTxtField.sendKeys(U_LAST_NAME);
		Select s=new Select(searchCategoryDD);
		s.selectByValue("lastname");
		searchBtn.click();
	}
}
