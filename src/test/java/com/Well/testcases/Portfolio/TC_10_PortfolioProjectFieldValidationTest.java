package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_10_PortfolioProjectFieldValidationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_05_PortfolioPaymentTest.TC_05_PortfolioPayment" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_14_PortfolioProjectFieldValidation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			portfolio.registerFieldValidationTest(SheetName, rowNum);	

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
