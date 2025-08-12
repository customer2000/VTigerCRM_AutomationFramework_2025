package com.vtiger.crm.emailtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.objectrepositoryutility.ComposeEmailPage;
import com.vtiger.crm.objectrepositoryutility.ContactInformationPage;
import com.vtiger.crm.objectrepositoryutility.ContactsPage;
import com.vtiger.crm.objectrepositoryutility.CreatingNewContactPage;
import com.vtiger.crm.objectrepositoryutility.EmailPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.SelectContactPage;

public class DeleteAnEmailTest extends BaseClass{
	@Test(groups="regressionTest")
	public void deleteAnEmailTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactIcon().click();
		//Read last name, email and body format name from excel
		String LAST_NAME= Elib.getDataFromExcelFile("email", 3, 1);
		//random number generator
		String U_LAST_NAME=LAST_NAME+JLib.getRandomNumber();
		String EMAIL_FORMAT= Elib.getDataFromExcelFile("email", 3, 2);
		String EMAIL_ID=U_LAST_NAME+EMAIL_FORMAT;
		//subject
		String SUB= Elib.getDataFromExcelFile("email", 3, 3);
		String U_SUB=SUB+JLib.getRandomNumber();
		//body
		String BODY= Elib.getDataFromExcelFile("email", 3, 4);
		//enter org name
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.getLastnameTxtField().sendKeys(U_LAST_NAME);
		cncp.getEmailTxtField().sendKeys(EMAIL_ID);
		//save
		cncp.getSaveBtn().click();
		//verification
		ContactInformationPage cip=new ContactInformationPage(driver);
		String EMAIL_ID_F=cip.getEmailTxt().getText();
		Assert.assertEquals(EMAIL_ID_F.trim(), EMAIL_ID, EMAIL_ID+" is verified in contact information");
		
		//navigate to email module
		hp.getEmailLink().click();
		EmailPage ep=new EmailPage(driver);
		ep.getComposeLink().click();
		//Before Verification
		int email_count_before=ep.getEmailCount();
		System.out.println("Email count before creation: "+email_count_before);
		//mail creation
		WLib.switchToTabOnUrl(driver, "module=Emails&action=Emails");
		ComposeEmailPage cep=new ComposeEmailPage(driver);
		cep.getSelectIcon().click();
		WLib.switchToTabOnUrl(driver, "module=Contacts");
		SelectContactPage scp=new SelectContactPage(driver);
		scp.selectContactName(U_LAST_NAME);
		WLib.switchToTabOnUrl(driver, "module=Emails&action=Emails");
		cep.getSubjectTxtField().sendKeys(U_SUB);
		driver.switchTo().frame(0);
		cep.getBodyTxtArea().sendKeys(BODY);
		driver.switchTo().parentFrame();
		cep.getSaveBtn().click();
		WLib.switchToTabOnUrl(driver, "module=Emails");
		//After email creation Verification
		Thread.sleep(3000);
		int email_count_after=ep.getEmailCount();
		System.out.println("Email count after creation: "+email_count_after);
		Assert.assertTrue(email_count_after==email_count_before+1, "Email not saved successfully");
		//Deletion single mail
		driver.findElement(By.xpath("//td[contains(@onclick,'getEmailContents') and .='"+U_SUB+" ']/preceding-sibling::td/span/input")).click();
		ep.deleteEmail();
		Thread.sleep(3000);
		//After deletion verification
		int email_count_after_d=ep.getEmailCount();
		System.out.println("Email count after deletion: "+email_count_after_d);
		Assert.assertTrue(email_count_after_d==email_count_before, "Email not deleted successfully");
	}
}
