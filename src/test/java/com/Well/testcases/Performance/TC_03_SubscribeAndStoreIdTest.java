package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_03_SubscribeAndStoreIdTest extends BaseClass {

	@Test
	@Parameters({ "SheetName","rowNum" })
	public void tc_03_SubscribeAndStoreIdTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName);

		try {
			v2project.Billing(SheetName, rowNum);	
			performance.StoreIdPerformance(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
