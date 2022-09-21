package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_12_ReviewTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Portfolio.TC_09_UploadFileInAuditTest.TC_09_UploadFileInAudit" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_12_Review(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			portfolio.ReviewDocument(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
