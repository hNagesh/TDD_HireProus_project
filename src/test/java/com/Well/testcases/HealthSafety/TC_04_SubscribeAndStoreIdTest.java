package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_04_SubscribeAndStoreIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.TC_03_RegisterHealthSafetyTest.tc_03_RegisterHealthSafetyTest" })
	@Parameters({ "SheetName","rowNum" })
	public void tc_04_SubscribeAndStoreIdTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);

		try {
			v2project.Billing(SheetName, rowNum);	
			hsr.StoreIdHealthSafety(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
