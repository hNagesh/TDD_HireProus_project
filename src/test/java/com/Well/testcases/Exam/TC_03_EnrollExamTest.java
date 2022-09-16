package com.Well.testcases.Exam;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_03_EnrollExamTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Exam.TC_02_RegisterExamTest.TC_02_RegisterExam" })
	@Parameters({ "SheetName","rowNum" })
	public void tc_03_EnrollExamTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			exam.EnrollExam(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
