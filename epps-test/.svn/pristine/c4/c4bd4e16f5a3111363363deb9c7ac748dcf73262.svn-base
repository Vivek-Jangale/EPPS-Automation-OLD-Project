package com.epps.admin.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mx4j.log.Log;

/**
 * This class was created based on the A. K. Sahu Blog
 * http://aksahu.blogspot.hu/
 * 2014/08/data-driven-testing-in-selenium-webdriver-with
 * -testng-using-excel.html
 * 
 * Allows us the use of an Excel spreadsheet to provide input data to a test or
 * set of tests.
 * 
 */
public class ParsingExcel {
	private Workbook wb;
	private Sheet ws;

	/**
	 * Opens a excel sheet
	 * 
	 * @param fileName
	 *            name of the file where you want data
	 * @param sheetName
	 *            name of the sheet in the excel file
	 */
	public ParsingExcel(String fileName, String sheetName) {
		System.out.println(fileName);
		try {
			File file = new File(fileName);
			System.out.println(file.getAbsolutePath());
			if (fileName.indexOf("xlsx") < 0) { // for .xls format
				wb = new HSSFWorkbook(new FileInputStream(file));
				ws = wb.getSheet(sheetName);
			} else { // for .xlsx format
				wb = new XSSFWorkbook(fileName);
				ws = (XSSFSheet) wb.getSheet(sheetName);
			}
		} catch (IOException io) {
			throw new Error(
					"Invalid file '" + fileName + "' or incorrect sheet '" + sheetName + "', enter a valid one");
		}
	}

	/**
	 * Gets a cell value from the opened sheet
	 * 
	 * @param rowIndex
	 *            starting with 0 index
	 * @param columnIndex
	 *            starting with 0 index
	 * @return
	 */
	public String getCell(int rowIndex, int columnIndex) {
		String cellValue = null;
		try {
			cellValue = ws.getRow(rowIndex).getCell(columnIndex, Row.CREATE_NULL_AS_BLANK).toString();
		} catch (Exception e) {
			throw new Error(
					"The cell with row '" + rowIndex + "' and column '" + columnIndex + "' doesn't exist in the sheet");
		}
		return cellValue;
	}

	public int getNoOfRows() {
		// TODO Auto-generated method stub
		return ws.getPhysicalNumberOfRows();
	}

	public int getNoOfCols() {
		int numberOfCells = 0;
        Iterator rowIterator = ws.rowIterator();
        /**
         * Escape the header row *
         */
        if (rowIterator.hasNext())
        {
            Row headerRow = (Row) rowIterator.next();
            numberOfCells = headerRow.getPhysicalNumberOfCells();
        }
        return numberOfCells;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
		//use error instead of getLogger - future enhancement					
			Log.getLogger("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
}
