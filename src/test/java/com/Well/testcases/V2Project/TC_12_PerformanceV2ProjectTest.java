package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_12_PerformanceV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.TC_11_HealthSafetyReviewV2ProjectTest.tc_11_HealthSafetyReviewV2ProjectTest" })
	@Parameters({ "SheetName","rowNum" })
	public void tc_12_PerformanceV2ProjectTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		v2project.performanceV2Project(SheetName, rowNum);	
		v2project.uploadPerformanceDocV2Project();	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
