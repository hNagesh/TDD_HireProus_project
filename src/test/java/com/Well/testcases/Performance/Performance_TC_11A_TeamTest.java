package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_11A_TeamTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_11_TeamTest.Performance_TC_11_Team" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_11A_Team(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies user able to access the invited WPR project");
		try {
			rc.team(SheetName, rowNum);
			rc.SignOut();
			rc.teamMemberLogin(SheetName, rowNum);
			performance.validateTeamsWPR(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
