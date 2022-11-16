package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_09_DocumentTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_06_WerProjectFieldValidationTest.Equity_TC_06_WerProjectFieldValidation" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_09_Document(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Upload Document in Document");

		try {
			performance.clikOnDocumentLibrary();
			performance.validateGeneralUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	
	
}
