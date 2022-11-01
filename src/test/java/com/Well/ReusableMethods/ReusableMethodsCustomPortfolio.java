package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsCustomPortfolio extends BaseClass {

	public void MeetThresholdsforParticulateMatter(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardA01PursueYesButton","PortfolioScorecardPursueToast");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardWeightPHighlighted", 1);
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 1);
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 1);
				/*
				 * Add 2 options with same verification method
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditoption","PortfolioScorecardEditoption");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 30);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
							"PortfolioScorecardValidDisable");
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
							"PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				CommonMethod.scrollDown();
				Thread.sleep(10000);
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationUploadbtn", 60);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
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
				testlog.info("**Verifies Task Count successful**");
				testlog.info("**Verifies Option Count successful**");
				testlog.info("**Verifies Toaster message successful**");
				testlog.info("**Verifies Document table data successful**");
				testlog.info("Review Status is correct in Table in UplaodTab");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);

			}
		}
		testlog.pass("**Verifies Feature successful**");
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
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 30);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				/*
				 * ScoreCard Add option
				 */
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 2);
				testlog.info("**Verifies RemoveButton Count successful**");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 2);
				testlog.info("**Verifies Task Count successful**");
				testlog.info("**Verifies Option Count successful**");
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
				testlog.info("**Verifies Option Purse Location successful**");
				testlog.info("**Verifies Task Purse Location successful**");
				/*
				 * Upload Document for Tasks
				 */
				List<WebElement> UploadTaskbtn;
				UploadTaskbtn = CommonMethod.findElements("PortfolioScoreCardVerificationUploadbtn");
				for (WebElement f : UploadTaskbtn) {
					CommonMethod.scrollDown();
					CommonMethod.WaitUntilClickble(f, 60).click();
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
						testlog.info("**Verifies Verification Method successful**");
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
						testlog.info("**Verifies Remove link in Upload Feature successful**");
					}
					CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadDocbtn",
							"PortfolioScorecardDocumentAddedPopup");
					if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
						CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
					}
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
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.info("**Verifies Upload Document Toaster message successful**");
				testlog.info("**Verifies Option Purse Location Count successful**");
				testlog.info("**Verifies Task Assign Location Count successful**");
				testlog.info("**Verifies updated Task Assigned Location Count successful**");
				testlog.info("**Verifies Document table data successful**");
				testlog.info("**Verifies Completed Task Location Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);

			}
		}
		testlog.pass("**Verifies Feature successful**");
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
				CommonMethod.scrollDown();
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
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				softAssert.assertAll();
				testlog.info("Fetching Data from Upload Table");
				testlog.info("**Verifies updated Task Assigned Location Count successful**");
				testlog.info("**Verifies Document table data successful**");
				testlog.info("**Verifies Completed Task Location Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
				}
		}
		testlog.pass("**Verifies Feature successful**");
		
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
		testlog.pass("**Verifies Feature successful**");
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
				softAssert.assertAll();
				testlog.info("**Verifies Option Count successful**");
				testlog.info("**Verifies Task count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Feature successful**");
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
				softAssert.assertAll();
				testlog.info("**Verifies Option Count successful**");
				testlog.info("**Verifies Task count successful**");
				testlog.info("**Verifies Assign button count successful**");
				testlog.info("**Verifies Task Upload disable button count successful**");
				testlog.info("**Verifies Enable Weight highlightling count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Feature successful**");
	}
	
	public void InstallIndoorAirMonitors(String FeatureName) throws IOException, InterruptedException {
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
				CommonMethod.click("PortfolioScorecardA08PurseStatus");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				testlog.info("**Verifies Response selection Yes Toaster message successful**");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCorePointCheckbox", 3);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 2);
				testlog.info("**Verifies CorePoint Checkbox Count successful**");
				testlog.info("**Verifies Assign button Count successful**");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardCorePointCheckbox", 60);
				 /*
				 * Test by adding the core point
				 */
				 CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0,1);
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlightA08", 30);
				CommonMethod.scrolldowntoElement("PortfolioScorecardWeightHighlightA08");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlightA08"),"1", "Weight Point for doesn't match");
				softAssert.assertAll();
				testlog.info("**Verifies Weight Point Count successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Feature successful**");	
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
				CommonMethod.RobustclickElementVisible("PortfolioScorecardL09PurseStatus","PortfolioScorecardPursueToast");
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
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton","PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 120);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCorePointCheckbox", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardVerifyTierDropdownValue", 2);
				CommonMethod.softAssertContainsMessage(CommonMethod.getSelectedDropdownValue("PortfolioScorecardTierDropdownValue"), "Tier 1",
						"TierDropdown Defualt value doesn't match");
				
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0, 1);
				CommonMethod.selectdropdownValue("PortfolioScorecardTierDropdownValue", "2");
				CommonMethod.click("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 60);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				 /*
				 * Test by adding the core point
				 */
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"3", "Weight Point for 3 doesn't match");
				testlog.pass("**Verifies Core Weight Point successful**");
				
				/*
				 * Verify Upload button disable
				 */
				CommonMethod.scrollDown();
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 2);
			    CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAssignbtn", 120);
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					/*
					 * Assign Location
					 */
					CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyTotalLocationCount", 120);
					CommonMethod.softAssertContainsMessage(
					CommonMethod.getText("PortfolioScorecardAssignLocationCountInModel"), "LOCATIONS (5)", "Location Count in model doesn't match");
					/*
					 * Assign Location filter
					 */
					CommonMethod.RobustclickElementVisible("PortfolioScorecardFilters", "OwnerOrgClick");
					CommonMethod.click("OwnerOrgClick");
					CommonMethod.sendKeys("OwnerOrg", "India");
					CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10).click();
					CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyCountryFilter", 120);
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyCountryFilter"), "India", "Country doesn't match");
					CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyFilterReset","PortfolioScoreCardVerificationAssignChildLocCbx");
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1, 4);
					/*
					 * Verify selected Location
					 */
					CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation", "PortfolioScoreCardVerificationAssignLocCbxGeneral");
					CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScoreCardVerifyAssignedLocation"), "3 locations assigned", "Assigned Location Count doesn't match");
					/*
					 * Verify Tag New status
					 */
					CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerifyAssignedLocationNewStatus", 3);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn", "PortfolioScoreCardVerificationAssignLocCancelbtn");
}
				
				/*
				 * Verifies Assign Button and verify Purse Location Count
				 */
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "3 Pursuing",
							"Option Purse Location Count doesn't match");
				}
				
				/*
				 * Verifies Assign Button change to Edit Location
				 */
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
				/*
				 * Verify Task Location count
				 */
				List<WebElement> TaskAssignLocation;
				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/1 Locations",
							"Task Assign Location Count doesn't match");
				}
				/*
				 * Edit location and verify the updated location
				 */
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation",
						"PortfolioScoreCardVerificationAssignLocCbxGeneral");
				/*
				 * Verify Assigned to Unassigned
				 */
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAssignLocCbx", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignLocCbx", "PortfolioScorecardUnassignedStatus");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUnassignedStatus", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardUnassignedStatus", 3);
				CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignLocCbx");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn", "PortfolioScoreCardVerificationAssignLocCancelbtn");
                List<WebElement> EditTaskAssignLocation;
				EditTaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : EditTaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations","Task Assign Location Count doesn't match");
				}
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				/*
				 * Test by removing the core point from option 1
				 */
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1);
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlighted", 30);
				Thread.sleep(2000);
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"2", "Weight Point for 2 doesn't match");
				testlog.pass("**Verifies Core Weight Point successful**");
				
				/*
				 * Test by modifying tier point to 1 for option 1 and 2
				 */
				List<WebElement> dropdown = CommonMethod.findElements("PortfolioScorecardTierDropdownValueGeneral");
				for (WebElement drop : dropdown) {
					CommonMethod.selectdropdownWebelementByValue(drop, "1");
					Thread.sleep(1000);
					CommonMethod.softAssertContainsMessage(CommonMethod.getSelectedDropdownValue(drop), "1", "TierDropdown value doesn't match");
				}
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlighted", 30);
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"),"2", "Weight Point for 2 doesn't match");		
				softAssert.assertAll();
				testlog.info("**Verifies CorePoint Checkbox count successful**");
				testlog.info("**Verifies TierDropdown count successful**");
				testlog.info("**Verifies TierDropdown value successful**");
				testlog.info("**Verifies Core Weight Point successful**");
				testlog.info("**Verifies Upload button disable successful**");
				testlog.info("**Verifies Total Location Count successful**");
				testlog.info("**Verifies Location Filter successful**");
				testlog.info("**Verifies Assigned Location New Status Count successful**");
				testlog.info("**Verifies Assign Button change to Edit Location successful**");
				testlog.info("**Verifies Option Purse Location Count successful**");
				testlog.info("**Verifies Unassigned Status Count successful**");
				testlog.info("**Verifies updated Location Count successful**");
				testlog.info("**Verifies Task location count successful**");
				testlog.info("**Verifies Selected Assigned Location successful**");
				testlog.pass("**Verifies Core Weight Point successful**");
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
                CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Feature successful**");
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
				
				List<WebElement> TaskPurseLocation;
				TaskPurseLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations",
							"Task Assign Location Count doesn't match");
				}
				Thread.sleep(2000);
				CommonMethod.scrollDown();
				CommonMethod.ClickFirstElementInList("PortfolioScoreCardVerificationUploadbtn");
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
				testlog.info("**Verifies attach file option removed successful**");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardVerifyTaskUploadIntentStage",
						"PortfolioScorecardVerifyTaskUploadUpdateButton");
				CommonMethod.Robustclick("PortfolioScorecardVerifyTaskUploadUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
    			CommonMethod.softAssertContainsMessage(val.get(4), "Intent", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				testlog.pass("**Verifies Option Purse Location Count successful**");
				testlog.pass("**Verifies Task Location Count successful**");
				testlog.pass("**Verifies Location Count successful**");
				testlog.info("Fetching Data from Upload Table");
				testlog.info("Verifies Task Upload Update Location Count");
				testlog.info("Verifies Task Upload Update Location Count");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioDocListTaskUploadList", 1);
				CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteIcon", "PortfolioDocListDeleteNoButton");
				CommonMethod.WaitUntilVisibility("PortfolioDocListDeleteNoButton", 60);
				CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteNoButton","PortfolioDocListTaskUploadList");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioDocListTaskUploadList", 1);
				softAssert.assertAll();
				CommonMethod.WaitUntilPresence("PortfolioDocListDeleteIcon", 120);
				CommonMethod.RobustclickElementVisible("PortfolioDocListDeleteIcon", "PortfolioDocListDeleteYesButton");
				CommonMethod.WaitUntilPresence("PortfolioDocListDeleteYesButton", 120);
				CommonMethod.Robustclick("PortfolioDocListDeleteYesButton");
				if (CommonMethod.isElementsExist("PortfolioDocListTaskUploadListDeleteToastMessage", 12)) {
					CommonMethod.WaitUntilInVisibility("PortfolioDocListTaskUploadListDeleteToastMessage", 30);
				}
				CommonMethod.WaitUntilPresence("PortfolioDocListTaskUploadVerifyNoList", 120);
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Feature successful**");
	}
	public void OfferPhysicalActivityIncentives(String FeatureName) throws IOException, InterruptedException {
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
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 60);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardAddOptionbutton", 1);
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				testlog.info("**Verifies Option Count successful**");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskOptionV09", 3);
				testlog.info("**Verifies Task Option Count successful**");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 3);
				softAssert.assertAll();
				testlog.info("**Verifies Upload button disable successful**");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
	}
		testlog.pass("**Verifies Feature successful**");
	}
	public void RestrictVOCEmissionsfromFurnitureArchitecturalandInteriorProducts(String FeatureName) throws IOException, InterruptedException {
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
				CommonMethod.softAssertContainsMessage(CommonMethod.getSelectedDropdownValue("PortfolioScorecardTierDropdownValue"), "1",
						"TierDropdown Defualt value doesn't match");
				testlog.info("**Verifies Tier Dropdown Value successful**");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlightX06"),"2", "Weight Point for 3 doesn't match");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.pass("**Verifies Core Weight Point successful**");
				softAssert.assertAll();
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
}
		testlog.pass("**Verifies Feature successful**");
}
	public void A01_1_FeatureDocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab","PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListPendingTab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab","PortfolioDocumentVerifyA1.1InTaskList");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioDocumentVerifyA1.1InTaskList"),"A01.1", "A01.1 task doesn't match");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentTaskListUploadButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentTaskListUploadButton","PortfolioScoreVerifyUploadVerificationMethod");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod"),"A01.1", "A01.1 task doesn't match");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),"A01.1", "A01.1 task doesn't match");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"),"5 Locations assigned", "Selected Location Count doesn't match");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListEditLocation", 30);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListEditLocation", "PortfolioScorecardUncheckLoc");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioTaskListVerifySelectedLoctionCount"),"5 locations selected", "Selected Location Count doesn't match");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
				"PortfolioScoreCardVerificationAddNote");
		if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
		}
		CommonMethod.WaitUntilVisibility("PortfolioDocListTaskFullFilledTab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", "PortfolioDocumentVerifyA1.1InTaskList");
		CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioDocumentVerifyA1.1InTaskList"),"A01.1", "A01.1 task doesn't match");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentListLink", 30);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioDocumentVerifyA1.1InTaskList");
		
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		testlog.info("Fetching Data from Upload Table");
		CommonMethod.softAssertContainsMessage(val.get(3), "A01.1", "Document table data mismatch");
		softAssert.assertAll();
		
	}
	
public void L09_AuditDocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
	
		
		
	}
public void UpdateAuditDocumentUploadInDocumentLibrary() throws IOException, InterruptedException {
	
}
public void FilterInDocumentLibrary() throws IOException, InterruptedException {
	
	
	
}

public void DeleteInDocumentLibrary() throws IOException, InterruptedException {
	
	
	
}
	}