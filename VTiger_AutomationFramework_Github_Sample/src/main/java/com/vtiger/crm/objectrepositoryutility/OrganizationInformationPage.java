package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement messageHeaderTxt;
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgnameTxt;
	@FindBy(id="dtlview_Industry")
	private WebElement industryTxt;
	@FindBy(id="dtlview_Type")
	private WebElement typeTxt;
	@FindBy(id="dtlview_Phone")
	private WebElement phoneTxt;
	
	public WebElement getMessageHeaderTxt() {
		return messageHeaderTxt;
	}
	public WebElement getOrgnameTxt() {
		return orgnameTxt;
	}
	public WebElement getIndustryTxt() {
		return industryTxt;
	}
	public WebElement getTypeTxt() {
		return typeTxt;
	}
	public WebElement getPhoneTxt() {
		return phoneTxt;
	}
}
