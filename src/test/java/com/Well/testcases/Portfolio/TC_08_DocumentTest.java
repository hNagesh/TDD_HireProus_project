package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_08_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_07_PortfolioScorecardTest.TC_07_02_UploadFileInAudit" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_11_Document() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {

			portfolio.clickDocument();
			portfolio.ValidatingLegalUploadDocument();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
