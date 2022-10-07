package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_07_ScorecardTest extends BaseClass {


	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_06_LocationTest.Performance_TC_06_Location" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_00_CompleteScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
		performance.CompleteScorecardWprById(SheetName, rowNum);	
	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_00_CompleteScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07_01_UploadDocumentScorecard(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
		performance.UploadWPRDocForFeature();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
