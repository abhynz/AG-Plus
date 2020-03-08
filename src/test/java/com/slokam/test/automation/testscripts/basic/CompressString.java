package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.Test;

public class CompressString {

	@Test
	public void comp()
	{
		String str = "aaabbccc";  //a3b2c3
		char chars[] = str.toCharArray();
		int size =chars.length;

		int count=0;
		
		for(int i=0;i<size;i++)
		{
			if(chars[i]==chars[i+1])
			{
				count++;
				System.out.println("Character :: "+chars[i]+count++);
			}
			
		}
		
		//System.out.println();

	}
}
