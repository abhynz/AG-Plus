package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.slokam.test.automation.common.pages.CompanyPage;
import com.slokam.test.automation.common.pages.CreateCompanyPage;
import com.slokam.test.automation.common.pages.HomePage;
import com.slokam.test.automation.common.pages.LoginPage;
import com.utilities.ReportTestListner;

public class CreateCompanyTest extends BaseSetup {
	
	LoginPage lp;
	HomePage hp;
	CompanyPage comp;
	CreateCompanyPage createComp;

	
	@Test
	public void createCompanyWithPublicAccess() throws Exception{
		
		
		String url = "https://ui.cogmento.com/";
		getDriver().get(url);	
		ReportTestListner.getExtentTest().info("Entered url ::"+ url);  
	
		lp = new LoginPage(getDriver());
		lp.loginToCogmento("abhy1919@gmail.com", "Abhy@4321");
		ReportTestListner.getExtentTest().info("Logged into Application succcessfully");
		
		hp = new HomePage(getDriver());
		hp.clickOnCompaniesLink();
		ReportTestListner.getExtentTest().info("Clicked on Companies link on Homepage");
		
		comp = new CompanyPage(getDriver());
		comp.verifyCompanyScreen();
		ReportTestListner.getExtentTest().info("Company screen verification succesfull");
		comp.clickNewButton();
		ReportTestListner.getExtentTest().info("Clicked on NEW button on Comapnies screen");
		
		createComp = new CreateCompanyPage(getDriver());
		createComp.createPublicAccessCompany("Abhinandan","https://www.facebook.com/","1-32,shaikpet","Hyderabad","Telangana","50008","Cameroon");
		ReportTestListner.getExtentTest().info("Successfully created new Company with Public access");
		
	}
	
	
}
