package com.slokam.test.automation.testscripts.basic;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Ex {

	@Test
	public void colReader()throws Exception{
		FileInputStream fis = new FileInputStream("Data Files\\testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("data_Customers");
		
		int rowCount = sh.getLastRowNum();
		int colCount = sh.getRow(0).getLastCellNum();
		
		//int colNum=-1;
		
		for(int i=0;i<colCount;i++)
		{
			if(sh.getRow(0).getCell(i).getStringCellValue().equals("City"))
			{
				for(int j=1;j<rowCount;j++)
				{
					System.out.println(sh.getRow(j).getCell(i).getStringCellValue());
				}
			}
		}
	}
}
;