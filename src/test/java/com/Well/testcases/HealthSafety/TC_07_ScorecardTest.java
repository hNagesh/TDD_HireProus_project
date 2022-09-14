package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_07_ScorecardTest extends BaseClass {


	@Test
	@Parameters({ "SheetName","rowNum" })
	public void tc_07_ScorecardTest(String SheetName,int rowNum) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
		hsr.CompleteScorecardHsrById(SheetName, rowNum);	
		hsr.UploadHsrDocForFeature();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}