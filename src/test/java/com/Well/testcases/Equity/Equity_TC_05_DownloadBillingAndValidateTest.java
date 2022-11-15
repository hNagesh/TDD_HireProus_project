package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_05_DownloadBillingAndValidateTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_16_BillingTest.Performance_TC_16_Billing" })
	@Parameters({ "SheetName","rowNum" ,"Country"})
	public void Equity_TC_05_DownloadBillingAndValidate(String SheetName,int rowNum,String Country) throws IOException {

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
