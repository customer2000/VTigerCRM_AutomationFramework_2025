package practice.amazon.producttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterLog {
	@Test
	public void invoice1Test()
	{
		Reporter.log("Step-1");
		Assert.assertEquals("Home","Home Page");
		Reporter.log("Step-2");
		Reporter.log("Step-3");
	}
	@Test
	public void invoice2Test()
	{
		Reporter.log("Step-1");
		Reporter.log("Step-2");
		Reporter.log("Step-3");
	}
	
	/*
	 * @Test public void invoice1Test() { System.out.println("Step-1");
	 * Assert.assertEquals("Home","Home Page"); System.out.println("Step-2");
	 * System.out.println("Step-3"); }
	 * 
	 * @Test public void invoice2Test() { System.out.println("Step-1");
	 * System.out.println("Step-2"); System.out.println("Step-3"); }
	 */
}
