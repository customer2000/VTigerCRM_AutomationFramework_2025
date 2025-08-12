package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameTxtField;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement selectOrgIcon;
	@FindBy(id="jscal_field_support_start_date")
	private WebElement supportStartDateTxtField;
	@FindBy(id="jscal_field_support_end_date")
	private WebElement supportEndDateTxtField;
	@FindBy(id="email")
	private WebElement emailTxtField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getLastnameTxtField() {
		return lastnameTxtField;
	}
	public WebElement getSelectOrgIcon() {
		return selectOrgIcon;
	}
	public WebElement getSupportStartDateTxtField() {
		return supportStartDateTxtField;
	}
	public WebElement getSupportEndDateTxtField() {
		return supportEndDateTxtField;
	}
	public WebElement getEmailTxtField() {
		return emailTxtField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
