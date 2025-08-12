package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgnameTxtField;
	@FindBy(name="industry")
	private WebElement industryDD;
	@FindBy(name="accounttype")
	private WebElement typeDD;
	@FindBy(id="phone")
	private WebElement phoneTxtField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgnameTxtField() {
		return orgnameTxtField;
	}
	public WebElement getIndustryDD() {
		return industryDD;
	}
	public WebElement getTypeDD() {
		return typeDD;
	}
	public WebElement getPhoneTxtField() {
		return phoneTxtField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
