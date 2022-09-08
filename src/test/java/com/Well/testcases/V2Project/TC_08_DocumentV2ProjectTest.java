package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_08_DocumentV2ProjectTest extends BaseClass {

	@Test
	@Parameters({ "SheetName","rowNum" })
	public void tc_08_DocumentV2ProjectTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
		v2project.UploadGeneralDocumentInDocV2Project(SheetName, rowNum);	
		v2project.UploadLegalDocumentInDocV2Project(SheetName, rowNum);	
		v2project.UploadOngoingDocumentInDocV2Project(SheetName, rowNum);	
		v2project.UploadFeatureDocumentInDocV2Project(SheetName, rowNum);
		v2project.UploadDocumentCountInDocV2Project(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
