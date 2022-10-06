package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_05_BulkDeleteTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test//(dependsOnMethods = { "com.Well.testcases.Faculty.TC_04_SubmitReviewTest.TC_04_SubmitReview" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_05_BulkDelete(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
			faculty.PostRequestAuthenticate();
			faculty.DeleteFacultyOrMembership();
			testlog.pass("**Verifies Bulk Delete successfully**");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
