package com.Well.testcases.Faculty;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Faculty_TC_09_FacultyKeepLearningTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "SheetName","rowNum" })
	public void Faculty_TC_09_FacultyKeepLearning(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);
		try {
			faculty.keepLearingCardValdationFaculty();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}