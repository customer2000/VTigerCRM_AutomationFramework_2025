package com.vtiger.crm.listenerutility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationImpClass implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.vtiger.crm.listenerutility.RetryAnalyzerImpClass.class);
	}
	
	

}
