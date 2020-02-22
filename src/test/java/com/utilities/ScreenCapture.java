package com.utilities;


import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture  
{

	
	private static String fileSeperator = System.getProperty("file.separator");
	private static Logger log =Logger.getLogger("ScreenCapture");
	public ScreenCapture()
	{
		
	}

	/**
	 * Method to start the video capturing using monte screen recorder.
	 */
	
	/**
	 * 
	 * Method to rename the captured video with respective test case name.
	 *
	 */
	public static void renameCapturedVideoFile(String sVideoFileName)
	{
		try
		{
			File mediaFolder=new File(ReportSetup.getVideosPath());
			File[] files = mediaFolder.listFiles();
		    Arrays.sort(files, new Comparator<Object>()
		    {
		    public int compare(Object o1, Object o2) 
		    {
		    	//return new Long(((File)o1).lastModified()).compareTo(new Long(((File)o2).lastModified())); // for ascending order
		    	return -1*(new Long(((File)o1).lastModified()).compareTo(new Long(((File)o2).lastModified()))); //for descending order 
		    }
		    });
		    File oldfile = new File(ReportSetup.getVideosPath()+fileSeperator+files[0].getName());
		    File newfile = null;
		    if(!new File(ReportSetup.getVideosPath()+fileSeperator+sVideoFileName+".avi").exists())
		    {
		    	newfile = new File(ReportSetup.getVideosPath()+fileSeperator+sVideoFileName+".avi");
		    }
		    else
		    {
		    	newfile = new File(ReportSetup.getVideosPath()+fileSeperator+sVideoFileName+"(1).avi");
		    }
		    boolean isFileRenamed = oldfile.renameTo(newfile);
		    if(!isFileRenamed)
		    {
		    	log.error("check folder permissions of project folder..\n cannot rename a screen recording..");
		    }
		}
		catch(Exception e)
		{
			log.error("An exception occured while renaming captured video files"+e.getCause());
		}	
	}
   
	
	/**
	 * Purpose - This method takes the screenshot and returns the Screenshot path
	 * @param driver
	 * @return - Returns screen shot name and location
	 */
	public static String saveScreenShot(WebDriver driver)
	{
		try
		{
			log.info("Saving screenshot of current browser window");
	        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        String screenShotName = "Screenshot"+ UtilityMethods.getRandomNumber()+ ".png";
			File targetFile = new File(ReportSetup.getImagesPath(), screenShotName);
			//FileUtils.copyFile(screenshotFile,targetFile );
			//String path =  targetFile.getAbsolutePath();
			Files.copy(screenshotFile.toPath(), targetFile.toPath());
	    	log.info("Screenshot created and : "+ screenShotName);
			return screenShotName;		
	    }
	    catch(Exception e)
	    {
	        log.error("An exception occured while saving screenshot of current browser window.."+e.getCause());
	        return null;
	    }
	}


}

