package com.vtiger.crm.orgtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInformationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithPhoneTest extends BaseClass{
	@Test
	public void createOrganizationWithPhoneTest() throws IOException, InterruptedException {
		//navigate to organizations module
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgIcon().click();
		//Read organization name from excel
		String ORG_NAME= Elib.getDataFromExcelFile("organizations", 5, 1);
		//random number generator
		String U_ORG_NAME=ORG_NAME+JLib.getRandomNumber();
		//enter org name
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getOrgnameTxtField().sendKeys(U_ORG_NAME);
		//
		String PHONE= Elib.getDataFromExcelFile("organizations", 5, 2);
		cnop.getPhoneTxtField().sendKeys(PHONE);
		//save
		cnop.getSaveBtn().click();
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String PHONE_F=oip.getPhoneTxt().getText();
		//verification
		Assert.assertTrue(PHONE_F.equals(PHONE), PHONE+" is not verified in org information");
	}
}
