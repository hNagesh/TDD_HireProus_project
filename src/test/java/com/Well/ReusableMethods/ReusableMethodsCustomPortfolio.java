package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ReusableMethodsCustomPortfolio extends BaseClass {

	public void MeetThresholdsforParticulateMatter(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.clickListWebelementFromIndex("PortfolioScorecardPursueYesButton", 0);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardWeightPHighlighted", 1);
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 1);
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 1);
				CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 0);
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
						"PortfolioScoreCardVerificationAssignLocCancelbtn");
				Thread.sleep(2000);
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationUploadbtn", 60);
				CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,
						"UploadFileVerifyScorecard");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
						"PortfolioScoreCardVerificationAddNote");
				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
				}
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.pass("**Verifies Document table data successful**");
				testlog.info("Review Status is correct in Table in UplaodTab");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);

			}
		}
	}

	public void MeetThresholdsforOrganicGases(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				/*
				 * ScoreCard Add option
				 */
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 2);
				testlog.pass("**Verifies RemoveButton Count successful**");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 2);
				testlog.pass("**Verifies Task Count successful**");
				testlog.pass("**Verifies Option Count successful**");
				/*
				 * Assign 3 Location
				 */
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1,
							4);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
							"PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				Thread.sleep(2000);
				CommonMethod.WaitUntilPresence("PortfolioScorecardOptionPurseLocation", 60);
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "3 Pursuing",
							"PurseLocationCount doesn't match");
				}
				List<WebElement> TaskAssignLocation;
				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/3 Locations",
							"Task Assign Location Count doesn't match");
				}
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionPurseLocation", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskPurseLocation", 2);
				testlog.pass("**Verifies Option Purse Location successful**");
				testlog.pass("**Verifies Task Purse Location successful**");
				/*
				 * Upload Document for Tasks
				 */
				List<WebElement> UploadTaskbtn;
				UploadTaskbtn = CommonMethod.findElements("PortfolioScoreCardVerificationUploadbtn");
				for (WebElement f : UploadTaskbtn) {
					CommonMethod.scrollDown();
					CommonMethod.WaitUntilClickble(f, 30).click();
					/*
					 * Valid FeatureName, DocumentType and VerificationMethod
					 */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
							"Meet Thresholds for Organic Gases", "Feature Name doesn't match");
					testlog.info("FeatureName: " + CommonMethod.getText("PortfolioScorecardUploadFeatureName"));
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardDocumentType"),
							"Feature verification", "Document Type doesn't match");
					testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
					String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
					testlog.info("VerificationMethod: " + VerificationMethod);
					/*
					 * Adding part A05.2
					 */
					if (VerificationMethod.equalsIgnoreCase("Performance Test")) {
						CommonMethod.softAssertContainsMessage(VerificationMethod, "Performance Test",
								"Verification Method doesn't match");
						testlog.pass("**Verifies Verification Method successful**");
						CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
						CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
						CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
								"PortfolioScoreCardVerificationSelectFeature");
						CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A05.2");
						CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPart", 60);
						CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
								"PortfolioScoreCardVerificationSelectFeature");
						CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadAddfeature",
								"PortfolioScoreCardVerificationSelectFeature");
						/*
						 * Valid Added part remove link
						 */
						CommonMethod.scrolldowntoElement("PortfolioScoreVerifyUploadVerificationMethod");
						CommonMethod.WaitUntilVisibility("PortfolioScorecardUploadRemovelink", 60);
						testlog.pass("**Verifies Remove link in Upload Feature successful**");
					}
					CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadDocbtn",
							"PortfolioScorecardDocumentAddedPopup");
					if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
						CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
					}
					testlog.pass("**Verifies Upload Document Toaster message successful**");
					testlog.pass("**Verifies Option Purse Location Count successful**");
					testlog.pass("**Verifies Task Assign Location Count successful**");
				}
				/*
				 * Edit Upload Document
				 */
				CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon",
						"PortfolioScoreVerifyUploadVerificationMethod");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				/*
				 * Edit location and verify count
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLoc", "PortfolioScorecardUncheckLoc");
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),
						"5 Locations assigned", "Task Upload Update Location Count doesn't match");
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage",
						"PortfolioScorecardVerifyTaskUploadUpdateButton");
				CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.scrolldowntoElement("PortfolioScorecardCompletedTaskLocCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCompletedTaskLocCount", 2);
				testlog.pass("**Verifies updated Task Assigned Location Count successful**");
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.pass("**Verifies Document table data successful**");
				testlog.pass("**Verifies Completed Task Location Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);

			}
		}
	}
	
	public void MeetEnhancedThresholdsforOrganicGases(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				/*
				 * Edit Upload Document
				 */
				CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon1",
						"PortfolioScoreVerifyUploadVerificationMethod");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				/*
				 * Edit location and verify count
				 */
				CommonMethod.WaitUntilVisibility("PortfolioScorecardUploadEditLocationA05.2", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadEditLocationA05.2", "PortfolioScorecardUncheckLoc");
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage",
						"PortfolioScorecardVerifyTaskUploadUpdateButton");
				CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "5 Pursuing",
							"PurseLocationCount doesn't match");
				}
				CommonMethod.scrolldowntoElement("PortfolioScorecardCompletedTaskLocCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCompletedTaskLocCount", 1);
				testlog.pass("**Verifies updated Task Assigned Location Count successful**");
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.pass("**Verifies Document table data successful**");
				testlog.pass("**Verifies Completed Task Location Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
	
			}
		}
	}
	
	
	public void MeetThresholdsforInOrganicGases(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardDocumentUploadTable", 60);
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.pass("**Verifies Document table data successful**");
				testlog.info("Review Status is correct in Table in UploadTab");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
	}

	public void MitigateConstructionPollution(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardMigrationOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardMigrationOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 1);
				testlog.pass("**Verifies Option Count successful**");
				testlog.pass("**Verifies Task count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
	}

	public void ManageWindowUse(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardMangeOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardMigrationOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 3);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 3);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				String VerifyAndText = CommonMethod.getText("PortfolioScorecardVerifyAndOption");
				testlog.info("And Condition: " + VerifyAndText);
				CommonMethod.assertActualContainsExpected(VerifyAndText, "AND");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardManageWeightHightlighting", 1);
				testlog.pass("**Verifies Option Count successful**");
				testlog.pass("**Verifies Task count successful**");
				testlog.pass("**Verifies Assign button count successful**");
				testlog.pass("**Verifies Task Upload disable button count successful**");
				testlog.pass("**Verifies Enable Weight highlightling count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);

			}
		}

	}

	public void EnhanceOccupantControllability(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				/*
				 * Response selection Yes for optimization
				 */
				CommonMethod.click("PortfolioScorecardL09PurseStatus");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				testlog.pass("**Verifies Response selection Yes Toaster message successful**");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				/*
				 * Test by adding Light L09.1 feature option 1 And option 2
				 */
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardCorePointCheckbox", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCorePointCheckbox", 2);
				testlog.pass("**Verifies CorePoint Checkbox count successful**");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardVerifyTierDropdownValue", 2);
				testlog.pass("**Verifies TierDropdown count successful**");
				CommonMethod.softAssertContainsMessage(
						CommonMethod.getSelectedDropdownValue("PortfolioScorecardTierDropdownValue"), "1",
						"TierDropdown Defualt value doesn't match");
				CommonMethod.selectdropdownValue("PortfolioScorecardTierDropdownValue", "2");
				testlog.pass("**Verifies TierDropdown value successful**");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				/*
				 * Tier point 2 should change the weight 1
				 */
				System.out.println("2point"+CommonMethod.getText("PortfolioScorecardWeightHighlighted"));
				 CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"2", "Weight Point for 2 doesn't match");

				/*
				 * Test by adding the core point
				 */
				 
				 CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignLocCbx");
				 CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAssignLocCbx");
				 CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignChildLocCbx");
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlighted", 30);
				Thread.sleep(20000);
				System.out.println("3point"+CommonMethod.getText("PortfolioScorecardWeightHighlighted"));
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"3", "Weight Point for 3 doesn't match");
				testlog.pass("**Verifies Core Weight Point successful**");

