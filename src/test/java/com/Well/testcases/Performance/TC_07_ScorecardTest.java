package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_07_ScorecardTest extends BaseClass {


	@Test(dependsOnMethods = { "com.Well.testcases.Performance.TC_06_LocationTest.tc_06_LocationTest" })
	@Parameters({ "SheetName","rowNum" })
	public void tc_07_ScorecardTest(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
		performance.CompleteScorecardWprById(SheetName, rowNum);	
		performance.UploadWPRDocForFeature();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}