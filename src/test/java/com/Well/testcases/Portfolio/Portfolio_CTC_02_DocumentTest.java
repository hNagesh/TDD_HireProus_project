package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_02_DocumentTest extends BaseClass {

	@Test//(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_CTC_02_Document() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Attach Document and verify");
		try {
			portfolio.clickDocument();
		//	pf.A01_1_FeatureDocumentUploadInDocumentLibrary();
			pf.A01_2_DocumentUploadInDocumentLibrary();
		//	pf.L09_AuditDocumentUploadInDocumentLibrary();
		
		//	pf.UpdateAuditDocumentUploadInDocumentLibrary();
		//	pf.FilterInDocumentLibrary();
		//	pf.DeleteInDocumentLibrary();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
