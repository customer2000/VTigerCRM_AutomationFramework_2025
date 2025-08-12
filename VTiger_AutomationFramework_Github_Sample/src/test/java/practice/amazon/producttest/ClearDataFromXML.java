package practice.amazon.producttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.vtiger.crm.generic.fileutility.ExcelFileUtility;

public class ClearDataFromXML {
	@Test
	public void addProductInfoTest() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility ELib=new ExcelFileUtility();
		try {
			ELib.clearAllDataFromExcel("./testData/Amazon.xlsx");
			}catch(Exception e) {}	}
}
