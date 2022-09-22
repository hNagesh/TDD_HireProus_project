package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsPortfolio extends BaseClass {

	public void RegisterPortfolio() throws IOException, InterruptedException {
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
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData("Portfolio", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.click("PortfolioNotSureRadio");
		CommonMethod.sendKeys("PortfolioNumberOfLocation", "15");
		CommonMethod.sendKeys("PortfolioEstimatedNumberOfLocation", "10");
		CommonMethod.sendKeys("PortfolioGrossAreaSQFT", "15000");
		CommonMethod.scrolldowntoElement("PortfolioPrimarlyLocated");
		CommonMethod.click("PortfolioPrimarlyLocated");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.click("PortfolioSpaceType");
		CommonMethod.click("PortfolioSelectSpaceType");
		CommonMethod.selectdropdown("PortfolioOwnerCountry", "United States");
		CommonMethod.WaitUntilVisibility("PortfolioOwnerState", 10);
		CommonMethod.selectdropdownrandom("PortfolioOwnerState");
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("PortfolioOwnerStreetAddress", ProjectAddress1);
		CommonMethod.sendKeys("PortfolioOwnerCity", ProjectCity);
		CommonMethod.sendKeys("PortfolioOwnerPostalCode", PostalCode);
		CommonMethod.click("PortfolioCreateAccountSubmit");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
	}

	public void SearchPortfolioByName(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WellAtScaleNavBar");
		CommonMethod.WaitUntilClickble("PortfolioSearchByName", 60)
				.sendKeys(data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.click("PortfolioSearchApplyFilter");
		Thread.sleep(2000);
		CommonMethod.click("PortfolioClickSearchResult");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
	}

	public void SignAgreementPortfolio() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("PortfolioClickSignNow", 60);
		CommonMethod.Robustclick("PortfolioClickSignNow");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
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
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		CommonMethod.click("PortfolioSubcribeContinueButton");
		CommonMethod.ClickCheckbox("PortfolioQuestionRadio");
		CommonMethod.WaitUntilVisibility("PortfolioLocationDescriptionTextbox", 20);
		CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		CommonMethod.click("PortfolioSubcribeContinueButton2");
		CommonMethod.click("PortfolioSubscribeDone");
		CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		CommonMethod.Robustclick("PortfolioGoToBilling");
		CommonMethod.navigateBack();
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 30);
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.click("BiilingTab");
		CommonMethod.WaitUntilVisibility("PortfolioPayNowButton", 20);
		CommonMethod.click("PortfolioPayNowButton");
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
	}

	public void PortfolioCardPayment(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BillingLanding", 300);
		if (!CommonMethod.isElementsExist("CardHolderName", 3)) {
			Boolean B = CommonMethod.IsElementPresentTrue("PortfolioPayNowButton");
			if (B.equals(true)) {
				CommonMethod.click("PortfolioPayNowButton");
			}
		}
		CommonMethod.scrolldowntoElement("CardHolderName");
		CommonMethod.WaitUntilClickble("CardHolderName", 60).sendKeys(USfaker.address().firstName());
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardNumberIframe");
		CommonMethod.WaitUntilClickble("CardHolderNumber", 60).sendKeys("4111111111111111");
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardExpDateIframe");
		CommonMethod.WaitUntilClickble("CardHolderExpDate", 60).sendKeys("0925");
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardCVVIframe");
		CommonMethod.WaitUntilClickble("CardHolderCVC", 60).sendKeys("999");
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.click("PayNowButton");
		Thread.sleep(2000);
	}

	public void PortfolioLocationImport(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("LocationsTab", 60);
		CommonMethod.click("LocationsTab");
		CommonMethod.WaitUntilVisibility("PortfolioLocationLanding", 60);
		CommonMethod.click("PortfolioLocationsImportButton");
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
		
	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2Tab", 120);
		CommonMethod.click("WellV2Tab");
		CommonMethod.click("WellV2ScorecardTab");
		if (CommonMethod.isElementsExist("PortfolioScorecardFinishedButton", 30)) {
			Thread.sleep(2000);
			CommonMethod.click("PortfolioScorecardFinishedButton");
			Thread.sleep(2000);
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPopupButton", 30);
			CommonMethod.click("PortfolioScorecardPopupButton");
		}
		CommonMethod.WaitUntilVisibility("PortFolioScoreCardPageLand", 300);
	}

	public void UploadFileinFeature(String FeatureName) throws IOException, InterruptedException {
	List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
	testlog.info("Fetching total no. of credits on page");
	for (WebElement ele : Feature) {
		  String Creditname = ele.getText(); 
		  Creditname = Creditname.replaceAll("\\.",""); 
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
			CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx", "PortfolioScorecardValidDisable");
			CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
			CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn","PortfolioScoreCardVerificationAssignLocCancelbtn");
		}
		Thread.sleep(2000);
		CommonMethod.scrollDown();
		List<WebElement> UploadTaskbtn;
		UploadTaskbtn = CommonMethod.findElements("PortfolioScoreCardVerificationUploadbtn");
		for (WebElement f : UploadTaskbtn) {
			CommonMethod.WaitUntilClickble(f, 30).click();
			CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
			CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
			CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn","PortfolioScoreCardVerificationAddNote");
			if(CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
			}
		}
		CommonMethod.WaitUntilVisibility("PortfolioScorecardVerifyLoc", 30);
		CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
		CommonMethod.click(ele);
	}
	}
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
	}
	public void UpdateUploadFileinAddedFeature(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			  String Creditname = ele.getText(); 
			  Creditname = Creditname.replaceAll("\\.",""); 
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
			CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadAddfeature", 30);
			CommonMethod.click("PortfolioScoreCardVerificationUploadAddfeature");
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
			//	}	
	}
	public void clickDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2Tab", 60);
		CommonMethod.click("WellV2Tab");
		CommonMethod.WaitUntilVisibility("WellV2DocLibraryTab", 60);
		CommonMethod.click("WellV2DocLibraryTab");
	}

	public void ValidatingUploadDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadbutton", 30);
		CommonMethod.click("PortfolioDocumentUploadbutton");	
		CommonMethod.selectdropdownIndex("V2ProjectPortfolioDocType", 1);
		CommonMethod.selectdropdownIndex("PortfolioSelectdocumenttype", 1);
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		CommonMethod.WaitUntilClickble("PortfolioDocumentListLink", 30).click();
	CommonMethod.WaitUntilVisibility("PortfolioDocumentList", 60);
//		CommonMethod.assertcontainsmessage("PortfolioDocumentList", "3", "Verified Upload File Count");
	}
	public void ReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 30);
		CommonMethod.click("ReviewTab");	
		CommonMethod.WaitUntilVisibility("PortfolioReviewSubmitButton", 30);
		CommonMethod.click("PortfolioReviewSubmitButton");
		CommonMethod.WaitUntilVisibility("PortfolioReviewlanding", 30);
		CommonMethod.WaitUntilVisibility("PortfolioReviewTextbox", 30);
		CommonMethod.sendKeys("PortfolioReviewTextbox", "Submit Documentation for Year 1, Review Cycle #1");
		CommonMethod.click("PortfolioReviewSubmitDocButton");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
	
	/*
	 * Admin Review
	 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLAtScaleNavBar", 60);
		CommonMethod.click("AdminWELLAtScaleNavBar");
		CommonMethod.WaitUntilClickble("PortfolioAdminNameSearch", 60).sendKeys(data.getCellData(SheetName, "AccountName", rowNum));
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
			}
	
}
