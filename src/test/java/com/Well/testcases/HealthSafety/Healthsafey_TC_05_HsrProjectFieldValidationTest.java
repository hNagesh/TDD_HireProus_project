package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_05_HsrProjectFieldValidationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_04_SearchHealthSafetyByIdTest.Healthsafey_TC_04_SearchHealthSafetyById" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_05_HsrProjectFieldValidation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		hsr.HsrProjectFieldValidationTest(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
