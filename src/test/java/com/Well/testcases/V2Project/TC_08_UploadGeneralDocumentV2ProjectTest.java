package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_08_UploadGeneralDocumentV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.TC_07_ScorecardV2ProjectTest.TC_07_ScorecardV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_08_UploadGeneralDocumentV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		v2project.UploadLegalAndGeneralDocumentFromDocumentLibrary(SheetName, rowNum,"General",GeneralfileUpload);	
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
