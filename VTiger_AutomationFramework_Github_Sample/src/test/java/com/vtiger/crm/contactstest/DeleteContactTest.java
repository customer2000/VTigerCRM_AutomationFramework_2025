package com.vtiger.crm.contactstest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.objectrepositoryutility.ContactInformationPage;
import com.vtiger.crm.objectrepositoryutility.ContactsPage;
import com.vtiger.crm.objectrepositoryutility.CreatingNewContactPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;

public class DeleteContactTest extends BaseClass{
	@Test(groups="regressionTest")
	public void deleteContactTest() throws IOException, InterruptedException {
		//navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactIcon().click();
		//Read contact name from excel
		String LAST_NAME= Elib.getDataFromExcelFile("contacts", 1, 1);
		//random number generator
		String U_LAST_NAME=LAST_NAME+JLib.getRandomNumber();
		//enter org name
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.getLastnameTxtField().sendKeys(U_LAST_NAME);
		//save
		cncp.getSaveBtn().click();
		ContactInformationPage cip=new ContactInformationPage(driver);
		String MSG_HEADER=cip.getLastnameTxt().getText();
		String LAST_NAME_F=cip.getLastnameTxt().getText();
		//verification
		Assert.assertEquals(LAST_NAME_F, U_LAST_NAME, U_LAST_NAME+" is not verified in contact name");
		Assert.assertTrue(MSG_HEADER.contains(U_LAST_NAME),U_LAST_NAME+" is not verified in message header");
		//Delete a contact
		hp.getContactsLink().click();
		cp.searchContact(U_LAST_NAME);
		driver.findElement(By.xpath("//a[.='"+U_LAST_NAME+"']/../../td[10]/a[.='del']")).click();
		System.out.println(U_LAST_NAME+" deleted successfully");
		driver.switchTo().alert().accept();
	}
}
