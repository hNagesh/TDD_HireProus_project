package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_07_LocationTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Equity.Performance_TC_05_WprProjectFieldValidationTest.Performance_TC_05_WprProjectFieldValidation" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_07_00_Location(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Importing Locations to Equity Project");

		try {
        rc.LocationImport(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	public void Performance_TC_07_01_AddLocation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Adding new location");
		try {
			rc.addLocation(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
}
