package practice.amazon.producttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.crm.basetest.BaseClass;

@Listeners(com.vtiger.crm.listenerutility.ListenerImpClass.class)
public class InvoiceTest_Listeners extends BaseClass{
	@Test
	public void invoice1Test()
	{
		System.out.println("Step-1");
		Assert.assertEquals("Home","Home Page");
		System.out.println("Step-2");
		System.out.println("Step-3");
	}
	@Test
	public void invoice2Test()
	{
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
	}
}
