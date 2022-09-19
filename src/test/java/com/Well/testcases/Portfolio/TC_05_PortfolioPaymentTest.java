package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_05_PortfolioPaymentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_04_SignAndSubscribePortfolioTest.TC_04_SignAndSubscribePortfolio" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_05_PortfolioPayment(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			portfolio.PortfolioClickOnBilling();
			portfolio.PortfolioCardPayment(SheetName, rowNum);
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
