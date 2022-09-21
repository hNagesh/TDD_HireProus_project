package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_10_UpdateUploadFileInAddedFeatureTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_07_PortfolioBuildScorecardTest.TC_07_PortfolioBuildScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_10_UpdateUploadFileInAddedFeature() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			//portfolio.UpdateUploadFileinAddedFeature("Meet Thresholds for Organic Gases");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
