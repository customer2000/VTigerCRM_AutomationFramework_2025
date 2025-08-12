package com.vtiger.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.crm.generic.webdriverutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTxtField;
	@FindBy(name="user_password")
	private WebElement passwordTxtField;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public WebElement getUsernameTxtField() {
		return usernameTxtField;
	}
	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void loginToApp(String URL, String USERNAME, String PASSWORD)
	{
		waitForPageToLoad(driver);
		driver.get(URL);
		maximizeWindow(driver);
		usernameTxtField.sendKeys(USERNAME);
		passwordTxtField.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
}
