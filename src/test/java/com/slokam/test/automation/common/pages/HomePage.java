package com.slokam.test.automation.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.slokam.test.automation.common.locators.Locators;
import com.slokam.test.automation.common.selenium.SafeActions;

public class HomePage extends SafeActions implements Locators {

	WebDriver driver ;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickOnHomeLink(){
		safeClick(LINK_MAINMENU_HOME);
	}

	public void clickOnContactsLink(){
		safeClick(LINK_MAINMENU_CONTACTS);
	}
	
	public void clickOnCompaniesLink(){
		safeClick(LINK_MAINMENU_COMPANIES);
	}


}
