package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.Test;

public class SmallestElementArray {

	int a[] = {5,7,3,1,0};

	//@Test
	public void small(){

		int size = a.length;
		int max=a[0];

		for(int i=0;i<size;i++){
			if(a[i]>max){
				max = a[i];
			}	

		}
		System.out.println(max);
	}
	
	@Test
	public void largestInArray(){
		int size = a.length;
		int min = a[0];
		
		for(int i=0;i<size;i++){
			if(a[i]<min){
				min = a[i];
			}
		}
		System.out.println(min);
	}
	
	//@Test
	public void secondLargestInArray(){
		int temp;
		int size = a.length; //5,7,3,1,0
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++){
				if(a[i]<a[j])
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}	
		}
		
		System.out.println(a[0]);
	}
	
	//public void smalles
}
