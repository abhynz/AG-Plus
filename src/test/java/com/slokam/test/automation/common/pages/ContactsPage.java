package com.slokam.test.automation.common.pages;

import org.openqa.selenium.WebDriver;

import com.slokam.test.automation.common.locators.Locators;
import com.slokam.test.automation.common.selenium.SafeActions;

public class ContactsPage extends SafeActions implements Locators {

	WebDriver driver;
	public ContactsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickNewButton(){
		//safeClick(BTN_NEW, 3);
	}
	
	//public void 
}
