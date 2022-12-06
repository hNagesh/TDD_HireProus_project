package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_09_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_08_ReviewTest.Healthsafey_TC_08_05_CurativeCompleteReview" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_09_00_GeneralDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.clikOnDocumentLibrary();
			hsr.validateGeneralUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_09_DocumentTest.Healthsafey_TC_09_00_GeneralDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_09_01_LegalDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.validateLegalUploadDocument(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_09_DocumentTest.Healthsafey_TC_09_01_LegalDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_09_02_AuditDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.validateAuditUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_09_DocumentTest.Healthsafey_TC_09_02_AuditDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_09_03_FeatureDocument(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"HealthSafety Upload Scorecard Document");
		try {
			hsr.validateFeatureUploadDocument(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
