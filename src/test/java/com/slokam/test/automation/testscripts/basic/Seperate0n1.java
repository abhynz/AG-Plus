package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.Test;

public class Seperate0n1 {

	int a[] = {1,0,0,1,1,0};

	@Test
	public void seperator(){
		int size = a.length;
		System.out.println(size);

		int zero = a[0];
		int temp ;
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++){
				if(a[i]<zero)
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					
				}
			}
		}
		
		for(int k=0;k<a.length;k++){
			System.out.print(a[k]);
		}
		
	
		
	}
}
