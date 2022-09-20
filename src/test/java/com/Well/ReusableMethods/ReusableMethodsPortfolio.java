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
		CommonMethod.WaitUntilVisibility("CreateAccountButton", 60);
		CommonMethod.click("CreateAccountButton");
		String AccountName = "Automation portfolio " + CommonMethod.randomNumber(8000000);
		CommonMethod.WaitUntilVisibility("AccountName", 30);
		CommonMethod.sendKeys("AccountName", AccountName);
		data.setCellData("Portfolio", "AccountName", 2, AccountName);
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData("Portfolio", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.click("NotSureRadio");
		CommonMethod.sendKeys("NumberOfLocation", "15");
		CommonMethod.sendKeys("EstimatedNumberOfLocation", "10");
		CommonMethod.sendKeys("GrossAreaSQFT", "15000");
		CommonMethod.scrolldowntoElement("PrimarlyLocated");
		CommonMethod.click("PrimarlyLocated");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.click("SpaceType");
		CommonMethod.WaitUntilClickble("SelectSpaceType", 10);
		CommonMethod.click("SelectSpaceType");
		CommonMethod.selectdropdown("OwnerCountry", "United States");
		CommonMethod.WaitUntilVisibility("OwnerState", 10);
		CommonMethod.selectdropdownrandom("OwnerState");
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("OwnerStreetAddress", ProjectAddress1);
		CommonMethod.sendKeys("OwnerCity", ProjectCity);
		CommonMethod.sendKeys("OwnerPostalCode", PostalCode);
		CommonMethod.click("CreateAccountSubmit");
		CommonMethod.WaitUntilVisibility("StoreId", 60);
	}

	public void SearchPortfolioByName(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WellAtScaleNavBar");
		CommonMethod.WaitUntilClickble("SearchPortfolioByName", 60)
				.sendKeys(data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.click("SearchPortfolioApplyFilter");
		Thread.sleep(2000);
		CommonMethod.click("ClickSearchResultPortfolio");

	}

	public void SignAgreementPortfolio() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ClickPortfolioSignNow", 60);
		CommonMethod.Robustclick("ClickPortfolioSignNow");
	}

	public void SubscribePortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("SubscribeTab", 30);
		CommonMethod.click("SubscribeTab");
		CommonMethod.waitForPageLoaded();
		CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		String OwnerName = USfaker.address().firstName();
		String OwnerEmail = USfaker.internet().emailAddress();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		// CommonMethod.click("PortfolioNoConsultantCheckbox");
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

	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.click("BiilingTab");
		CommonMethod.WaitUntilVisibility("PortfolioPayNowButton", 20);
		CommonMethod.click("PortfolioPayNowButton");
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
	}

	public void PortfolioCardPayment(String SheetName, int rowNum) throws IOException, InterruptedException {
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
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("LocationsTab", 60);
		CommonMethod.click("LocationsTab");
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

	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("WellV2Tab", 60);
		CommonMethod.click("WellV2Tab");
		CommonMethod.click("WellV2ScorecardTab");
		if (CommonMethod.isElementsExist("PortfolioScorecardFinishedButton", 60)) {
			Thread.sleep(2000);
			CommonMethod.click("PortfolioScorecardFinishedButton");
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPopupButton", 60);
			CommonMethod.click("PortfolioScorecardPopupButton");
		}
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", 300);
	}

	public void UploadFileinFeature() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScoreCardMeetOrgFeature", 60);
		CommonMethod.click("ScoreCardMeetOrgFeature");
		CommonMethod.WaitUntilVisibility("ScorecardFeatureVerificationTab", 60);
		CommonMethod.click("ScorecardFeatureVerificationTab");
		CommonMethod.WaitUntilVisibility("ScoreCardAddOptionbutton", 10);
		CommonMethod.click("ScoreCardAddOptionbutton");
		CommonMethod.WaitUntilVisibility("ScoreCardAddButton", 10);
		CommonMethod.Robustclick("ScoreCardAddButton");
		CommonMethod.WaitUntilVisibility("ScoreCardVerificationCloseicon", 10);
		CommonMethod.Robustclick("ScoreCardVerificationCloseicon");
		for (int i = 1; i <= 2; i++) {
			Thread.sleep(2000);
			CommonMethod.WaitUntilVisibility("ScoreCardVerificationAssignbtn", 60);
			CommonMethod.click("ScoreCardVerificationAssignbtn");
			CommonMethod.WaitUntilClickble("ScoreCardVerificationAssignChildLocCbx", 30);
			CommonMethod.Robustclick("ScoreCardVerificationAssignLocCbx", "ScorecardValidDisable");
			CommonMethod.WaitUntilVisibility("ScoreCardVerificationAssignLocSavebtn", 30);
			CommonMethod.click("ScoreCardVerificationAssignLocSavebtn");
		}
		Thread.sleep(2000);
		CommonMethod.scrollDown();
		List<WebElement> UploadTaskbtn;
		UploadTaskbtn = CommonMethod.findElements("ScoreCardVerificationUploadbtn");
		UploadTaskbtn = UploadTaskbtn.subList(0, 2);
		for (WebElement f : UploadTaskbtn) {
			CommonMethod.click(f);
			CommonMethod.scrolldowntoLast();
			CommonMethod.uploadFile("ScoreCardVerificationUpload", PortfolioLocationImportfile);
			CommonMethod.WaitUntilVisibility("ScoreCardVerificationUploadDocbtn", 30);
			CommonMethod.Robustclick("ScoreCardVerificationUploadDocbtn");
		}
		CommonMethod.WaitUntilVisibility("ScorecardVerifyLoc", 30);
		CommonMethod.scrolldowntoElement("ScoreCardPageLand");
		CommonMethod.click("ScoreCardMeetOrgFeature");
	}

	public void UploadFileinAudit() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScoreCardSupportOrgFeature", 60);
		CommonMethod.click("ScoreCardSupportOrgFeature");
		CommonMethod.WaitUntilVisibility("ScorecardFeatureVerificationTab", 60);
		CommonMethod.click("ScorecardFeatureVerificationTab");
		CommonMethod.WaitUntilVisibility("ScoreCardAddOptionbutton", 10);
		CommonMethod.click("ScoreCardAddOptionbutton");
		CommonMethod.WaitUntilVisibility("ScoreCardAddButton", 10);
		CommonMethod.Robustclick("ScoreCardAddButton");
		CommonMethod.WaitUntilVisibility("ScoreCardVerificationCloseicon", 10);
		CommonMethod.Robustclick("ScoreCardVerificationCloseicon");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("ScoreCardVerificationAssignbtn", 60);
		CommonMethod.click("ScoreCardVerificationAssignbtn");
		CommonMethod.WaitUntilClickble("ScoreCardVerificationAssignChildLocCbx", 30);
		CommonMethod.Robustclick("ScoreCardVerificationAssignLocCbx", "ScorecardValidDisable");
		CommonMethod.WaitUntilVisibility("ScoreCardVerificationAssignLocSavebtn", 30);
		CommonMethod.click("ScoreCardVerificationAssignLocSavebtn");
		Thread.sleep(2000);
		CommonMethod.scrolldowntoLast();
		CommonMethod.WaitUntilVisibility("ScoreCardVerificationUploadbtn", 60);
		CommonMethod.click("ScoreCardVerificationUploadbtn");
		CommonMethod.scrolldowntoLast();
		CommonMethod.uploadFile("ScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("ScoreCardVerificationUploadDocbtn", 30);
		CommonMethod.Robustclick("ScoreCardVerificationUploadDocbtn");
	}

	public void clickDocument() throws IOException {
		CommonMethod.WaitUntilVisibility("WellV2Tab", 60);
		CommonMethod.click("WellV2Tab");
		CommonMethod.WaitUntilVisibility("WellV2DocLibraryTab", 60);
		CommonMethod.click("WellV2DocLibraryTab");
	}

	public void ValidatingUploadFileCount() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectDocumentTab", 30);
		CommonMethod.click("V2ProjectDocumentTab");
		CommonMethod.WaitUntilVisibility("DocumentList", 60);
		CommonMethod.assertcontainsmessage("DocumentList", "3", "Verified Upload File Count");
	}

}
