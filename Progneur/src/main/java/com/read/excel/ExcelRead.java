package com.read.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;





public class ExcelRead {

	
	  public FileInputStream fis = null;
	    public static XSSFWorkbook workbook = null;
	    public static XSSFSheet sheet = null;
	    public static XSSFRow row = null;
	    public static XSSFCell cell = null;
	
	
	
	
	public static String[][] readData(String no) throws IOException, BiffException{
		FileInputStream fis = new FileInputStream("src/test/java/resources/ReadData.xls");
		Workbook book = Workbook.getWorkbook(fis);
		Sheet sheet = book.getSheet(no);
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		String testData[][] = new String[rows - 1][columns];
		int count = 0;
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				jxl.Cell cell = sheet.getCell(j, i);
				testData[count][j] = cell.getContents();
			}
			count++;
		}
		fis.close();
		return testData;

 

		 
	}

	
	
	
	
	
}
