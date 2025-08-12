package com.vtiger.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;
import com.vtiger.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.vtiger.crm.objectrepositoryutility.HomePage;
import com.vtiger.crm.objectrepositoryutility.OrganizationInformationPage;
import com.vtiger.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithIndustryTypeTest  extends BaseClass{
	@Test
	public void createOrganizationWithIndustryTypeTest() throws IOException, InterruptedException {
		//navigate to organizations module
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgIcon().click();
		//Read organization name from excel
		String ORG_NAME= Elib.getDataFromExcelFile("organizations", 3, 1);
		//random number generator
		String U_ORG_NAME=ORG_NAME+JLib.getRandomNumber();
		//enter org name
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.getOrgnameTxtField().sendKeys(U_ORG_NAME);
		String INDUSTRY= Elib.getDataFromExcelFile("organizations", 3, 2);
		String TYPE= Elib.getDataFromExcelFile("organizations", 3, 3);		
		Select s=new Select(cnop.getIndustryDD());
		s.selectByValue(INDUSTRY);
		Select s1=new Select(cnop.getTypeDD());
		s1.selectByValue(TYPE);
		//save
		cnop.getSaveBtn().click();
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String Industry_F=oip.getIndustryTxt().getText();
		String Type_F=oip.getTypeTxt().getText();
		//verification
		Assert.assertEquals(Industry_F, INDUSTRY, INDUSTRY+" is not verified in org information");
		Assert.assertEquals(Type_F, TYPE, TYPE+" is not verified in org information");
	}
}
