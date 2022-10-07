package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_07_PortfolioScorecardTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_06_PortfolioLocationImportTest.TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_07_00_PortfolioBuildScorecard(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {

			portfolio.PortfolioBuildScorecard();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_07_PortfolioBuildScorecardTest.TC_07_PortfolioBuildScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_07_01_UploadFileInFeatureScorecard() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			portfolio.UploadFileinFeature("Meet Thresholds for Organic Gases");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_08_UploadFileInFeatureTest.TC_08_UploadFileInFeature" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_07_02_UploadFileInAudit() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {

			portfolio.UploadFileinFeature("Support Mindful Eating");

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test//(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_07_PortfolioBuildScorecardTest.TC_07_PortfolioBuildScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_07_03_UpdateUploadFileInAddedFeature() throws IOException {

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
