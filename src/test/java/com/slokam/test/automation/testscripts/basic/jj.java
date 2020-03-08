package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.Test;

public class jj {

	@Test
	public void opentext() {
	     
	     String str = "opentext internship program";
	     String[] s = str.split(" ");
	     int size = s.length;
	     int count = 0;
	     for(int i=0;i<size;i++){
	         char chars[]= s[i].toCharArray();
	         for(int j=0;j<chars.length;j++)
	         {
	        	 
	             if(chars[j]=='a'||chars[j]=='e'||chars[j]=='i'||chars[j]=='o'||chars[j]=='u')
	             {
	            	 System.out.println("Character J ::"+chars[j+1]);
	            	 if(chars[j+2]=='a'||chars[j+2]=='e'||chars[j+2]=='i'||chars[j+2]=='o'||chars[j+2]=='u')
	            	 {
	            		 System.out.println("Character J+1 ::"+chars[j+1]);
	            		 System.out.println(chars[j]);
	            		 count++;
	            	 }
	            	 
	             }
	             
	         }
	         
	         System.out.println(count);
	         
	         
	     }

	    }
}
