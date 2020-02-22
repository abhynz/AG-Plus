package com.slokam.test.automation.common.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.slokam.test.automation.common.locators.Locators;
import com.slokam.test.automation.common.selenium.SafeActions;

public class CompanyPage extends SafeActions implements Locators {

	
	public CompanyPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickNewButton(){
		safeClick(COMPANY_BTN_NEW, 3);
	}
	
	public void clickCancelButon(){
		safeClick(COMPANY_BTN_SHOWFILTERS, 3);
	}
	
	public void verifyCompanyScreen(){
		String home =safeGetText(LINK_MAINMENU_HOME, 1);
		Assert.assertEquals(home, "Home");
	}
	
}
