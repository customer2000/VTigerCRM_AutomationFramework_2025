package com.vtiger.crm.orgtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInformationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createOrganizationTest() throws IOException, InterruptedException {
		//navigate to organizations module
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgIcon().click();
		//Read organization name from excel
		String ORG_NAME= Elib.getDataFromExcelFile("organizations", 1, 1);
		//random number generator
		String U_ORG_NAME=ORG_NAME+JLib.getRandomNumber();
		//enter org name
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getOrgnameTxtField().sendKeys(U_ORG_NAME);
		//save
		cnop.getSaveBtn().click();
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String ORG_NAME_F=oip.getOrgnameTxt().getText();
		String MSG_HEADER=oip.getMessageHeaderTxt().getText();
		//verification
		Assert.assertEquals(ORG_NAME_F, U_ORG_NAME, U_ORG_NAME+" is not verified in org name");
		Assert.assertTrue(MSG_HEADER.contains(U_ORG_NAME), U_ORG_NAME+" is not verified in message header");
	}
}
