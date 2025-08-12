package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmailPage {
	WebDriver driver;
	public ComposeEmailPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectIcon;
	@FindBy(id="subject")
	WebElement subjectTxtField;
	@FindBy(xpath="//body[@class='cke_show_borders']")
	WebElement bodyTxtArea;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSelectIcon() {
		return selectIcon;
	}
	public WebElement getSubjectTxtField() {
		return subjectTxtField;
	}
	public WebElement getBodyTxtArea() {
		return bodyTxtArea;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
