package com.slokam.test.automation.common.pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.slokam.test.automation.common.locators.Locators;
import com.slokam.test.automation.common.selenium.SafeActions;


public class LoginPage extends SafeActions implements Locators {

	ExtentTest report;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void loginToCogmento(String username, String password){
		safeType(LOGIN_INPUT_UNAME, username, 1);
		safeType(LOGIN_INPUT_PWD, password, 1);
		safeClick(LOGIN_BTN_SUBMIT, 1);
	}
	
	public void forgotPasswordLnk(){
		safeClick(LOGIN_LINK_FORGOT, 1);
	}

}
