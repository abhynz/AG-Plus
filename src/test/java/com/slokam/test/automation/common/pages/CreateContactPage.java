package com.slokam.test.automation.common.pages;

import org.openqa.selenium.WebDriver;

import com.slokam.test.automation.common.locators.Locators;
import com.slokam.test.automation.common.selenium.SafeActions;

public class CreateContactPage extends SafeActions implements Locators{

	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickSaveButton(){
		//safeClick()
	}
}
