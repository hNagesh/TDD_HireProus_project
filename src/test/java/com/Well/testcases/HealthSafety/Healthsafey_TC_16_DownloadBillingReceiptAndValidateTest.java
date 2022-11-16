package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_16_DownloadBillingReceiptAndValidateTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_15_AddLocationTest.Healthsafey_TC_15_AddLocation" })
	@Parameters({ "SheetName","rowNum" ,"Country"})
	public void Healthsafey_TC_16_DownloadBillingReceiptAndValidate(String SheetName,int rowNum,String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate billing receipt");
		try {
			rc.ClickBilling(SheetName, rowNum);
			rc.DownloadBillingReceiptAndValidate(SheetName, rowNum, Country);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
