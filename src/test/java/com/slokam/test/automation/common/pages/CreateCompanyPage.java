package com.slokam.test.automation.common.pages;

import org.openqa.selenium.WebDriver;

import com.slokam.test.automation.common.locators.Locators;
import com.slokam.test.automation.common.selenium.SafeActions;
import com.testng.Assert;

public class CreateCompanyPage extends SafeActions implements Locators {

	WebDriver driver;
	public CreateCompanyPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void verifyTitle(){
		String pageTitle = safeGetText(CREATECOMPANY_TITLE, 2);
		Assert.assertEquals(pageTitle, "Create new Company");
	}
	
	public void saveCompany(){
		safeClick(CREATECOMPANY_BTN_SAVE, 1);
	}
	
	
	public void createPublicAccessCompany(String name, String website, String address,
			String city, String state, String zip) throws InterruptedException{
		safeType(CREATECOMPANY_INPUT_NAME, name, 2);
		safeType(CREATECOMPANY_INPUT_WEBSITE, website, 2);
		safeType(CREATECOMPANY_INPUT_ADDRESS, address, 2);
		safeType(CREATECOMPANY_INPUT_CITY, city, 2);
		safeType(CREATECOMPANY_INPUT_STATE, state, 2);
		safeType(CREATECOMPANY_INPUT_ZIP, zip, 2);
		/*//safeClick(CREATECOMPANY_INPUT_COUNTRY, 2);
		Thread.sleep(000);
		safeSelectCountry(countryName);*/
		
	}
	
	
}
