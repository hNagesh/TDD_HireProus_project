package com.Well.testcases.Membership;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_03_EnrollTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Membership.TC_02_RegisterMembershipTest.TC_02_RegisterMembership" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_03_Enroll(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
			membership.EnrollMembership(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
