package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodPerformance extends BaseClass {

	public void RegisterPerformance(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WPRstartNewProject", 60);
		CommonMethod.click("WPRstartNewProject");
		CommonMethod.RobustclickElementVisible("WPREnrollOption", "WPRenrollbtn");
		CommonMethod.RobustclickElementVisible("WPRenrollbtn", "WPROrgContinebtn");
		String ProjectName = "Automation WPR Project" + CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: " + ProjectName);
		data.setCellData(SheetName, "projectName", rowNum, ProjectName);
		CommonMethod.sendKeys("WPROrgName", ProjectName);
		CommonMethod.ClickCheckbox("WPROwnerInfocbx");
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("WPRExamOwnerCountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Organization Address: " + ProjectAddress);
		testlog.info("Organization City: " + ProjectCity);
		testlog.info("Organization Postalcode: " + PostalCode);
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("WPRExamOwnerCountry"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WPRExamOwnerState"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WPRExamOrgCity"));
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		CommonMethod.ClickCheckbox("WPROwnercbx");
		CommonMethod.scrollDown();
		CommonMethod.RobustclickElementVisible("WPROrgContinebtn", "WPROwnerRegContinuebtn");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.ClickCheckbox("WPRBehalfCbx");
		CommonMethod.selectdropdownVisibletext("WPRSelectMember", "No");
		data.setCellData(SheetName, "WPRSelectMember", rowNum,
				CommonMethod.getSelectedDropdownValue("WPRSelectMember"));
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn","WPRlocations");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("WPRlocations", "10");
		data.setCellData(SheetName, "WPRlocations", rowNum, CommonMethod.getattributeValue("WPRlocations"));
		CommonMethod.click("HsrWPRlocationsSpacetype");
		CommonMethod.click("HsrWPRlocationsSpaceOption");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		testlog.info("Locationsize: " + Area);
		CommonMethod.clearAndSendKey("WPRlocationsize", Area);
		data.setCellData(SheetName, "WPRlocationsize", rowNum, CommonMethod.getattributeValue("WPRlocationsize"));
		CommonMethod.WaitUntilClickble("WPROwnerRegContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn", "WPRReviewContinuebutton");
		if (CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 2)) {
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 30);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
		}
		CommonMethod.RobustclickElementVisible("WPRReviewContinuebutton", "WPRtermContinuebutton");
		if (CommonMethod.isElementsExist("WPRProgramFeePublicrbtn", 20)) {
			CommonMethod.WaitUntilClickble("WPRProgramFeePublicrbtn", 60);
			CommonMethod.ClickCheckbox("WPRProgramFeePublicrbtn");
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilClickble("WPRAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("WPRAcknowledecbx");
		CommonMethod.RobustclickElementVisible("WPRtermContinuebutton", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdPerformance(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("HsrIframe", 180);
		CommonMethod.switchToFrame("HsrIframe");
		CommonMethod.WaitUntilPresence("HsrCloseCard", 60);
		CommonMethod.Robustclick("HsrCloseCard");
		CommonMethod.switchToParentFrame();	
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		CommonMethod.WaitUntilVisibility("StoreId", 30);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getWprId = stringArray[1].trim();
		testlog.info("Performance Id: " + getWprId);
		data.setCellData(SheetName, "ProjectID", rowNum, getWprId);
		testlog.info("Performance ID: " + getWprId);
		testlog.pass("**Stored the Registered id  into excel successfully**");
	}

	public void SearchPerformanceByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		CommonMethod.click("WPRApplybtn");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Portfolio Search failed");
		CommonMethod.assertcontainsmessage("WPRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.click("WPRIdClick");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		testlog.pass("**Verifies the Search Performance ByID successfully**");
	}

	public void ScorecardfillHSRWPR(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne, String purseYes,
			String purseNo) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		YesButton = CommonMethod.findElements(purseYes);
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			do {
				CommonMethod.click(purseYes);
				CommonMethod.WaitUntilVisibility("WPRCloseIcon", 30);
				CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 30);
				YesButton = CommonMethod.findElements(purseYes);
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements(purseNo);
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
				CommonMethod.WaitUntilClickble(NoButton.get(RemainingNo - j), 30);
				CommonMethod.click(NoButton.get(RemainingNo - j));
				CommonMethod.WaitUntilVisibility("WPRCloseIcon", 30);
				CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 30);
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements(purseNo);
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
	}

	public void CompleteScorecardWprById(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(3000);
		CommonMethod.WaitUntilVisibility("ScorecardTab", 60);
		CommonMethod.click("ScorecardTab");
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", 300);
		ScorecardfillHSRWPR(21, 21, 36, 16, "WPRPurseYes", "WPRPurseNo");
		testlog.pass("**Verifies the 15 Purse Yes Scorecard Performance successfully**");
	}

	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
		for (WebElement f : Feature) {
			CommonMethod.click(f);
			CommonMethod.WaitUntilVisibility("WPRVerficationTab", 60);
			CommonMethod.click("WPRVerficationTab");
			CommonMethod.WaitUntilVisibility("WPRAddOption", 60);
			CommonMethod.JavascriptClickElement("WPRAddOption");
			CommonMethod.WaitUntilVisibility("WPRAddOptionbtn", 60);
			CommonMethod.Robustclick("WPRAddOptionbtn");
			CommonMethod.WaitUntilVisibility("WPRAddOptionCloseIcon", 60);
			CommonMethod.Robustclick("WPRAddOptionCloseIcon");
			CommonMethod.WaitUntilVisibility("WPRAssignLocbtn", 30);
			Thread.sleep(1000);
			CommonMethod.click("WPRAssignLocbtn");
			CommonMethod.WaitUntilPresence("WPRAssignLocCbx", 60);
			CommonMethod.Robustclick("WPRAssignLocCbx", "WPRAssignDisabledbtn");
			CommonMethod.WaitUntilVisibility("WPRAssignSavebtn", 30);
			CommonMethod.click("WPRAssignSavebtn");
			CommonMethod.WaitUntilVisibility("WPRUploadDocTaskbtn", 60);
			CommonMethod.click("WPRUploadDocTaskbtn");
			CommonMethod.scrolldowntoLast();
			CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload);
			Thread.sleep(2000);
			CommonMethod.Robustclick("WPRUploadDocTaskSavebtn");
			CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
			CommonMethod.click(f);
		}

	}

	public void UploadWPRDocForFeature() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", 300);
		uploadDocumentInFeature(21);
		testlog.pass("**Upload 21 Scorecard Documents successfully**");
	}

	public void WPRReview(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab","WPRReviewSubmitbtn");
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitbtn","WPRReviewProjectPhase");
		CommonMethod.selectdropdownVisibletext("WPRReviewProjectPhase", "Preliminary Performance Rating Review");
		CommonMethod.WaitUntilClickble("WPRReviewComment", 60).sendKeys("Preliminary Performance Rating Review");
		CommonMethod.WaitUntilVisibility("WPRReviewSubmitDocbtn", 30);
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitDocbtn","ReviewViewButton");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		testlog.pass("**Submitted Preliminary Precertification Review successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLPerformanceNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLPerformanceNavBar", "WPRAdminIdSearch");
		CommonMethod.WaitUntilClickble("WPRAdminIdSearch", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("WPRAdminApplybtn");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("WPRAdminIdClick", data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.click("WPRAdminIdClick");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.click("ReviewViewButton");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 60);
		CommonMethod.click("ReviewReturnButton");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.click("DatePickerButton");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status successfully");
		testlog.pass("**Completed Reviewing Preliminary Precertification Review successfully**");
	}
	public void WprProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 120);
		CommonMethod.RobustclickElementVisible("EditTab","HsrWprOrganizationInformation");
		CommonMethod.WaitUntilVisibility("HsrWprOrganizationInformation", 60);
		CommonMethod.RobustclickElementVisible("HsrWprOrganizationInformation","HsrWprEditProjectName");
		CommonMethod.WaitUntilVisibility("HsrWprEditProjectName", 30);
		testlog.info("projectName: " + data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditProjectName"),
				data.getCellData(SheetName, "projectName", rowNum), "Project Name doesn't match");
		testlog.info("WPRlocationsize: " + data.getCellData(SheetName, "WPRlocationsize", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditArea").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "WPRlocationsize", rowNum), "Area doesn't match");
		testlog.info("WPRlocations: " + data.getCellData(SheetName, "WPRlocations", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "WPRlocations", rowNum), "Location count doesn't match");
		testlog.info("OrgName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "OrgName doesn't match");
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("HsrWprEditOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "OrgIndustry doesn't match");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"));
		  CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownAttribute(
		  "HsrWprEditCountry"), data.getCellData(SheetName, "Country", rowNum),
		  "Country doesn't match");
		 testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("HsrWprEditState"),
				data.getCellData(SheetName, "State", rowNum), "State Name doesn't match");
		testlog.info("Street: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Street Name doesn't match");
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditCity"),
				data.getCellData(SheetName, "City", rowNum), "City doesn't match");
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "PostalCode doesn't match");
        softAssert.assertAll();
        testlog.pass("**Verifies the Wpr Field Validation successfully**");
	}
	
	public void validateTeamsWPR(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		CommonMethod.RobustclickElementVisible("WPRApplybtn","WELLPerformanceRatingNavBar");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("WELLPerformanceRatingNavBar", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","Portfolio Search failed");
		CommonMethod.assertcontainsmessage("WPRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		testlog.pass("**Verifies user able to access the invited project**");
	}
	public void clikOnDocumentLibrary() throws InterruptedException, IOException {
		CommonMethod.WaitUntilPresence("DocumentLibraryTab", 300);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab","WPRUploadDocLib");
	}
	public void validateGeneralUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("WPRUploadDocLib", 120);
		CommonMethod.RobustclickElementVisible("WPRUploadDocLib","WPRSelectDocType");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "general");
		CommonMethod.selectdropdownrandom("WPRHSRDocumentType");
		CommonMethod.scrollDown();
		CommonMethod.uploadFile("WPRDocUpload", GeneralfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "General", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload General Document successfully**");	
	}
	public void validateLegalUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("WPRUploadDocLib", 120);
		CommonMethod.RobustclickElementVisible("WPRUploadDocLib","WPRSelectDocType");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "legal");
		CommonMethod.selectdropdownrandom("WPRHSRDocumentType");
		CommonMethod.scrollDown();
		CommonMethod.uploadFile("WPRDocUpload", LegalfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Legal", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Legal Document successfully**");	
	}
	public void validateAuditUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("WPRUploadDocLib", 120);
		CommonMethod.RobustclickElementVisible("WPRUploadDocLib","WPRSelectDocType");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "audit");
		CommonMethod.selectdropdownrandom("WPRHSRDocumentType");
		CommonMethod.scrollDown();
		CommonMethod.uploadFile("WPRDocUpload", AuditfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Audit", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");	
	}
	public void validateFeatureUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("WPRUploadDocLib", 120);
		CommonMethod.click("WPRUploadDocLib");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownValue("WPRSelectDocType", "feature");
		CommonMethod.selectdropdownrandom("WPRHSRDocumentType");
		CommonMethod.scrollDown();
		CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRHSRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioScorecardDocumentUploadTable");
		CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentUploadTable", 120);
		CommonMethod.scrolldowntoElement("PortfolioScorecardDocumentUploadTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
		CommonMethod.softAssertContainsMessage(val.get(6), "Feature", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Feature Document successfully**");		
	}
}
