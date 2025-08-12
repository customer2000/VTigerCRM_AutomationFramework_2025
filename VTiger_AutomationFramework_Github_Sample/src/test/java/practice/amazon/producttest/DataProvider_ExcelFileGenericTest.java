package practice.amazon.producttest;

import java.io.IOException;

import org.testng.annotations.Test;

public class DataProvider_ExcelFileGenericTest {
	@Test  (dataProviderClass =com.vtiger.crm.generic.testngutility.DataProviderUtility.class, dataProvider="setDataIntoDataProvider") 
	public void sampleTest( String a, String b, String c, String d ) throws IOException
	{
//		ExcelFileUtility ELib=new ExcelFileUtility();
//		ELib.getAllDataFromExcel("./testData/VTiger.xlsx");
		System.out.print(a+"\t"+b+"\t"+c+"\t"+d);
		System.out.println();
	}
}
