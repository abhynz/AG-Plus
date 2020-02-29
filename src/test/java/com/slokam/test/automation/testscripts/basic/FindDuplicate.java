package com.slokam.test.automation.testscripts.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class FindDuplicate {

	String str = "Java computer is where is Java";

	@Test(enabled = false)
	public void hashMapDuplicateCheck(){

		String arr[] = str.split(" ");
		int size = arr.length;
		Map<String,Integer> hmap = new HashMap<String,Integer>();

		for(String s:arr)
		{
			{
				if(hmap.get(s) == null)
				{
					hmap.put(s, 1);
				}
				else
				{
					hmap.put(s, hmap.get(s)+1);
				}
			}

		}
		
		System.out.println(hmap); //{Java=2, computer=1, is=2, where=1}
		
		for(Map.Entry<String, Integer> entry: hmap.entrySet()){
			if(entry.getValue()>1){
				System.out.println(" ------ Duplicate value is :: "+entry.getKey());
			}
		}
		
		
	}
	
	
	@Test
	public void findDups(){
		String arr[] = str.split(" ");

		Set<String> store = new HashSet<String>();
		for(String s:arr){
			if(store.add(s)==false){
				System.out.println(s);
			}
		}
	}
}


