package com.vtiger.crm.generic.testngutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider
	public Object[][] setDataIntoDataProvider() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/VTiger.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("organizations");
        DataFormatter formatter = new DataFormatter();
        int lastRow=sheet.getLastRowNum();
        int lastCell=0;
        for(int i=0;i<=lastRow;i++)
        {
        	int temp=sheet.getRow(i).getLastCellNum();
        	if(temp>lastCell)
        	{
        		lastCell=temp;
        	}
        }
        System.out.println("Arguments to be passed: "+lastCell);
        Object[][] obj=new Object[lastRow+1][lastCell];
        for(int j=0;j<=lastRow;j++)
        {
        	for(int k=0;k<lastCell;k++)
        	{
        		try {
        			
        			obj[j][k]=formatter.formatCellValue(sheet.getRow(j).getCell(k));
        		}
        		catch(Exception e){}
        	}
        }
		return obj;
     }
//	@DataProvider
//	public Object[][] setDataIntoDataProvider(String URL, String sheetName) throws EncryptedDocumentException, IOException
//	{
//		FileInputStream fis=new FileInputStream(URL);
//        Workbook workbook = WorkbookFactory.create(fis);
//        Sheet sheet=workbook.getSheet(sheetName);
//        int lastRow=sheet.getLastRowNum();
//        int lastCell=0;
//        for(int i=0;i<=lastRow;i++)
//        {
//        	int temp=sheet.getRow(i).getLastCellNum();
//        	if(temp>lastCell)
//        	{
//        		lastCell=temp;
//        	}
//        }
//        DataFormatter f = new DataFormatter();
//        System.out.println(lastCell);
//        Object[][] obj=new Object[lastRow][lastCell];
//        for(int j=0;j<=lastRow;j++)
//        {
//        	for(int k=0;k<lastCell;k++)
//        	{
//        		try {
//        			
//        			obj[j][k]=f.formatCellValue(sheet.getRow(j).getCell(k));
//        		}
//        		catch(Exception e){}
//        	}
//        }
//		return obj;
//        
//     }
}
