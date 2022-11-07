package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_08_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15_AddLocationTest.Portfolio_TC_15_AddLocation" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_08_Document() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Type Legal Upload Document");

		try {

			portfolio.clickDocument();
			portfolio.ValidatingLegalUploadDocument();
			portfolio.ValidatingAuditUploadDocument();
			portfolio.ValidatingFeatureUploadDocument();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
