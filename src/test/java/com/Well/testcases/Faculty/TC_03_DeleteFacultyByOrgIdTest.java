package com.Well.testcases.Faculty;

import java.io.IOException;


import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_03_DeleteFacultyByOrgIdTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test

	public void tC_03_DeleteFacultyByOrgIdTest() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {

			faculty.POSTRequest();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
