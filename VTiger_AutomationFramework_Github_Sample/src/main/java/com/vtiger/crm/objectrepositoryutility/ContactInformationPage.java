package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement messageHeaderTxt;
	@FindBy(id="dtlview_Last Name")
	private WebElement lastnameTxt;
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgnameTxt;
	@FindBy(id="dtlview_Support Start Date")
	private WebElement supportSartDateTxt;
	@FindBy(id="dtlview_Support End Date")
	private WebElement supportEndDateTxt;
	@FindBy(id="mouseArea_Email")
	private WebElement emailTxt;
	
	public WebElement getMessageHeaderTxt() {
		return messageHeaderTxt;
	}
	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}	
	public WebElement getOrgnameTxt() {
		return orgnameTxt;
	}
	public WebElement getSupportSartDateTxt() {
		return supportSartDateTxt;
	}
	public WebElement getSupportEndDateTxt() {
		return supportEndDateTxt;
	}
	public WebElement getEmailTxt() {
		return emailTxt;
	}
}
