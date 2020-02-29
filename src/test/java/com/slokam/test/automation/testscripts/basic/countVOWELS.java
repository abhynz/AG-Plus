package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.Test;

public class countVOWELS {

	String str = "abhi on desk but we do";
	
	@Test
	public void a(){
		char chars[] = str.toCharArray();
		int size = chars.length;
		
		int vowelCounter=0;
		int constanceCounter=0;
		for(int i=0;i<size;i++)
		{
			if(chars[i]=='a'||chars[i]=='e'||chars[i]=='i'||chars[i]=='o'||chars[i]=='u'){
				vowelCounter++;
			}
			else
			{
				constanceCounter++;
			}
		}
		
		System.out.println("Vowels are ::"+vowelCounter);
		System.out.println("Constance are ::"+constanceCounter);
	}
}
