package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {
	public ProjectsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//img[@title='Create Organization...']")
//	private WebElement createOrgIcon;

//	public WebElement getCreateOrgIcon() {
//		return createOrgIcon;
//	}
}
