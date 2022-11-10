package com.Well.testcases.Membership;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Membership_TC_05_ProductLicensingTest extends BaseClass {
	
	@Test//(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_04_BillingTest.Membership_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_NavigationToProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Membership Card Payment Functionality");
		try {
		membership.AdminMembershipNavigation(SheetName, rowNum,MembershipName);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test//(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_04_BillingTest.Membership_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_UploadDocumentInProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Membership Card Payment Functionality");
		try {
		membership.UploadDocumentInLicensing(SheetName, rowNum,MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test//(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_04_BillingTest.Membership_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_CreateProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Membership Card Payment Functionality");
		try {
      membership.CreateLicensing(SheetName, rowNum,MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test//(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_04_BillingTest.Membership_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_UpdateProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Membership Card Payment Functionality");
		try {
	
		membership.UpdateLicensing(SheetName, rowNum,MembershipName);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test//(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_04_BillingTest.Membership_TC_04_Billing" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void Membership_TC_05_DeleteProductLicensing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Membership Card Payment Functionality");
		try {
		membership.DeleteLicensing(SheetName, rowNum,MembershipName);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
