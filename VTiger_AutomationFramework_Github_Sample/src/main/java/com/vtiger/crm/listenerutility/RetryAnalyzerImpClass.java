package com.vtiger.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpClass implements IRetryAnalyzer{
	int count=1;
	int max_count=2;
	@Override
	public boolean retry(ITestResult result) {
		if(count<=max_count)
		{
			count++;
			return true;
		}
		return false;
	}

}
