package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxGeckoBrowser {

	static WebDriver driver;
	Logger log = Logger.getLogger("FirefoxGeckoBrowser");

	public static WebDriver init(){
		System.err.println("Triggering GeckoDriver");
		System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;

	}
}
