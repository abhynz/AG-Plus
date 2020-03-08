package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ReportTestListner {

	private static ExtentReports extent = ReportSetter.getReportInstance();
	static ExtentTest test;
	
	public static ExtentTest createTest(String name, String desc){
		test = extent.createTest(name,desc);
		return test;
	}
	
	public static ExtentTest getExtentTest(){
		return test;
		
		//added commentS
		
	}
}
