package com.vtiger.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String getDataFromExcelFile(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/VTiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String data = null;
		try {
		data=book.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		catch(Exception e){}
		
		return data;
	}
	public String getDataFromExcelFile(String URL, String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(URL);
		Workbook book=WorkbookFactory.create(fis);
		String data = null;
		try {
		data=book.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		catch(Exception e){}
		
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/VTiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		int rowCount=book.getSheet(sheetName).getLastRowNum();
		
		return rowCount;
	}
	
	public int getRowCount(String URL, String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(URL);
		Workbook book=WorkbookFactory.create(fis);
		int rowCount=book.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	
	public void setDataIntoExcelFile(String sheetName, int rowNum, int colNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/VTiger.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(rowNum).createCell(colNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./testData/VTiger.xlsx");
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
	}
	public void setDataIntoExcelFile(String URL, String sheetName, int rowNum, int colNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(URL);
		Workbook book=WorkbookFactory.create(fis);
		book.getSheet(sheetName).createRow(rowNum).createCell(colNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(URL);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
	}
	public void getAllDataFromExcel(String URL) throws IOException
	{
		FileInputStream fis=new FileInputStream(URL);
        Workbook workbook = WorkbookFactory.create(fis);
    	DataFormatter formatter=new DataFormatter();
        // Loop through all sheets
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
        Sheet sheet = workbook.getSheetAt(i);
        System.out.println("Sheet Name: " + sheet.getSheetName());

            // Loop through all rows
            for (Row row : sheet) {
                // Loop through all cells
                for (Cell cell : row) {
                	String value=formatter.formatCellValue(cell);
                	if(value.isBlank()||value==null)
                		{System.out.print("\t");}
                	else
                    	{System.out.print(value+" \t ");}
                }
                System.out.println();
            }
            System.out.println("--------------------------------------------------");
        }
        
        workbook.close();
        fis.close();
	}
	
	public void clearAllDataFromExcel(String URL) throws IOException
	{
		FileInputStream fis=new FileInputStream(URL);
        Workbook workbook = WorkbookFactory.create(fis);

        // Loop through all sheets
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
        Sheet sheet = workbook.getSheetAt(i);
        System.out.println("Sheet Name: " + sheet.getSheetName());

            // Loop through all rows
            for (Row row : sheet) {
                // Loop through all cells
                for (Cell cell : row) {
                	cell.setCellValue("");;
         FileOutputStream fos=new FileOutputStream(URL);
         workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
		}
        }}}
}
