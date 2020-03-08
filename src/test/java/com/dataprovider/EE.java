package com.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class EE {

	String m;
	
	@Test
	public void reader() throws Exception{
		
		FileInputStream fis = new FileInputStream("Data Files\\testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		
		int rowCount = sh.getLastRowNum();
		int colCount = sh.getRow(0).getLastCellNum();
		
		int colNum =-1;
		for(int i =0;i<colCount;i++){
			if( sh.getRow(0).getCell(i).toString().equalsIgnoreCase("City")){
				colNum =i;
			}
		}
		
		
		for(int j=0;j<rowCount;j++)
		{
			m = sh.getRow(j).getCell(colNum).getStringCellValue();
			System.out.println(m);
		}
		
		
		
		
		
			/*for(int j=0;j<colCount;j++){
				
				String k = sh.getRow(0).getCell(j).toString();
				if(k.equalsIgnoreCase("City")){
					 for(int l =0;l<rowCount;l++){
						  m =sh.getRow(l).getCell(j).toString();
					 }
				}
			
		}
		*/
		//System.out.println(m);
		
	}
}
