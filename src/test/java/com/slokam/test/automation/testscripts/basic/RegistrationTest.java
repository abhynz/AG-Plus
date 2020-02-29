/*package com.slokam.test.automation.testscripts.basic;

import java.util.HashMap;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.dataprovider.ExcelManager;
import com.slokam.test.automation.common.dto.UserDTO;
import com.slokam.test.automation.common.pages.HomePage;
import com.slokam.test.automation.common.pages.RegistrationPage;

public class RegistrationTest extends BaseSetup {

	ConfigManager envProps = new ConfigManager("environment");
	
	@Test
	public void testPasswordMissmatch() throws InterruptedException{
		UserDTO dto = new UserDTO();
		dto.setUserName("test1");
		dto.setPassword("test1234");
		dto.setConfirm("test2341");
		dto.setFirstName("test1");
		dto.setLastName("test1");
		dto.setEmail("test@gmail.com");
		String url =envProps.getProperty("url") ;
		getDriver().get(url);
		HomePage homePage = new HomePage(getDriver());
		RegistrationPage regPage = new RegistrationPage(getDriver());
		homePage.verifyHomePage();
		homePage.clickNewRegistration();
		regPage.verifyRegistraionPage();
		regPage.createAccount( dto);
		String expectedErrorMessage = "Password doesn't match confirmation";
		String actualErrorMessage = regPage.verifyErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage , " Error message validation is failed.");
		
		String actualError = regPage.verifyErrorLocation();
		String expected = "user_password";
		Assert.assertEquals(actualError, expected , "Error validation is in wrong place");
		
	}
	
	//@Test
	public void testPasswordLengthValidation() throws InterruptedException{
		UserDTO dto = new UserDTO();
		dto.setUserName("test1");
		dto.setPassword("test1");
		dto.setConfirm("test1");
		dto.setFirstName("test1");
		dto.setLastName("test1");
		dto.setEmail("test@gmail.com");
		
		String url =envProps.getProperty("url") ;
		getDriver().get(url);
		HomePage homePage = new HomePage(getDriver());
		RegistrationPage regPage = new RegistrationPage(getDriver());
		homePage.verifyHomePage();
		homePage.clickNewRegistration();
		regPage.verifyRegistraionPage();
		regPage.createAccount(dto);
		String actualErrorMessage = regPage.verifyErrorMessage();
		String expectedErrorMessage = "Password is too short (minimum is 8 characters)";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage , " Error message validation is failed.");
		String actualError = regPage.verifyErrorLocation();
		String expected = "user_password";
		Assert.assertEquals(actualError, expected , "Error validation is in wrong place");
		
	}
	
	public void testCreateAccount(){
		
	}
	//@Test
	public void testMandatoryEmail(){
		UserDTO dto = new UserDTO();
		dto.setUserName("test1");
		dto.setPassword("test1234");
		dto.setConfirm("test1234");
		dto.setFirstName("test1");
		dto.setLastName("test1");
		dto.setEmail("test");
		String url =envProps.getProperty("url") ;
		getDriver().get(url);
		HomePage homePage = new HomePage(getDriver());
		RegistrationPage regPage = new RegistrationPage(getDriver());
		homePage.verifyHomePage();
		homePage.clickNewRegistration();
		regPage.verifyRegistraionPage();
		regPage.createAccount( dto);
		
		String actualErrorMessage = regPage.verifyErrorMessage();
		String expectedErrorMessage = "Email is invalid";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage , " Error message validation is failed.");
		String actualError =regPage.verifyErrorLocation();
		String expected = "user_mail";
		Assert.assertEquals(actualError, expected , "Error validation is in wrong place");
		
	}
	
	
	//@Test(dataProvider="userdata")
	public void verifyCreateUser(UserDTO dto , String expectedErrorMessage){
		
		String url =envProps.getProperty("url") ;
		getDriver().get(url);
		HomePage homePage = new HomePage(getDriver());
		RegistrationPage regPage = new RegistrationPage(getDriver());
		homePage.verifyHomePage();
		homePage.clickNewRegistration();
		regPage.verifyRegistraionPage();
		regPage.createAccount( dto);
		
		String actualErrorMessage = regPage.verifyErrorMessage();
		
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage , " Error message validation is failed.");
	}
	
	@DataProvider(name="userdata")
	public Object[][] datap(){
		//First Combination
		UserDTO dto1 = new UserDTO();
		dto1.setUserName("test1");
		dto1.setPassword("test1234");
		dto1.setConfirm("test2341");
		dto1.setFirstName("test1");
		dto1.setLastName("test1");
		dto1.setEmail("test@gmail.com");
		String expectedErrorMessage1 = "Password doesn't match confirmation";
		
		//Second Combination
		
		UserDTO dto2 = new UserDTO();
		dto2.setUserName("test1");
		dto2.setPassword("test1");
		dto2.setConfirm("test1");
		dto2.setFirstName("test1");
		dto2.setLastName("test1");
		dto2.setEmail("test@gmail.com");
		String expectedErrorMessage2 = "Password is too short (minimum is 8 characters)";
		
		
		//Third Combination
		
		UserDTO dto3 = new UserDTO();
		dto3.setUserName("test1");
		dto3.setPassword("test1234");
		dto3.setConfirm("test1234");
		dto3.setFirstName("test1");
		dto3.setLastName("test1");
		dto3.setEmail("test");
		String expectedErrorMessage3 = "Email is invalid";
		
		Object[][] obj  = new Object[3][2];
		obj[0][0] = dto1;
		obj[0][1] = expectedErrorMessage1;
		obj[1][0] = dto2;
		obj[1][1] = expectedErrorMessage2;
		obj[2][0] = dto3;
		obj[2][1] = expectedErrorMessage3;
		
		return obj;
	}
	
	
	@DataProvider(name="userdata2")
	public Object[][] datap(){
		Object[][] obj =null;
		ExcelManager manager = new ExcelManager();
		HashMap<Integer , UserDTO> map=	manager.readExcel("D:\\selenium_classes\\user.xls");
		try{
		obj = new Object[map.size()][1];
		
		for (int i = 0; i < obj.length; i++) {
			
			obj[i][0] = map.get(i+1);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}
	
	@Test(dataProvider="userdata2")
	public void verifyCreateUser(UserDTO dto ){
		
		String url =envProps.getProperty("url") ;
		getDriver().get(url);
		HomePage homePage = new HomePage(getDriver());
		RegistrationPage regPage = new RegistrationPage(getDriver());
		homePage.verifyHomePage();
		homePage.clickNewRegistration();
		regPage.verifyRegistraionPage();
		regPage.createAccount( dto);
		String expectedErrorMessage = dto.getErrorMessage();
		String actualErrorMessage = regPage.verifyErrorMessage();
		
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage , " Error message validation is failed.");
	}
}
*/