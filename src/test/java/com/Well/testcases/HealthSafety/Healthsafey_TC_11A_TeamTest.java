package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_11A_TeamTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_11_TeamTest.Healthsafey_TC_11_Team" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_11A_Team(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifies user able to access the invited project");
		try {
			rc.team(SheetName, rowNum);
			rc.SignOut();
			rc.commonLogin(SheetName, rowNum);
			hsr.validateTeamsHSR(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
