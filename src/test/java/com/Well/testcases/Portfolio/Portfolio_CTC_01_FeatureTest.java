package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_01_FeatureTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_02_UploadFileInAudit" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_CTC_01_Feature() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Meet Thresholds for Particulate Matter custom scenarios");

		try {

			 portfolio.PortfolioBuildScorecard();
			
			//pf.MeetThresholdsforOrganicGases("Meet Thresholds for Organic Gases");
			//pf.MeetEnhancedThresholdsforOrganicGases("Meet Enhanced Thresholds for Organic Gases");
			//pf.MitigateConstructionPollution("Mitigate Construction Pollution");
			//pf.ManageWindowUse("Manage Window Use");
			pf.EnhanceOccupantControllability("Enhance Occupant Controllability");
			// pf.ConductDaylightSimulation("Conduct Daylight Simulation");
/*
 * Waiting for Application
 * pf.MeetThresholdsforParticulateMatter("Meet Thresholds for Particulate Matter");
 * pf.MeetThresholdsforInOrganicGases("Meet Thresholds for Inorganic Gases");
 */

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
