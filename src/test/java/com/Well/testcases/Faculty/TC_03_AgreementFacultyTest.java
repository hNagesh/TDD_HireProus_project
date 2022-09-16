package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_03_AgreementFacultyTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Faculty.TC_02_RegisterFacultyTest.TC_02_RegisterFaculty" })
	@Parameters({ "SheetName","rowNum" })
	public void tc_03_AgreementFacultyTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			faculty.AgreementFaculty(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
