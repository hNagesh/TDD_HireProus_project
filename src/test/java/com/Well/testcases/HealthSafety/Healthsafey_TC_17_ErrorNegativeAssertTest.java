package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_17_ErrorNegativeAssertTest extends BaseClass {

	@Test
	@Parameters({ "SheetName", "rowNum" })
	public void Healthsafey_TC_17_ErrorNegativeAssert(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Error Negative Assert Validation");
		
        try {
			rc.errorMessageNegativeAssert();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
