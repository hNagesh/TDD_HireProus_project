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
		CommonMethod.click("WellAtScaleNavBar");
		CommonMethod.WaitUntilVisibility("PortfolioCreateAccountButton", 60);
		CommonMethod.click("PortfolioCreateAccountButton");
		String AccountName = "Automation portfolio " + CommonMethod.randomNumber(8000000);
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 30);
		CommonMethod.sendKeys("PortfolioAccountName", AccountName);
		data.setCellData("Portfolio", "AccountName", 2, AccountName);
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 6).click();
		CommonMethod.WaitUntilVisibility("OrgName", 60);
		data.setCellData("Portfolio", "OrganizationName", 2, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " +data.getCellData(SheetName, "OrganizationName", rowNum));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData("Portfolio", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		testlog.info("OrgIndustry: " +data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.click("PortfolioNotSureRadio");
		CommonMethod.sendKeys("PortfolioNumberOfLocation", "15");
		data.setCellData("Portfolio", "Location", 2, CommonMethod.getattributeValue("PortfolioNumberOfLocation"));
		testlog.info("PortfolioNumberOfLocation: "+data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.sendKeys("PortfolioEstimatedNumberOfLocation", "10");
		data.setCellData("Portfolio", "EstimatedNumberOfLocation", 2, CommonMethod.getattributeValue("PortfolioEstimatedNumberOfLocation"));
		testlog.info("EstimatedNumberOfLocation: "+data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100,50000);
		CommonMethod.sendKeys("PortfolioGrossAreaSQFT", Area);
		data.setCellData("Portfolio", "AreaSQFT", 2, CommonMethod.getattributeValue("PortfolioGrossAreaSQFT"));
		testlog.info("PortfolioGrossAreaSQFT: "+data.getCellData(SheetName, "AreaSQFT", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioPrimarlyLocated");
		CommonMethod.click("PortfolioPrimarlyLocated");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.click("PortfolioSpaceType");
		CommonMethod.click("PortfolioSelectSpaceType");
		CommonMethod.selectdropdown("PortfolioOwnerCountry", "United States");
		data.setCellData("Portfolio", "Country", 2, CommonMethod.getSelectedDropdownValue("PortfolioOwnerCountry"));
		testlog.info("PortfolioOwnerCountry: " +data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioOwnerState", 10);
		CommonMethod.selectdropdownrandom("PortfolioOwnerState");
		data.setCellData("Portfolio", "State", 2, CommonMethod.getSelectedDropdownValue("PortfolioOwnerState"));
		testlog.info("PortfolioOwnerCountry: " +data.getCellData(SheetName, "State", rowNum));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("PortfolioOwnerStreetAddress", ProjectAddress1);
		data.setCellData("Portfolio", "Street", 2, CommonMethod.getattributeValue("PortfolioOwnerStreetAddress"));
		testlog.info("PortfolioOwnerStreetAddress: "+data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerCity", ProjectCity);
		data.setCellData("Portfolio", "City", 2, CommonMethod.getattributeValue("PortfolioOwnerCity"));
		testlog.info("PortfolioOwnerCity: "+data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPostalCode", PostalCode);
		data.setCellData("Portfolio", "PostalCode", 2, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.click("PortfolioCreateAccountSubmit");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void SearchPortfolioByName(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WellAtScaleNavBar");
		testlog.info("Portfolio Name:" +data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByName", 60)
				.sendKeys(data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.click("PortfolioSearchApplyFilter");
		Thread.sleep(2000);
		CommonMethod.click("PortfolioClickSearchResult");
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
		CommonMethod.click("SubscribeTab");
		CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		String OwnerName = USfaker.address().firstName();
		String OwnerEmail = USfaker.internet().emailAddress();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		data.setCellData("Portfolio", "OwnerName", 2, CommonMethod.getattributeValue("PortfolioOwnerName"));
		testlog.info("OwnerName: "+data.getCellData(SheetName, "OwnerName", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		data.setCellData("Portfolio", "OwnerEmail", 2, CommonMethod.getattributeValue("PortfolioOwnerEmail"));
		testlog.info("OwnerEmail: "+data.getCellData(SheetName, "OwnerEmail", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		data.setCellData("Portfolio", "OwnerPhone", 2, CommonMethod.getattributeValue("PortfolioOwnerPhone"));
		testlog.info("OwnerPhone: "+data.getCellData(SheetName, "OwnerPhone", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		CommonMethod.click("PortfolioSubcribeContinueButton");
		CommonMethod.ClickCheckbox("PortfolioQuestionRadio");
		CommonMethod.WaitUntilVisibility("PortfolioLocationDescriptionTextbox", 20);
		CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
		data.setCellData("Portfolio", "PostalCode", 2, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		CommonMethod.click("PortfolioSubcribeContinueButton2");
		CommonMethod.click("PortfolioSubscribeDone");
		CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		CommonMethod.Robustclick("PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("PortfolioPayNowButton", 20);
		CommonMethod.navigateBack();
		testlog.pass("**Verifies Subscribe Portfolio successfully**");
	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.click("BiilingTab");
		CommonMethod.WaitUntilVisibility("PortfolioPayNowButton", 20);
		CommonMethod.click("PortfolioPayNowButton");
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void PortfolioCardPayment(String SheetName, int rowNum) throws IOException, InterruptedException {
		v2project.Billing(SheetName, rowNum);
	}

	public void PortfolioLocationImport(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("LocationsTab", 60);
		CommonMethod.click("LocationsTab");
		CommonMethod.WaitUntilVisibility("PortfolioLocationLanding", 60);
		CommonMethod.RobustclickElementVisible("PortfolioLocationsImportButton","PortfolioUploadFileNextButton");
		CommonMethod.scrolldowntoElement("PortfolioUploadLocationButton");
		CommonMethod.uploadFile("PortfolioUploadLocationButton", PortfolioLocationImportfile);
		CommonMethod.click("PortfolioUploadFileNextButton");
		if (CommonMethod.isElementsExist("PortfolioUnmatchFieldcbx", 3)) {
			CommonMethod.WaitUntilVisibility("PortfolioUnmatchFieldcbx", 30);
			CommonMethod.ClickCheckbox("PortfolioUnmatchFieldcbx");
		}
		CommonMethod.WaitUntilVisibility("PortfolioUploadFileNextButton", 30);
		CommonMethod.click("PortfolioUploadFileNextButton");
		CommonMethod.WaitUntilVisibility("PortfolioFinishImportButton", 30);
		CommonMethod.click("PortfolioFinishImportButton");
		CommonMethod.WaitUntilVisibility("PortfolioImportCloseButton", 30);
		CommonMethod.click("PortfolioImportCloseButton");
		CommonMethod.WaitUntilVisibility("PortfolioLocationLanding", 60);
		testlog.pass("**Imported Locations successfully**");
	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2Tab", 120);
		CommonMethod.click("WellV2Tab");
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
					CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
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
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
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
		CommonMethod.click("DocumentLibraryTab");
		testlog.pass("**Navigate Document successfully**");
	}

	public void ValidatingUploadDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadbutton", 30);
		CommonMethod.click("PortfolioDocumentUploadbutton");
		CommonMethod.selectdropdown("V2ProjectPortfolioDocType", "general");
		CommonMethod.selectdropdown("PortfolioSelectdocumenttype", "Project overview");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		CommonMethod.WaitUntilClickble("PortfolioDocumentListLink", 30).click();
		CommonMethod.WaitUntilVisibility("PortfolioDocumentList", 60);
//		CommonMethod.assertcontainsmessage("PortfolioDocumentList", "3", "Verified Upload File Count");
		testlog.pass("**Upload Document successfully**");
	}

	public void ReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 30);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("PortfolioReviewSubmitButton", 30);
		CommonMethod.click("PortfolioReviewSubmitButton");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 30);
		CommonMethod.WaitUntilVisibility("PortfolioReviewTextbox", 30);
		CommonMethod.sendKeys("PortfolioReviewTextbox", "Submit Documentation for Year 1, Review Cycle #1");
		CommonMethod.click("PortfolioReviewSubmitDocButton");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListStatus", 120);
		CommonMethod.assertcontainsmessage("PortfolioReviewListStatus", "ROUND 1 REVIEW IN PROGRESS", "Verified Submitted Review list status");
		testlog.pass("**Submitted Documentation for Year 1, Review Cycle #1 successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLAtScaleNavBar", 60);
		CommonMethod.click("AdminWELLAtScaleNavBar");
		CommonMethod.WaitUntilClickble("PortfolioAdminNameSearch", 60)
				.sendKeys(data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.click("PortfolioAdminApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("PortfolioAdminIdClick");
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
		CommonMethod.click("PortfolioReviewListViewButton");
		CommonMethod.WaitUntilVisibility("PortfolioReturnReview", 60);
		CommonMethod.click("PortfolioReturnReview");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.click("PortfolioReviewSubmitResponse");
		CommonMethod.WaitUntilVisibility("PortfolioReviewStatus", 60);
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
	}

}
