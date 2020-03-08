package com.slokam.test.automation.testscripts.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class RepeatedCharactersinString {

	String str = "STRESS";

	@Test(groups={"Collections","StringPrograms","Java"})
	public void b(){

		char[] chars = str.toCharArray();
		int size = chars.length;

		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();

		for(int i=0;i<=size-1;i++)
		{
			if(!hmap.containsKey(chars[i]))
			{
				hmap.put(chars[i], 1);
			}
			else
			{
				hmap.put(chars[i], hmap.get(chars[i])+1);
			}
		}
		
		System.out.println(hmap);
	
	
	/*for(int i=0;i<=size-1;i++){
		
		char k = str.charAt(i);
		if(hmap.get(k) ==1){
			System.out.println(hmap);
		}
		
	}*/
	
	}

}
