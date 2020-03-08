package com.slokam.test.automation.testscripts.basic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TT {

	
	@Test
	public static char maximumOccurringCharacter(String text) {
	    char[] chars = text.toCharArray();
	    int size = chars.length;

	    HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
	    for(Character ch:chars)
	    {
	        if(hmap.get(ch)==null){
	            hmap.put(ch, 1);
	        }
	        else
	        {
	            hmap.put(ch, hmap.get(ch)+1);
	        }
	    }

	    char k =' ';
	    System.out.println(hmap);
	    int max = Collections.max(hmap.values());

	    for(Map.Entry<Character,Integer> entry : hmap.entrySet()){
	        
	    	if (entry.getValue()==max) {
	    		 k = entry.getKey();
	            
            }
	    }

	    return k;
	    

	    }
	
	@Test
	public void run(){
		char s = maximumOccurringCharacter("stress");
		System.out.println(s);
	}

	}

