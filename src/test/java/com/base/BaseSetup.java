 /**************************************** PURPOSE **********************************

 - This class contains the code related to Basic setup of TestSuites such as Instantiating Browser,
 - Launching Browser from selected Configuration, perform Clean Up etc

USAGE
 - Inherit this BaseClass for any TestSuite class. You don't have to write any @Beforeclass and @AfterClass
 - actions in your TestSuite Classes
 
 - Example: 
 --import Com.Base
 --- public class <TestSuiteClassName> extends BaseSetup
*/
package com.base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.dataprovider.ConfigManager;
import com.slokam.test.automation.common.selenium.Sync;
import com.utilities.ReportSetter;
import com.utilities.TimeOuts;
import com.utilities.UtilityMethods;

public class BaseSetup implements TimeOuts
{
	private static WebDriver driver;
	
	private Logger log = Logger.getLogger("BaseClass");	

	ConfigManager sys = new ConfigManager();
	ConfigManager app = new ConfigManager("App");
	//ConfigManager test = new ConfigManager("TestDependency");
	ExtentReports extentReport;

	
	/**
	 * Getter method for WebDriver
	 * @return driver
	*/
    public static WebDriver getDriver() 
    {
        return driver;
    }

    /**
     * 
     * Setter method for WebDriver
     *
     * @param driver
     */
    public void setDriver(WebDriver driver) 
    {
        this.driver = driver;
    }
    
    /**
     * 
     * Creates folder structure to store the automation reports
     *
     * @throws Exception
     */
    @BeforeSuite
    public void beforeSuite() throws Exception
    {
				
			ReportSetter.getReportInstance();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			
			//isReportFolderCreated = false;
		
		log.info("<h2>--------------------SuiteRunner Log-------------------------<h2>");
    }
    
    /**
     * Method initialize() is declared as part of @BeforeClass
     * If BaseClass.java is inherited from any TestSuite class, the initialization will happen automatically
     * The initialization() process includes read the Browser name parameter from "Config.Properties" file and launch the selected browser and navigate to the given URL
     * @throws Exception
     */
    @Parameters("browserType")
    @BeforeClass (groups = { "regression" })
	public void initializeBaseSetup(@Optional("chrome") String browserType,ITestContext context)
	{
    	try
    	{
    		System.out.println("browserType = "+browserType);
	    	initiateDriver(browserType);
	    	log.info("Initiated Webdriver...");
	    	context.setAttribute("driver", driver);		
			driver.manage().window().maximize();
			
		
			(new Sync(driver)).setImplicitWait(IMPLICITWAIT);
    	}
    	catch (Exception e)
    	{		    		
       		log.error(e.getMessage() +"---"+UtilityMethods.getStackTrace());
    	}
	}



    /**
     * Purpose - to initiate driver based on the browser
     * @return - driver
     */
	public void initiateDriver(String browserType) 
	{		
		log.info("Browser name present in config file :" + browserType);		   				
		log.info("-----------------STARTED RUNNING SELENIUM TESTS ON LOCAL MACHINE------------------");
		setDriver(browserType);	
		
	}



	
	/**
	 * 
	 * This method sets the driver object based on browser name. If invalid browser name is passed, by default it'll set forefox browser
	 *
	 * @param browserType , Need to pass the browser type
	 */
	//String browerType="";
	private void setDriver(String browserType)
	{
		System.out.println("Browser value is ::"+ browserType);
		switch(browserType)
		{
			case "chrome":
				driver = ChromeBrowser.init();
				break;
			default:
				log.error("browser : "+browserType+" is invalid, Launching Firefox as browser of choice..");
				driver = FirefoxGeckoBrowser.init();
		}
			
	}
    
    /**
     * This method since added in "AfterClass" group and when this class is inherited from a TestSuite class, it will be called automatically
     * @throws Exception
     */
    @AfterClass //(groups = { "regression" },alwaysRun=true)
	public void CloseBrowser() throws Exception
	{       
    	if(driver != null)
    	{
    		driver.quit();
    	}
	}
    
    /**
     * 
     * This method adds Log file link to ReportNG report
     *
     * @throws Exception
     */
    @AfterSuite
    public void AddLogFileToReport() throws Exception
    {
    	ReportSetter.flushReport();
    	
    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    	/*
    	log.info("after suite");
    	String sSeperator =  UtilityMethods.getFileSeperator();    	
		String logFilePath = ".." + sSeperator + "Log.log"; 
		Reporter.log("<br>");
    	Reporter.log("<a class=\"cbutton\" href=\""+logFilePath+"\">Click to Open Log File</a>");
    	String PageLoadTimeSummaryFilePath = ".." + sSeperator + "PageLoadTime_Summary.html"; 
    	File f = new File(PageLoadTimeSummaryFilePath);
    	if(f.exists())
    	{
    		Reporter.log("<br>");
    		Reporter.log("<a class=\"cbutton\" href=\""+PageLoadTimeSummaryFilePath+"\">Click to Open PageLoad Time Summary File</a>");
    	}*/
    }
    

 


	

	


}
