package com.slokam.test.automation.common.locators;

import org.openqa.selenium.By;

public interface Locators {

	public static By LOGIN_INPUT_UNAME = By.name("email");
	public static By LOGIN_INPUT_PWD = By.name("password");
	public static By LOGIN_BTN_SUBMIT = By.xpath("//div[text()='Login']");
	public static By LOGIN_LINK_FORGOT = By.xpath("//a[contains(text(),'Forgot')]");
	
	/**
	 * MAIN MENU NAVIGATOR
	 */
	public static By LINK_MAINMENU_HOME = By.xpath("//div[@id='main-nav']//span[text()='Home']");
	public static By LINK_MAINMENU_CONTACTS = By.xpath("//div[@id='main-nav']//span[text()='Contacts']");
	public static By LINK_MAINMENU_COMPANIES = By.xpath("//div[@id='main-nav']//span[text()='Companies']");
	
	
	/**
	 * CONTACTS PAGE elements
	 * 
	 */
	public static By CONTACTS_BTN_NEW = By.xpath("//div[@id='dashboard-toolbar']//a/button");
	
	
	/**
	 * CREATE CONTACTS PAGE elements
	 */
	public static By CREATECONTACT_BTN_SAVE = By.xpath("//div[@id='dashboard-toolbar']//button[2]");
	public static By CREATECONTACT_BTN_CANCEL = By.xpath("//div[@id='dashboard-toolbar']//button[1]");
	public static By CREATECONTACT_INPUT_FNAME = By.name("first_name");
	public static By CREATECONTACT_INPUT_LNAME = By.name("last_name");
	public static By CREATECONTACT_INPUT_MIDDLENAME = By.name("middle_name");
	
	
		
	/**
	 *  COMPANY PAGE elements
	 */
	public static By COMPANY_BTN_NEW = By.xpath("//div[@id='dashboard-toolbar']//a");
	public static By COMPANY_BTN_SHOWFILTERS = By.xpath("//div[@id='dashboard-toolbar']//button[text()='Show Filters']");
	
	
	/**
	 *  CREATE COMPANY PAGE elements
	 */
	public static By CREATECOMPANY_TITLE = By.xpath("//div[contains(@class,'toolbar-container')]/preceding-sibling::div[text()='Create new Company']");
	public static By CREATECOMPANY_BTN_SAVE = By.xpath("//div[@id='dashboard-toolbar']//button[text()='Save']");
	public static By CREATECOMPANY_BTN_CANCEL = By.xpath("//div[@id='dashboard-toolbar']//button[text()='Cancel']");
	public static By CREATECOMPANY_INPUT_NAME = By.name("name");
	public static By CREATECOMPANY_BTN_ACCESS = By.xpath("//form[contains(@class,'custom-form-container')]//button[contains(@class,'toggle')]/i");
	public static By CREATECOMPANY_INPUT_WEBSITE = By.name("url");
	public static By CREATECOMPANY_INPUT_ADDRESS = By.name("name");
	public static By CREATECOMPANY_INPUT_CITY = By.name("city");
	public static By CREATECOMPANY_INPUT_STATE = By.name("state");
	public static By CREATECOMPANY_INPUT_ZIP = By.name("zip");
	public static By CREATECOMPANY_INPUT_COUNTRY = By.xpath("//div[@name='country']");
	

}
