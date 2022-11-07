package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_04_SearchHealthSafetyByIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_03_SubscribeAndStoreIdTest.Healthsafey_TC_03_01_StoreId" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_04_SearchHealthSafetyById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Enrollment Search list Functionality");

		try {
     hsr.SearchHealthSafetyByID(SheetName,rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
