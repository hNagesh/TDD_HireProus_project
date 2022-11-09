package com.Well.testcases.Membership;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Membership_TC_05_ProductLicensingTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_04_BillingTest.Membership_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_ProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Membership Card Payment Functionality");
		try {
		membership.AdminMembershipNavigation(SheetName, rowNum,MembershipName);
		membership.UploadDocumentInLicensing(SheetName, rowNum,MembershipName);
		membership.CreateLicensing(SheetName, rowNum,MembershipName);
		membership.UpdateLicensing(SheetName, rowNum,MembershipName);
		membership.DeleteLicensing(SheetName, rowNum,MembershipName);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
