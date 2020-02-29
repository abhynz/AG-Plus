package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.BaseSetup;
import com.dataprovider.ExcelFeeder;
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
	ExcelFeeder exl;
	String fl = "Data Files\\testdata.xlsx";
	String sheet = "data_Customers";


	@DataProvider
	public Object[][] getformfill() throws Exception{
		exl = new ExcelFeeder();
		Object data[][] = exl.getcelldata(fl, sheet);
		return data;
		
	}

	@Test(dataProvider = "getformfill")
	public void createCompanyWithPublicAccess(String name, String website, String address,
			String city, String state, String zip) throws Exception{


		String url = "https://ui.cogmento.com/";
		getDriver().get(url);	
		exl = new ExcelFeeder();
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
		/*for(int i=0;i<=10;i++)
		{
			createComp.createPublicAccessCompany(exl.getcelldata(fl, sheet, i, "Name"),exl.getcelldata(fl, sheet, i, "Website"),exl.getcelldata(fl, sheet, i, "Address"),exl.getcelldata(fl, sheet, i, "City"), exl.getcelldata(fl, sheet, i, "State"), exl.getcelldata(fl, sheet, i, "Zip"));
		}*/
		createComp.createPublicAccessCompany(name,website,address,city,state,zip);
		ReportTestListner.getExtentTest().info("Successfully created new Company with Public access");

	}

	//@Test
	public void removeJunkCharacters(){
		System.out.println("%%%%%%%%%%%%%%%&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		String s = "**##@$ Java tutorials123 ##@@$$><??>";
		

		s= s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}


}
