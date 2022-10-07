package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_03_SubscribeAndStoreIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_02_RegisterHealthSafetyTest.Healthsafey_TC_02_RegisterHealthSafety" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_03_00_SubscribeAndStoreId(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);

		try {
			rc.Billing(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_03_SubscribeAndStoreIdTest.Healthsafey_TC_03_00_SubscribeAndStoreId" })
		@Parameters({ "SheetName","rowNum" })
		public void Healthsafey_TC_03_01_SubscribeAndStoreId(String SheetName,int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName);

			try {
				hsr.StoreIdHealthSafety(SheetName, rowNum);	
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
}
