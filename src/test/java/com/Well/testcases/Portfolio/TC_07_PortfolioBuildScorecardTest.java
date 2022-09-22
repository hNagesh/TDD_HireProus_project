package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_07_PortfolioBuildScorecardTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_06_PortfolioLocationImportTest.TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_07_PortfolioBuildScorecard(String SheetName,int rowNum) throws IOException {

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
}
