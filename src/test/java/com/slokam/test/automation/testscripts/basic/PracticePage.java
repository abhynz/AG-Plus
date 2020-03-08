package com.slokam.test.automation.testscripts.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class PracticePage {

	WebDriver driver;
	
	@FindBy(id="button1")
	WebElement Btn_newBrowserWindow;
	
	public void init(){
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
	}
	


	
	@Test
	public void msgWin()
	{
		init();
		System.out.println("Main window title :: "+driver.getTitle());
		WebDriverWait Wait = new WebDriverWait(driver, 30);
		Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='New Message Window']")));
				
				
				
		System.out.println("Wait Over");
		
		driver.findElement(By.xpath("//button[text()='New Message Window']")).click();
		String mainWin = driver.getWindowHandle();
		Set<String> al =driver.getWindowHandles();
		Iterator<String> itr = al.iterator();
		while(itr.hasNext())
		{
			String childWin = itr.next();
			if(!mainWin.equals(childWin))
			{
			
			System.out.println("Child window :: " +driver.switchTo().window(childWin));
			//System.out.println(driver.getTitle());
			driver.close();
			System.out.println("CLOSED");
			}
		}
		
		System.out.println(driver.switchTo().window(mainWin));
		System.out.println(driver.getTitle());
		driver.close();
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target)
		
	}
	
	public void alertHandle()
	
	
}
