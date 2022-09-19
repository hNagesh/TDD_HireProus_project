package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_06_PortfolioLocationImportTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_05_PortfolioPaymentTest.TC_05_PortfolioPayment" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_06_PortfolioLocationImport(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {

			portfolio.PortfolioLocationImport(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
