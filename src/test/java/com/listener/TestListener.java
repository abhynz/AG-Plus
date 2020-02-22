package com.listener;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import com.aventstack.extentreports.Status;
import com.base.BaseSetup;
import com.dataprovider.ConfigManager;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.utilities.ReportSetter;
import com.utilities.ReportSetup;
import com.utilities.ReportTestListner;
import com.utilities.ScreenCapture;
import com.utilities.UtilityMethods;
import com.testng.Assert;

public class TestListener extends TestListenerAdapter
{

	private  static char cQuote = '"';
	ConfigManager sys = new ConfigManager();
	ConfigManager depend = new ConfigManager("TestDependency");
	private  static String fileSeperator = System.getProperty("file.separator");
	Logger log =Logger.getLogger("TestListener");

	ReportSetter extent;





	/**
	 * Method to capture screenshot for allure reports
	 * @param driver , need to pass the driver object
	 * @return , returns the captured image file in the form of bytes
	 */
	@Attachment(value="Screenshot",type = "image/png")
	private byte[] createAttachment(WebDriver driver)
	{
		try
		{
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}
		catch(Exception e)
		{
			log.error("An exception occured while saving screenshot of current browser window from createAttachment method.."+e.getCause());
			return null;
		}
	} 

	public void test()
	{

	}

	/**
	 * This method will be called if a test case is skipped. 
	 * 
	 */
	public void onTestSkipped(ITestResult result)
	{			
		log.warn("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );
		log.warn("WARN ------------"+result.getName()+" has skipped-----------------" );
		log.warn("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );			


	}



	/**
	 * This method will be called before a test case is executed. 
	 * Purpose - For starting video capture and launching balloon popup in ReportNG report 
	 */
	public void onTestStart(ITestResult result)
	{
		log.info("<h2>**************CURRENTLY RUNNING TEST************ "+result.getName()+"</h2>" );

		ReportTestListner.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		ReportTestListner.getExtentTest().info(result.getMethod().getMethodName() + "STARTED ---- ");
	}

	/**
	 * This method will be called if a test case is passed. 
	 * Purpose - For attaching captured videos in ReportNG report 
	 */
	public void onTestSuccess(ITestResult result)
	{
		ReportTestListner.getExtentTest().log(Status.PASS, "Testcase Passed");
	}

	/**
	 * This method will be called if a test case is failed. 
	 * Purpose - For attaching captured screenshots and videos in ReportNG report 
	 */
	public void onTestFailure(ITestResult result)
	{
		log.error("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" );
		log.error("ERROR ----------"+result.getName()+" has failed-----------------" );
		log.error("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n" );

		//eportTestListner.getExtentTest().log(Status.FAIL, "Testcase Failed :: "+result.getThrowable().getMessage(),ScreenCapture.saveScreenShot(BaseSetup.getDriver()));
		
		
	}



}
