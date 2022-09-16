package com.Well.testcases.Exam;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_04_BillingV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Exam.TC_03_EnrollExamTest.tc_03_EnrollExamTest" })
	@Parameters({ "SheetName","rowNum" })
	public void tc_04_BillingV2ProjectTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		exam.BillingExam(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
