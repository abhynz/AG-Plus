package com.slokam.test.automation.testscripts.basic;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class ReplaceWhiteSpaceinString {
	
	String str = "abc def ghi";
	
	//@Test
	public void a(){
		
		String str2 = str.replace(" ", "");
		System.out.println(str2);
	}
	
	@Test
	public void b(){
		
		String[] s = str.split(" ");
		int size = s.length-1;
		
		for(int i=0;i<=size;i++){
		System.out.print(s[i]);
		}	
		
	}

}
