package com.slokam.test.automation.testscripts.basic;

import org.testng.annotations.Test;

public class Segregate0n1Main {

	@Test
	public void seperator(){
		/*int a[] = {1,0,1,0,1,0,1,0,0};
		int count=0;
		int size = a.length;

		for(int i=0;i<size;i++){
			if(a[i]==0){
				count++;
			}
		}
		System.out.println(" Count of 0 ::"+count);

		for(int j=0;j<count;j++){
			a[j]=0;
			System.out.print(a[j]);
		}

		for(int k=count;k<size;k++){
			a[k]=1;
			System.out.print(+a[k]);
		}
*/
		
		
	
		int a[]={1,2,0,2,0,1,1,0,2,1,1,0,2,2,2};
		int size = a.length;
		System.out.println("Size ::"+size);
		
		int iCount=0, jCount=0;
		for(int i=0;i<size;i++){
			if(a[i]==0){
				iCount++;
			}
			if(a[i]==1){
				jCount++;
			}		
		}
		
		System.out.println("Value of iCount ::"+iCount); // 4
		System.out.println("Value of jCount ::"+jCount); //5
		
		for(int i=0;i<iCount;i++){
			a[i]=0;
			
			//System.out.print(a[i]);
		}
		
		int secondRemSize = size-iCount; //15-4 = 11
		for(int k=iCount;k<secondRemSize;k++){
			a[k]=1; 
			//System.out.print(a[k]);//6
		}
		
		
		int thridRemSize = iCount+jCount;
		System.out.println("thrid size :: "+thridRemSize);
		
		for(int i=thridRemSize;i<size;i++){
			a[i]=2;
			//System.out.print(a[i]);
		}
		
		for(int i=0;i<size;i++){
		System.out.print(a[i]);
		}
	}
}
