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
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar","PortfolioCreateAccountButton");
		CommonMethod.WaitUntilVisibility("PortfolioCreateAccountButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountButton","PortfolioAccountName");
		String AccountName = "Automation portfolio " + CommonMethod.randomNumber(8000000);
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 30);
		CommonMethod.sendKeys("PortfolioAccountName", AccountName);
		data.setCellData(SheetName, "AccountName", rowNum, AccountName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		testlog.info("OrgIndustry: " +data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.ClickCheckbox("PortfolioNotSureRadio");
		CommonMethod.sendKeys("PortfolioNumberOfLocation", "15");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("PortfolioNumberOfLocation"));
		testlog.info("PortfolioNumberOfLocation: "+data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.sendKeys("PortfolioEstimatedNumberOfLocation", "10");
		data.setCellData(SheetName, "EstimatedNumberOfLocation", rowNum, CommonMethod.getattributeValue("PortfolioEstimatedNumberOfLocation"));
		testlog.info("EstimatedNumberOfLocation: "+data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100,50000);
		CommonMethod.sendKeys("PortfolioGrossAreaSQFT", Area);
		data.setCellData(SheetName, "AreaSQFT", rowNum, CommonMethod.getattributeValue("PortfolioGrossAreaSQFT"));
		testlog.info("PortfolioGrossAreaSQFT: "+data.getCellData(SheetName, "AreaSQFT", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioPrimarlyLocated");
		CommonMethod.click("PortfolioPrimarlyLocated");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.click("PortfolioSpaceType");
		CommonMethod.click("PortfolioSelectSpaceType");
		CommonMethod.selectdropdownValue("PortfolioOwnerCountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerCountry"));
		testlog.info("PortfolioOwnerCountry: " +data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioOwnerState", 10);
		CommonMethod.selectdropdownrandom("PortfolioOwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerState"));
		testlog.info("PortfolioOwnerCountry: " +data.getCellData(SheetName, "State", rowNum));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("PortfolioOwnerStreetAddress", ProjectAddress1);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("PortfolioOwnerStreetAddress"));
		testlog.info("PortfolioOwnerStreetAddress: "+data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("PortfolioOwnerCity"));
		testlog.info("PortfolioOwnerCity: "+data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPostalCode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
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
		testlog.info("Portfolio Name:" +data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" +data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("PortfolioSearchApplyFilter");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
			"Portfolio ID doesn't matched with exceles in search");
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify","WPRHsrPortfolioDashboard");
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
		CommonMethod.Robustclick("SubscribeTab","PortfolioOwnerName");
		CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		String OwnerName = USfaker.address().firstName();
		String OwnerEmail = USfaker.internet().emailAddress();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("PortfolioOwnerName"));
		testlog.info("OwnerName: "+data.getCellData(SheetName, "OwnerName", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("PortfolioOwnerEmail"));
		testlog.info("OwnerEmail: "+data.getCellData(SheetName, "OwnerEmail", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		data.setCellData(SheetName, "OwnerPhone", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPhone"));
		testlog.info("OwnerPhone: "+data.getCellData(SheetName, "OwnerPhone", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton","PortfolioSubcribeContinueButton2");
		CommonMethod.ClickCheckbox("PortfolioQuestionRadio");
		CommonMethod.WaitUntilVisibility("PortfolioLocationDescriptionTextbox", 20);
		CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton2","PortfolioSubscribeDone");
		CommonMethod.RobustclickElementVisible("PortfolioSubscribeDone","PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		CommonMethod.Robustclick("PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.navigateBack();
		testlog.pass("**Verifies Subscribe Portfolio successfully**");
	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.RobustclickElementVisible("BiilingTab","V2ProjectPreBillingPayNowButton");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton","BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2Tab", 120);
		CommonMethod.RobustclickElementVisible("WellV2Tab","ScorecardTab");
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

	public void UpdateUploadFileinAddedFeature(String FeatureName) throws IOException, InterruptedException {
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
			}
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilVisibility("PortfolioDocListEditIcon", 60);
		CommonMethod.click("PortfolioDocListEditIcon");
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadAddfeature", 30);
		CommonMethod.click("PortfolioScoreCardVerificationUploadAddfeature");
		Thread.sleep(20000);
//			CommonMethod.selectdropdownIndex("PortfolioScoreCardVerificationSelectFeature", 1);
//			CommonMethod.selectdropdownIndex("PortfolioScoreCardVerificationSelectSpaceType", 1);
//			CommonMethod.selectdropdownIndex("PortfolioScoreCardVerificationSelectOption", 1);
//			CommonMethod.click("PortfolioScoreCardVerificationAddPart");
//			CommonMethod.WaitUntilVisibility("PortfolioScorecardEditLoc", 60);
//			CommonMethod.click("PortfolioScorecardEditLoc");
//			CommonMethod.click("PortfolioScoreCardVerificationAssignChildLocCbx");
//			CommonMethod.click("PortfolioScorecardUncheckLoc");
//			CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
//			CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn","PortfolioScoreCardVerificationAssignLocCancelbtn");
//				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
//				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn","PortfolioScoreCardVerificationAddNote");
//				if(CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
//				CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
		// }
	}

	public void clickDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("DocumentLibraryTab", 60);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab","PortfolioDocumentUploadbutton");
		testlog.pass("**Navigate Document successfully**");
	}

	public void ValidatingLegalUploadDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadbutton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton","V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "legal");
		CommonMethod.selectdropdownVisibletext("PortfolioSelectdocumenttype", "Signed certification agreement");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", LegalfileUpload);
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioDocumentList");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentList", 60);
//		CommonMethod.assertcontainsmessage("PortfolioDocumentList", "3", "Verified Upload File Count");
		testlog.pass("**Upload Document successfully**");
	}

	public void ReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab","Reviewlanding");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 30);
		CommonMethod.WaitUntilVisibility("PortfolioReviewSubmitButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitButton","OwnerOrgClick");
		CommonMethod.RobustclickElementVisible("OwnerOrgClick","PortfolioSelectProgram");
		CommonMethod.WaitUntilClickble("PortfolioSelectProgram", 10).click();
		CommonMethod.sendKeys("PortfolioReviewTextbox", "Submit Documentation for Year 1, Review Cycle #1");
		CommonMethod.click("PortfolioReviewSubmitDocButton");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListStatus", 120);
		CommonMethod.assertcontainsmessage("PortfolioReviewListStatus", "ROUND 1 REVIEW IN PROGRESS", "Verified Submitted Review list status");
		testlog.pass("**Submitted Documentation for Year 1, Review Cycle #1 successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLAtScaleNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLAtScaleNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLAtScaleNavBar","PortfolioSearchByID");
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("PortfolioAdminApplybtn");
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with excel in search");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify","ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab","PortfolioReviewListViewButton");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
		CommonMethod.click("PortfolioReviewListViewButton");
		CommonMethod.WaitUntilVisibility("PortfolioReturnReview", 60);
		CommonMethod.click("PortfolioReturnReview");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitResponse","PortfolioReviewStatus");
		CommonMethod.WaitUntilVisibility("PortfolioReviewStatus", 60);
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
	}
	public void registerFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 30);
		CommonMethod.RobustclickElementVisible("EditTab","PortfolioEditAccounttab");
		CommonMethod.WaitUntilVisibility("PortfolioEditAccounttab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioEditAccounttab","PortfolioEditAccountName");
		CommonMethod.WaitUntilVisibility("PortfolioEditAccountName", 30);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditAccountName"),
				data.getCellData(SheetName, "AccountName", rowNum), "Portfolio Project Name doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditApproximatelyLoc"),
				data.getCellData(SheetName, "Location", rowNum), "Portfolio Approximately Location doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditLocationSubscribing"),
				data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum), "Portfolio Location Subscribing doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("PortfolioEditAreaSqft").replace("sq ft", "").replace(",", "").trim(),
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
}
