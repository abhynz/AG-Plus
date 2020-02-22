package com.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportSetter {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest test;
	
	public static ExtentReports createReportInstance(){

		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/AutomationReports/ExecutionReport.html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.out.println("$$$$  EXTENT report attached");
		return extent;
	}

	public static ExtentReports getReportInstance(){
		if(extent == null){
			createReportInstance();
		}

		return extent;
	}
	
	public static ExtentTest getReportTest(){
		return test;
	}
	
	public static void flushReport(){
		extent.flush();
		
	}


}
