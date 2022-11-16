package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_08_ScoreCardTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_07_LocationTest.Equity_TC_07_01_AddLocation" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_00_CompleteScorecardWerById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Performance Scorecard Complete Functionality");

		try {
			equity.CompleteScorecardWerById(SheetName,rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_08_ScoreCardTest.Equity_TC_08_00_CompleteScorecardWerById" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_08_01_UploadWERDocForFeature() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName,"Upload Document Scorecard Functionality");

		try {
			equity.UploadWERDocForFeature(21);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
