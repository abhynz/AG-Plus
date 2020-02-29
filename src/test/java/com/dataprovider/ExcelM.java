package com.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelM {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	XSSFRow row;
	String s = null;


	public void readExcel(String Filename,String Sheetname) throws IOException{
		fis = new FileInputStream(Filename);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(Sheetname);

		int rowCount = sh.getLastRowNum();
		System.out.println("RowCount is :: "+rowCount);
		int colCount = sh.getRow(0).getLastCellNum();
		System.out.println("ColumnCount is :: "+colCount);

		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String s =sh.getRow(i ).getCell(j).getStringCellValue();		
				System.out.println(s);
			}
		}

	}

	@Test
	public void run() throws IOException{
		readExcel("Data Files\\testdata.xlsx","data_Customers");
	}
}
