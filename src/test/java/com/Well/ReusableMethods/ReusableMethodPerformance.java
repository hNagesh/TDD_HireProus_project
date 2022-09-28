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
		CommonMethod.click("WPREnrollOption");
		CommonMethod.click("WPRenrollbtn");
		String ProjectName = "Automation WPR Project" + CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName" + ProjectName);
		data.setCellData("Wpr", "projectName", 2, ProjectName);
		CommonMethod.sendKeys("WPROrgName", ProjectName);
		CommonMethod.ClickCheckbox("WPROwnerInfocbx");
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 6).click();
		data.setCellData("Wpr", "Org", 2, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " +data.getCellData(SheetName, "Org", rowNum));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData("Wpr", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdown("WPRExamOwnerCountry", "United States");
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Organization Address:" + ProjectAddress);
		testlog.info("Organization City:" + ProjectCity);
		testlog.info("Organization Postalcode:" + PostalCode);
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData("Wpr", "Country", 2, CommonMethod.getattributeValue("WPRExamOwnerCountry"));
		data.setCellData("Wpr", "State", 2, CommonMethod.getattributeValue("WPRExamOwnerState"));
		data.setCellData("Wpr", "Street", 2, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		data.setCellData("Wpr", "City", 2, CommonMethod.getattributeValue("WPRExamOrgCity"));
		data.setCellData("Wpr", "PostalCode", 2, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		CommonMethod.ClickCheckbox("WPROwnercbx");
		CommonMethod.scrollDown();
		CommonMethod.click("WPROrgContinebtn");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.ClickCheckbox("WPRBehalfCbx");
		CommonMethod.selectdropdown("WPRSelectMember", "No");
		data.setCellData("Wpr", "WPRSelectMember", 2, CommonMethod.getSelectedDropdownValue("WPRSelectMember"));
		CommonMethod.click("WPROwnerRegContinuebtn");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("WPRlocations", "10");
		data.setCellData("Wpr", "WPRlocations", 2, CommonMethod.getattributeValue("WPRlocations"));
		CommonMethod.click("HsrWPRlocationsSpacetype");
		CommonMethod.click("HsrWPRlocationsSpaceOption");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		CommonMethod.clear("WPRlocationsize");
		String Area = CommonMethod.randomNumberBetweenRanges(100,50000);
		testlog.info("Locationsize:" + Area);
		CommonMethod.sendKeys("WPRlocationsize", Area);
		data.setCellData("Wpr", "WPRlocationsize", 2, CommonMethod.getattributeValue("WPRlocationsize"));
		CommonMethod.WaitUntilClickble("WPROwnerRegContinuebtn", 60);
		CommonMethod.click("WPROwnerRegContinuebtn");
		if(CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 2)) {
		CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 30);
		CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
		}
		CommonMethod.click("WPRReviewContinuebutton");
		Thread.sleep(10000);
		if(CommonMethod.isElementsExist("WPRProgramFeePublicrbtn", 20)) {
		CommonMethod.WaitUntilClickble("WPRProgramFeePublicrbtn", 60);
		CommonMethod.ClickCheckbox("WPRProgramFeePublicrbtn");
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilClickble("WPRAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("WPRAcknowledecbx");
		CommonMethod.click("WPRtermContinuebutton");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdPerformance(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 50);
		CommonMethod.WaitUntilVisibility("StoreId", 30);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getWprId = stringArray[1].trim();
		testlog.info("Performance Id:" + getWprId);
		data.setCellData("Wpr", "wprId", 2, getWprId);
		testlog.info("Performance ID:" + getWprId);
		testlog.pass("**Stored the Registered id  into excel successfully**");
	}

	public void SearchPerformanceByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.click("WELLPerformanceRatingNavBar");
		String wprId = data.getCellData(SheetName, "wprId", rowNum);
		testlog.info("Performance ID:" + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		CommonMethod.click("WPRApplybtn");
		Thread.sleep(3000);
		CommonMethod.click("WPRIdClick");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 300);
		testlog.pass("**Verifies the Search Performance ByID successfully**");
	}

	public void PerformanceBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		v2project.Billing(SheetName, rowNum);
		testlog.pass("**Completed Card Payment Billing successfully**");
	}

	public void PerformanceLocation(String SheetName, int rowNum) throws IOException, InterruptedException {
		portfolio.PortfolioLocationImport(SheetName, rowNum);
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
			CommonMethod.click("WPRAddOption");
			CommonMethod.WaitUntilVisibility("WPRAddOptionbtn", 60);
			CommonMethod.Robustclick("WPRAddOptionbtn");
			CommonMethod.WaitUntilVisibility("WPRAddOptionCloseIcon", 60);
			CommonMethod.Robustclick("WPRAddOptionCloseIcon");
			CommonMethod.WaitUntilVisibility("WPRAssignLocbtn", 30);
			Thread.sleep(1000);
			CommonMethod.click("WPRAssignLocbtn");
			CommonMethod.WaitUntilClickble("WPRAssignLocFirstChildCbx", 60);
			CommonMethod.Robustclick("WPRAssignLocCbx", "WPRAssignDisabledbtn");
			CommonMethod.WaitUntilVisibility("WPRAssignSavebtn", 30);
			CommonMethod.click("WPRAssignSavebtn");
			CommonMethod.WaitUntilVisibility("WPRUploadDocTaskbtn", 60);
			CommonMethod.click("WPRUploadDocTaskbtn");
			CommonMethod.scrolldowntoLast();
			CommonMethod.uploadFile("WPRDocUpload", PortfolioLocationImportfile);
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
		Thread.sleep(3000);
		CommonMethod.click("ReviewTab");
		CommonMethod.click("WPRReviewSubmitbtn");
		CommonMethod.WaitUntilVisibility("WPRReviewSubmitDocbtn", 30);
		CommonMethod.selectdropdown("WPRReviewProjectPhase", "Preliminary Performance Rating Review");
		CommonMethod.WaitUntilClickble("WPRReviewComment", 60).sendKeys("Preliminary Performance Rating Review");
		CommonMethod.click("WPRReviewSubmitDocbtn");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		Thread.sleep(2000);
		testlog.pass("**Submitted Preliminary Precertification Review successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLPerformanceNavBar", 60);
		CommonMethod.click("AdminWELLPerformanceNavBar");
		CommonMethod.WaitUntilClickble("WPRAdminIdSearch", 60).sendKeys(data.getCellData(SheetName, "wprId", rowNum));
		CommonMethod.click("WPRAdminApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("WPRAdminIdClick");
		Thread.sleep(3000);
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
		CommonMethod.click("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status successfully");
		testlog.pass("**Completed Reviewing Preliminary Precertification Review successfully**");
	}

	public void UploadWPRDocument() throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("DocumentLibraryTab", 300);
		CommonMethod.click("DocumentLibraryTab");
		CommonMethod.WaitUntilVisibility("WPRUploadDocLib", 60);
		CommonMethod.click("WPRUploadDocLib");
		CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
		CommonMethod.selectdropdownIndex("WPRSelectDocType", 1);
		CommonMethod.selectdropdownIndex("WPRSelectType", 1);
		CommonMethod.uploadFile("WPRDocUpload", PortfolioLocationImportfile);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WPRAddNote", "Submitting Document");
		CommonMethod.Robustclick("WPRSumbitUploadDocLib");
		testlog.pass("**Upload Document successfully**");
	}
}
