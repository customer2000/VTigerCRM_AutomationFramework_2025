package com.vtiger.crm.emailtest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.objectrepositoryutility.EmailPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;

public class DeleteAllEmail  extends BaseClass{
	@Test(groups="regressionTest")
	public void deleteAllEmail() throws IOException, InterruptedException{
		//navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getEmailLink().click();
		//deleteAll
		EmailPage ep=new EmailPage(driver);
		ep.getSelectAllCB().click();
		ep.deleteEmail();
		System.out.println("All emails deleted successfully");
	}
}
