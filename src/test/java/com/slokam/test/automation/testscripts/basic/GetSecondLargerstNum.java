package com.slokam.test.automation.testscripts.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.testng.annotations.Test;

public class GetSecondLargerstNum {

	//@Test
	public void getsec(){

		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(3);
		ar.add(9);
		ar.add(1);
		ar.add(7);
		ar.add(8);
		ar.add(2);
		ar.add(3);
		ar.add(5);

		Collections.sort(ar);
		System.out.println("Sorted ASC "+ar);
		
		Collections.sort(ar,Collections.reverseOrder());
		System.out.println("Sorted DESC "+ar);
		
		System.out.println(ar.get(1));
		
	}
	
	//@Test
	public void getSec1(){
		ArrayList<Integer> ar = new ArrayList<Integer>();
		Set<Integer> t = new HashSet<Integer>();
		ar.add(3);
		ar.add(2);
		ar.add(3);
		ar.add(5);
		ar.add(4);
		ar.add(1);
		
		Collections.sort(ar);
		System.out.println("ASCENDING ORDER LIST :: "+ar);
		
		Collections.sort(ar,Collections.reverseOrder());
		System.out.println("DESCENDING ORDER LIST :: "+ar);
		
		t.addAll(ar);
		System.out.println("SET INSERTION :: "+ar);
		
		
	}
	
	@Test
	public void hm(){
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("Apple","kol");
		hmap.put("banana","def");
		hmap.put("Apple","dfrg");
		
		System.out.println(hmap.get("Apple"));
	}


}