//				/*
//				 * Verify Upload button disable
//				 */
//				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 2);
//				testlog.pass("**Verifies Upload button disable successful**");
//
//				List<WebElement> AssignButton;
//				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
//				for (WebElement f : AssignButton) {
//					CommonMethod.WaitUntilClickble(f, 30).click();
//					/*
//					 * Assign Location
//					 */
//					CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyTotalLocationCount", 120);
//					CommonMethod.softAssertContainsMessage(
//							CommonMethod.getText("PortfolioScorecardAssignLocationCountInModel"), "LOCATIONS (5)",
//							"Location Count in model doesn't match");
//					testlog.pass("**Verifies Total Location Count successful**");
//					/*
//					 * Assign Location filter
//					 */
//					CommonMethod.RobustclickElementVisible("PortfolioScorecardFilters", "OwnerOrgClick");
//					CommonMethod.click("OwnerOrgClick");
//					CommonMethod.sendKeys("OwnerOrg", "Afghanistan");
//					CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10).click();
//					CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyCountryFilter", 120);
//					CommonMethod.softAssertContainsMessage(
//							CommonMethod.getText("PortfolioScorecardVerifyCountryFilter"), "Afghanistan",
//							"Country doesn't match");
//					CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyFilterReset",
//							"PortfolioScoreCardVerificationAssignChildLocCbx");
//					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
//					testlog.pass("**Verifies Location Filter successful**");
//					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1,
//							4);
//					/*
//					 * Verify selected Location
//					 */
//					CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation",
//							"PortfolioScoreCardVerificationAssignLocCbxGeneral");
//					CommonMethod.softAssertContainsMessage(
//							CommonMethod.getText("PortfolioScoreCardVerifyAssignedLocation"), "3 locations assigned",
//							"Assigned Location Count doesn't match");
//					testlog.pass("**Verifies Selected Assigned Location successful**");
//					/*
//					 * Verify Tag New status
//					 */
//					CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerifyAssignedLocationNewStatus",
//							3);
//					testlog.pass("**Verifies Assigned Location NewStatus Count successful**");
//					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
//					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
//							"PortfolioScoreCardVerificationAssignLocCancelbtn");
//
//				}
//				/*
//				 * Verifies Assign Button and verify Purse Location Count
//				 */
//				List<WebElement> AssignPurseLocation;
//				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
//				for (WebElement f : AssignPurseLocation) {
//					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "3 Pursuing",
//							"Option Purse Location Count doesn't match");
//				}
//				testlog.pass("**Verifies Option Purse Location Count successful**");
//				/*
//				 * Verifies Assign Button change to Edit Location
//				 */
//				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
//				testlog.pass("**Verifies Assign Button change to Edit Location successful**");
//				/*
//				 * Verify Task Location count
//				 */
//				List<WebElement> TaskAssignLocation;
//				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
//				for (WebElement f : TaskAssignLocation) {
//					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/1 Locations",
//							"Task Assign Location Count doesn't match");
//				}
//				testlog.pass("**Verifies Task location count successful**");
//
//				/*
//				 * Edit location and verify the updated location
//				 */
//				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
//				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation",
//						"PortfolioScoreCardVerificationAssignLocCbxGeneral");
//				/*
//				 * Verify Assigned to Unassigned
//				 */
//				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAssignLocCbx", 60);
//				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignLocCbx",
//						"PortfolioScorecardUnassignedStatus");
//				CommonMethod.WaitUntilPresence("PortfolioScorecardUnassignedStatus", 60);
//				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardUnassignedStatus", 3);
//				testlog.pass("**Verifies Unassigned Status Count successful**");
//				CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignLocCbx");
//				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
//				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
//						"PortfolioScoreCardVerificationAssignLocCancelbtn");
//                List<WebElement> EditTaskAssignLocation;
//				EditTaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
//				for (WebElement f : EditTaskAssignLocation) {
//					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations",
//							"Task Assign Location Count doesn't match");
//				}
//				testlog.pass("**Verifies updated Location Count successful**");
				softAssert.assertAll();
			}
		}
	}

	public void ConductDaylightSimulation(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardVerifyAuditInOptionTask", 2);
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1,
							5);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
							"PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "4 Pursuing",
							"PurseLocationCount doesn't match");
				}
				testlog.pass("**Verifies Option Purse Location Count successful**");
				List<WebElement> TaskPurseLocation;
				TaskPurseLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations",
							"Task Assign Location Count doesn't match");
				}
				testlog.pass("**Verifies Location Count successful**");

				Thread.sleep(2000);
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationUploadbtn", 60);
				CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,
						"UploadFileVerifyScorecard");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
						"PortfolioScoreCardVerificationAddNote");
				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
				}
				/*
				 * Edit Upload Document
				 */
				CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon",
						"PortfolioScoreVerifyUploadVerificationMethod");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				/*
				 * Edit location and verify count
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLoc", "PortfolioScorecardUncheckLoc");
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 60);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadEditLocationsUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),
						"2 Locations assigned", "Task Upload Update Location Count doesn't match");
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
				CommonMethod.WaitUntilInVisibility("PortfolioScoreCardVerificationUpload", 60);
				testlog.pass("**Verifies attach file option removed successful**");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage",
						"PortfolioScorecardVerifyTaskUploadUpdateButton");
				CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
    			CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				CommonMethod.assertcountListWebelementFromIndex("PortfolioDocListTaskUploadList", 2);
				CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteIcon", "PortfolioDocListDeleteNoButton");
				CommonMethod.WaitUntilVisibility("PortfolioDocListDeleteNoButton", 60);
				CommonMethod.Robustclick("PortfolioDocListDeleteYesButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioDocListTaskUploadList", 2);
				CommonMethod.WaitUntilVisibility("PortfolioDocListDeleteYesButton", 30);
				CommonMethod.Robustclick("PortfolioDocListDeleteYesButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioDocListTaskUploadList", 1);
				
			}
		}
	}
}
