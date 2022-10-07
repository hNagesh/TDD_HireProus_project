package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_07_ScorecardTest extends BaseClass {


	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_06_LocationTest.Healthsafey_TC_06_Location" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_07_00_CompleteScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
		hsr.CompleteScorecardHsrById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_07_ScorecardTest.Healthsafey_TC_07_00_CompleteScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_07_01_UploadScorecardDocument(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
		hsr.UploadHsrDocForFeature();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
