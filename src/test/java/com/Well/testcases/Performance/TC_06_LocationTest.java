package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_06_LocationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.TC_05_AgreementSignTest.tc_05_AgreementSignTest" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_06_Location(String SheetName,int rowNum) throws IOException {

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
