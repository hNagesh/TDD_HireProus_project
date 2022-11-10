package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsPortfolio extends BaseClass {

	public void RegisterPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioCreateAccountButton");
		CommonMethod.WaitUntilVisibility("PortfolioCreateAccountButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountButton", "PortfolioAccountName");
		String AccountName = "Automation portfolio " + CommonMethod.randomNumber(8000000);
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 30);
		CommonMethod.sendKeys("PortfolioAccountName", AccountName);
		data.setCellData(SheetName, "AccountName", rowNum, AccountName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.ClickCheckbox("PortfolioNotSureRadio");
		CommonMethod.sendKeys("PortfolioNumberOfLocation", "15");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("PortfolioNumberOfLocation"));
		testlog.info("PortfolioNumberOfLocation: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.sendKeys("PortfolioEstimatedNumberOfLocation", "10");
		data.setCellData(SheetName, "EstimatedNumberOfLocation", rowNum,
				CommonMethod.getattributeValue("PortfolioEstimatedNumberOfLocation"));
		testlog.info("EstimatedNumberOfLocation: " + data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		CommonMethod.sendKeys("PortfolioGrossAreaSQFT", Area);
		data.setCellData(SheetName, "AreaSQFT", rowNum, CommonMethod.getattributeValue("PortfolioGrossAreaSQFT"));
		testlog.info("PortfolioGrossAreaSQFT: " + data.getCellData(SheetName, "AreaSQFT", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioPrimarlyLocated");
		CommonMethod.click("PortfolioPrimarlyLocated");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.click("PortfolioSpaceType");
		CommonMethod.click("PortfolioSelectSpaceType");
		CommonMethod.selectdropdownValue("PortfolioOwnerCountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerCountry"));
		testlog.info("PortfolioOwnerCountry: " + data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioOwnerState", 10);
		CommonMethod.selectdropdownrandom("PortfolioOwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerState"));
		testlog.info("PortfolioOwnerCountry: " + data.getCellData(SheetName, "State", rowNum));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("PortfolioOwnerStreetAddress", ProjectAddress1);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("PortfolioOwnerStreetAddress"));
		testlog.info("PortfolioOwnerStreetAddress: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("PortfolioOwnerCity"));
		testlog.info("PortfolioOwnerCity: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPostalCode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountSubmit", "WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getProjectId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
		testlog.pass("**Verifies the Registration successful**");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void SearchPortfolioByName(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("PortfolioSearchApplyFilter");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Portfolio Search failed");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Search Portfolio Name successfully**");
	}

	public void SignAgreementPortfolio() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("PortfolioClickSignNow", 60);
		CommonMethod.Robustclick("PortfolioClickSignNow");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Portfolio Sign Agreement successfully**");
	}

	public void SubscribePortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("SubscribeTab", 30);
		CommonMethod.Robustclick("SubscribeTab", "PortfolioOwnerName");
		CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		String OwnerName = USfaker.address().firstName();
		String OwnerEmail = USfaker.internet().emailAddress();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("PortfolioOwnerName"));
		testlog.info("OwnerName: " + data.getCellData(SheetName, "OwnerName", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("PortfolioOwnerEmail"));
		testlog.info("OwnerEmail: " + data.getCellData(SheetName, "OwnerEmail", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		data.setCellData(SheetName, "OwnerPhone", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPhone"));
		testlog.info("OwnerPhone: " + data.getCellData(SheetName, "OwnerPhone", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton", "PortfolioSubcribeContinueButton2");
		CommonMethod.ClickCheckbox("PortfolioQuestionRadio");
		CommonMethod.WaitUntilVisibility("PortfolioLocationDescriptionTextbox", 20);
		CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton2", "PortfolioSubscribeDone");
		CommonMethod.RobustclickElementVisible("PortfolioSubscribeDone", "PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		CommonMethod.Robustclick("PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.navigateBack();
		testlog.pass("**Verifies Subscribe Portfolio successfully**");
	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.RobustclickElementVisible("BiilingTab", "V2ProjectPreBillingPayNowButton");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2Tab", 120);
		CommonMethod.RobustclickElementVisible("WellV2Tab", "ScorecardTab");
		CommonMethod.click("ScorecardTab");
		if (CommonMethod.isElementsExist("PortfolioScorecardFinishedButton", 30)) {
			Thread.sleep(2000);
			CommonMethod.click("PortfolioScorecardFinishedButton");
			Thread.sleep(2000);
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPopupButton", 30);
			CommonMethod.click("PortfolioScorecardPopupButton");
		}
		CommonMethod.WaitUntilVisibility("PortFolioScoreCardPageLand", 300);
		testlog.pass("**Verfies Scorecard Page successfully**");
	}

	public void UploadFileinFeature(String FeatureName) throws IOException, InterruptedException {
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
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 10);
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
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
				Thread.sleep(2000);
				CommonMethod.scrollDown();
				List<WebElement> UploadTaskbtn;
				UploadTaskbtn = CommonMethod.findElements("PortfolioScoreCardVerificationUploadbtn");
				for (WebElement f : UploadTaskbtn) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
							"PortfolioScoreCardVerificationAddNote");
					if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
						CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
					}
				}
				CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyLoc", 30);
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Upload Scorecard Documents in feature successfully**");
	}

	public void UploadFileinAudit() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScoreCardSupportOrgFeature", 60);
		CommonMethod.click("ScoreCardSupportOrgFeature");
		CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
		CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
		CommonMethod.click("PortfolioScoreCardAddOptionbutton");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 10);
		CommonMethod.Robustclick("PortfolioScoreCardAddButton");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignbtn", 60);
		CommonMethod.click("PortfolioScoreCardVerificationAssignbtn");
		CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx", "PortfolioScorecardValidDisable");
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
		CommonMethod.click("PortfolioScoreCardVerificationAssignLocSavebtn");
		Thread.sleep(2000);
		CommonMethod.scrolldowntoLast();
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadbtn", 60);
		CommonMethod.click("PortfolioScoreCardVerificationUploadbtn");
		CommonMethod.scrolldowntoLast();
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", AuditfileUpload);
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn", "PortfolioScoreCardVerificationAddNote");
		testlog.pass("**Upload Scorecard Documents in Audit successfully**");
	}

	public void clickDocument() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("WellV2Tab", 120);
		CommonMethod.RobustclickElementVisible("WellV2Tab", "DocumentLibraryTab");
		CommonMethod.WaitUntilVisibility("DocumentLibraryTab", 60);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab", "PortfolioDocumentUploadbutton");
		testlog.pass("**Navigate Document successfully**");
	}

	public void ValidatingLegalUploadDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadbutton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "legal");
		CommonMethod.selectdropdownVisibletext("PortfolioSelectdocumenttype", "Signed certification agreement");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", LegalfileUpload, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Legal", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Legal Document successfully**");
	}

	public void ValidatingAuditUploadDocument() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "audit");
		CommonMethod.selectdropdownValue("PortfolioSelectverificationMethod", "2");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", AuditfileUpload, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Audit", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");
	
	}
	
	public void ValidatingFeatureUploadDocument() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 120);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "feature");
		CommonMethod.selectdropdownValue("PortfolioSelectverificationMethod", "19");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		testlog.info("Fetching Data from Upload Table");
		CommonMethod.softAssertContainsMessage(val.get(6), "Feature", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Feature Document successfully**");
		
	}
	public void ReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 30);
		CommonMethod.WaitUntilVisibility("PortfolioReviewSubmitButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitButton", "PortfolioReviewTextbox");
	//	CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioSelectProgram");
		// CommonMethod.WaitUntilClickble("PortfolioSelectProgram", 10).click();
		CommonMethod.sendKeys("PortfolioReviewTextbox", "Submit Documentation for Year 1, Review Cycle #1");
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitDocButton", "PortfolioReviewListStatus");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListStatus", 120);
		CommonMethod.assertcontainsmessage("PortfolioReviewListStatus", "ROUND 1 REVIEW IN PROGRESS",
				"Verified Submitted Review list status");
		testlog.pass("**Submitted Documentation for Year 1, Review Cycle #1 successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLAtScaleNavBar");
		CommonMethod.WaitUntilPresence("AdminWELLAtScaleNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLAtScaleNavBar", "PortfolioSearchByID");
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("PortfolioAdminApplybtn");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with excel in search");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab", "PortfolioReviewListViewButton");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
		CommonMethod.click("PortfolioReviewListViewButton");
		CommonMethod.WaitUntilVisibility("PortfolioReturnReview", 60);
		CommonMethod.click("PortfolioReturnReview");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitResponse", "PortfolioReviewStatus");
		CommonMethod.WaitUntilVisibility("PortfolioReviewStatus", 60);
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
	}

	public void registerFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 30);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioEditAccounttab");
		CommonMethod.WaitUntilVisibility("PortfolioEditAccounttab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioEditAccounttab", "PortfolioEditAccountName");
		CommonMethod.WaitUntilVisibility("PortfolioEditAccountName", 30);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditAccountName"),
				data.getCellData(SheetName, "AccountName", rowNum), "Portfolio Project Name doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditApproximatelyLoc"),
				data.getCellData(SheetName, "Location", rowNum), "Portfolio Approximately Location doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditLocationSubscribing"),
				data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum),
				"Portfolio Location Subscribing doesn't match");
		CommonMethod.softAssertEqualsMessage(
				CommonMethod.getattributeValue("PortfolioEditAreaSqft").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "AreaSQFT", rowNum), "Portfolio AreaSqft doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "Portfolio Organization Name doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("PortfolioEditOrganizationIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Portfolio OrganizationIndustry doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("PortfolioEditCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Portfolio Country doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("PortfolioEditState"),
				data.getCellData(SheetName, "State", rowNum), "Portfolio State doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditStreetAddress"),
				data.getCellData(SheetName, "Street", rowNum), "Portfolio StreetAddress doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditCity"),
				data.getCellData(SheetName, "City", rowNum), "Portfolio City doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Portfolio postal code matched with excel");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOrganizationOverview"),
				data.getCellData(SheetName, "Overview", rowNum), "Portfolio OrganizationOverview doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOwnerName"),
				data.getCellData(SheetName, "OwnerName", rowNum), "Portfolio OwnerName doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOwnerEmail"),
				data.getCellData(SheetName, "OwnerEmail", rowNum), "Portfolio OwnerEmail doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditOwnerPhone"),
				data.getCellData(SheetName, "OwnerPhone", rowNum), "Portfolio OwnerPhone doesn't match");
		softAssert.assertAll();
		testlog.pass("**Register Field Validation successfully**");
	}

	public void editAndValidateAccountInformationPortfolio(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioAccountNameEdit");
		CommonMethod.WaitUntilVisibility("PortfolioAccountInformation", 60);
		CommonMethod.RobustclickElementVisible("PortfolioAccountInformation", "PortfolioGoal");
		CommonMethod.WaitUntilVisibility("PortfolioAccountNameEdit", 60);
		CommonMethod.clearAndSendKey("PortfolioAccountNameEdit", data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioGoal", 60);
		CommonMethod.sendKeys("PortfolioGoal", data.getCellData(SheetName, "Goals", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioScope", 60);
		CommonMethod.sendKeys("PortfolioScope", data.getCellData(SheetName, "Scope", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioSaveButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioSaveButton", "WPRHsrPortfolioDashboard");
		testlog.info("**Project Information data updated successfully**");
		/*
		 * Validate updated account information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioAccountInformation");
		CommonMethod.WaitUntilVisibility("PortfolioAccountInformation", 60);
		CommonMethod.RobustclickElementVisible("PortfolioAccountInformation", "PortfolioGoal");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioGoal"),
				data.getCellData(SheetName, "Goals", rowNum), "Goals data doesn't match");
		testlog.info("**Goals data updated successfully**");
		CommonMethod.WaitUntilVisibility("PortfolioScope", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioScope"),
				data.getCellData(SheetName, "Scope", rowNum), "Scope data doesn't match");
		testlog.pass("**Scope data updated successfully**");
	}

	public void editAndValidateAdmin(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioCoachingContacts");
		CommonMethod.WaitUntilVisibility("PortfolioCoachingContacts", 60);
		CommonMethod.selectdropdownrandom("PortfolioCoachingContacts");
		data.setCellData(SheetName, "CoachingContacts", rowNum,
				CommonMethod.getSelectedDropdownValue("PortfolioCoachingContacts"));
		testlog.info("Coaching Contacts: " + data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.clearAndSendKey("PortfolioChallengesNotes",
				data.getCellData(SheetName, "ChallengeNote", rowNum));
		CommonMethod.clearAndSendKey("PortfolioCommunicationNotes",
				data.getCellData(SheetName, "CommunicationNotes", rowNum));
		CommonMethod.clearAndSendKey("PortfolioAccountNotes", data.getCellData(SheetName, "AccountNotes", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioSaveButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioSaveButton", "WPRHsrPortfolioDashboard");
		testlog.pass("**Admin data updated successfully**");
		/*
		 * Validate updated admin fields
		 */

		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioCoachingContacts");
		CommonMethod.WaitUntilVisibility("PortfolioCoachingContacts", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioCoachingContacts"),
				data.getCellData(SheetName, "CoachingContacts", rowNum), "Coaching contacts value doesn't match");
		testlog.pass("**Coaching contacts updated successfully**");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioChallengesNotes"),
				data.getCellData(SheetName, "ChallengeNote", rowNum), "Challenges notes value doesn't match");
		testlog.pass("**Rhallenges notes value updated successfully**");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioCommunicationNotes"),
				data.getCellData(SheetName, "CommunicationNotes", rowNum), "Communication notes value doesn't match");
		testlog.pass("**Communication notes value updated successfully**");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioAccountNotes"),
				data.getCellData(SheetName, "AccountNotes", rowNum), "Account notes value doesn't match");
		testlog.pass("**Account notes value updated successfully**");
	}

	public void teamPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 30);
		CommonMethod.click("V2ProjectAddMemberbtn");
		String TeamEmail = data.getCellData(SheetName, "TeamEmailID", rowNum);
		CommonMethod.WaitUntilVisibility("PortfolioEmailAddress", 30);
		CommonMethod.sendKeys("PortfolioEmailAddress", TeamEmail);
		data.setCellData(SheetName, "TeamEmailID", rowNum, TeamEmail);
		CommonMethod.selectdropdownVisibletext("PortfolioRole", "Acoustician");
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		CommonMethod.WaitUntilVisibility("V2ProjectInvitebtn", 30);
		CommonMethod.click("V2ProjectInvitebtn");
//		Thread.sleep(2000);
//		CommonMethod.refreshBrowser();
//		CommonMethod.WaitUntilVisibility("V2ProjectDeleteIcon", 30);
//		CommonMethod.click("V2ProjectDeleteIcon");
//		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 300);
		testlog.pass("**Created Team member successfully**");
	}
	
	public void deleteAddedTeamMemberPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("V2ProjectDeleteIcon", 30);
		CommonMethod.click("V2ProjectDeleteIcon");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 300);
	}
	public void validateTeamsPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("PortfolioSearchApplyFilter");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Portfolio Search failed");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		testlog.pass("**Verifies user able to access the invited project**");
	}
	public void clickOnTeamPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TeamTab", 300);
		CommonMethod.click("TeamTab");
	}
}
