package com.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelFeeder {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	XSSFRow row;
	XSSFCell cell;
	int colNum=-1;
	String fl = "Data Files\\testdata.xlsx";
	String sheet = "data_Customers";

	public XSSFSheet readFile(String file, String sheetname) throws Exception{
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheetname);
		return sh;
	}

	public int rowCount(String file,String sheetname) throws Exception{
		readFile(file,sheetname);
		int noOfRows = sh.getLastRowNum();
		return noOfRows;	
	}

	public int colCount(String file,String sheetname) throws Exception{
		readFile(file,sheetname);
		int noOfCols = sh.getRow(0).getLastCellNum();
		return noOfCols;	
	}



	//@Test
	public String getcelldata(String file,String sheetName, int rowNum, String columName) throws Exception{

		int colNum = 0;
		sh = readFile(file,sheetName);
		int rows = rowCount(file,sheetName);
		int cols = colCount(file,sheetName);

		for(int i=0;i<cols;i++){
			if(sh.getRow(0).getCell(i).getStringCellValue().trim().equals(columName)){
				colNum = i;
			}
		}
		XSSFCell cell = sh.getRow(rowNum).getCell(colNum);
		switch(cell.getCellType())
		{
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
			
		case STRING:
			return String.valueOf(cell.getStringCellValue());
		}

		return null;

	}
	
	
	@DataProvider
	public Object[][] getcelldata(String file, String sheetname) throws Exception{
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheetname);
		//XSSFCell cell;
		int rowCount = sh.getLastRowNum()-1;
		System.out.println("00000000000 :: "+rowCount);
		int colCount = sh.getRow(0).getLastCellNum();
		System.out.println("00000000000 :: "+colCount);
		
		Object[][] data = new Object[rowCount][colCount];
		
		for(int i=1;i<rowCount;i++){
			for(int j=1;i<colCount;j++){
				data[i][j] = sh.getRow(i).getCell(j);
				 cell = sh.getRow(i).getCell(j);
				 

				switch(cell.getCellType()){
				case NUMERIC:
					data[i][j] = cell.getNumericCellValue();
					System.out.println("Num Value is :: "+data);
					return data;
					
				case STRING:
					
					data[i][j] = cell.getStringCellValue();
					System.out.println("String Value is :: "+data.toString());
					return data;
				}
				}
			}
		
		return null;
		
	}
	
	public void ab(String one,String two, String three, String four, String five, String six){
		System.out.println(" Excel value is :: "+ one +two+three+four+five+six);
	}
	
	@Test(dataProvider = "getcelldata")
	public void run(String a, String b,String c,String d,String e,String f) throws Exception{
		
		ab(a,b,c,d,e,f);
	}


}
