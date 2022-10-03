package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_17_EditV2ProjectTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.V2Project.TC_13_PerformanceReviewV2ProjectTest.TC_13_PerformanceReviewV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_17_EditV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		v2project.editAndValidateProjectInformationV2Project(SheetName, rowNum);
		v2project.editAndValidateOwnerInformationV2Project(SheetName, rowNum);
		v2project.editAndValidateAddressV2Project(SheetName, rowNum);
		v2project.editAndValidateAdminV2Project(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
