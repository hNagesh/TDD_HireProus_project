package com.Well.ReusableMethods;

import java.io.IOException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsPortfolio extends BaseClass {
	
	public void RegisterPortfolio() throws IOException, InterruptedException {

	   CommonMethod.click("ProjectNavBar");
	   CommonMethod.WaitUntilClickble("WellAtScaleNavBar", 10);
	   CommonMethod.click("WellAtScaleNavBar");
	   CommonMethod.click("CreateAccountButton");
	   String AccountName = "Automation portfolio "+CommonMethod.randomNumber(8000000);
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
       Thread.sleep(5000);
	}
	
	public void SearchPortfolioByName (String SheetName,int rowNum) throws IOException, InterruptedException {
		
	   CommonMethod.click("ProjectNavBar");
	   CommonMethod.WaitUntilClickble("WellAtScaleNavBar", 10);
	   CommonMethod.click("WellAtScaleNavBar");	
	   CommonMethod.WaitUntilClickble("SearchPortfolioByName", 60);
	   CommonMethod.sendKeys("SearchPortfolioByName", data.getCellData(SheetName, "AccountName", rowNum));
	   CommonMethod.click("SearchPortfolioApplyFilter");
	   Thread.sleep(5000);
	   CommonMethod.WaitUntilClickble("ClickSearchResultPortfolio", 60);
	   CommonMethod.click("ClickSearchResultPortfolio");
	  
	   Thread.sleep(25000);
	}
	
	public void SignAndSubscribePortfolio (String SheetName,int rowNum) throws IOException, InterruptedException {
		
		
		  CommonMethod.WaitUntilClickble("ClickPortfolioSignNow", 60);
		  CommonMethod.Robustclick("ClickPortfolioSignNow");
		 
		   CommonMethod.WaitUntilClickble("SubscribeTab", 60);
		   CommonMethod.click("SubscribeTab");
		   CommonMethod.waitForPageLoaded();
		   CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		   String OwnerName = USfaker.address().firstName();
		   String OwnerEmail = USfaker.internet().emailAddress();
		   String OwnerPhone = USfaker.number().digits(10);
		   
		   CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		   CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		   CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		   
		   CommonMethod.click("PortfolioNoConsultantCheckbox");
		   
		   CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		   CommonMethod.click("PortfolioSubcribeContinueButton");
		   
		   CommonMethod.WaitUntilClickble("PortfolioQuestionRadio", 60);
		   CommonMethod.click("PortfolioQuestionRadio");
		   CommonMethod.WaitUntilVisibility("PortfolioLocationDescriptionTextbox", 20);
		   CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
		   CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		   CommonMethod.click("PortfolioSubcribeContinueButton2");
		   CommonMethod.click("PortfolioSubscribeDone");
		   CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		   CommonMethod.Robustclick("PortfolioGoToBilling");
		   Thread.sleep(5000);
			/*
			 * CommonMethod.WaitUntilClickble("PortfolioPayNowButton", 60);
			 * CommonMethod.click("PortfolioPayNowButton");
			 */
		}
	
	public void PortfolioCardPayment (String SheetName,int rowNum) throws IOException, InterruptedException {
		 if(!CommonMethod.isElementsExist("CardHolderName", 3)) {
			  Boolean B = CommonMethod.IsElementPresentTrue("PortfolioPayNowButton");
			  if(B.equals(true)) { CommonMethod.click("PortfolioPayNowButton"); }
		 }
		   CommonMethod.scrolldowntoElement("CardHolderName");
		   CommonMethod.WaitUntilClickble("CardHolderName", 60);
		   CommonMethod.sendKeys("CardHolderName", USfaker.address().firstName());
		   Thread.sleep(2000);
		   CommonMethod.switchToFrame("CardNumberIframe");
		   CommonMethod.WaitUntilClickble("CardHolderNumber", 60);
		   Thread.sleep(2000);
		   CommonMethod.sendKeys("CardHolderNumber", "4111111111111111");
		   CommonMethod.switchToParentFrame();
		   Thread.sleep(2000);
		   CommonMethod.switchToFrame("CardExpDateIframe");
		   CommonMethod.WaitUntilClickble("CardHolderExpDate", 60);
		   CommonMethod.sendKeys("CardHolderExpDate", "0925");
		   CommonMethod.switchToParentFrame();
		   Thread.sleep(2000);
		   CommonMethod.switchToFrame("CardCVVIframe");
		   CommonMethod.WaitUntilClickble("CardHolderCVC", 60);
		   CommonMethod.sendKeys("CardHolderCVC", "999");
		   CommonMethod.switchToParentFrame();
		   Thread.sleep(2000);
		   CommonMethod.WaitUntilClickble("PayNowButton", 10);
		   CommonMethod.click("PayNowButton");
		   Thread.sleep(2000);
	}
	
	public void PortfolioLocationImport (String SheetName,int rowNum) throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("LocationsTab", 300);
		CommonMethod.WaitUntilClickble("LocationsTab", 60);
		CommonMethod.click("LocationsTab");
		CommonMethod.WaitUntilClickble("PortfolioLocationsImportButton", 60);
		CommonMethod.click("PortfolioLocationsImportButton");
		CommonMethod.scrolldowntoElement("PortfolioUploadLocationButton");
		CommonMethod.uploadFile("PortfolioUploadLocationButton", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("PortfolioUploadFileNextButton", 60);
		CommonMethod.click("PortfolioUploadFileNextButton");
		if(CommonMethod.isElementsExist("PortfolioUnmatchFieldcbx", 3)) {
			CommonMethod.WaitUntilVisibility("PortfolioUnmatchFieldcbx", 100);
			CommonMethod.ClickCheckbox("PortfolioUnmatchFieldcbx");
		}
	
		CommonMethod.WaitUntilVisibility("PortfolioUploadFileNextButton", 300);
		CommonMethod.click("PortfolioUploadFileNextButton");
		CommonMethod.WaitUntilVisibility("PortfolioFinishImportButton", 300);
		CommonMethod.click("PortfolioFinishImportButton");
		CommonMethod.WaitUntilVisibility("PortfolioImportCloseButton", 300);
		CommonMethod.click("PortfolioImportCloseButton");
		
	}
	
	public void PortfolioBuildScorecard () throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilClickble("WellV2Tab", 60);
		CommonMethod.click("WellV2Tab");
		CommonMethod.WaitUntilClickble("WellV2ScorecardTab", 60);
		CommonMethod.click("WellV2ScorecardTab");
		CommonMethod.WaitUntilClickble("PortfolioScorecardBuildButton", 60);
		CommonMethod.click("PortfolioScorecardBuildButton");
		CommonMethod.WaitUntilClickble("PortfolioScorecardFinishedButton", 60);
		CommonMethod.click("PortfolioScorecardFinishedButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("PortfolioScorecardPopupButton", 60);
		CommonMethod.click("PortfolioScorecardPopupButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("PortfolioScorecardAnalyzeToggle", 60);
		CommonMethod.click("PortfolioScorecardAnalyzeToggle");
		
		Thread.sleep(20000);
		
	}
	public void clickScoreCard() throws IOException {
		CommonMethod.WaitUntilClickble("WellV2Tab", 60);
		CommonMethod.click("WellV2Tab");
		CommonMethod.WaitUntilClickble("WellV2ScorecardTab", 60);
		CommonMethod.click("WellV2ScorecardTab");
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", 300);
	}

	public void UploadFileinFeature() throws IOException, InterruptedException {

		CommonMethod.click("ScoreCardMeetOrgFeature");
			Thread.sleep(1000);
			CommonMethod.WaitUntilClickble("ScorecardFeatureVerificationTab", 60);
			CommonMethod.click("ScorecardFeatureVerificationTab");
			CommonMethod.click("ScoreCardAddOptionbutton");
			Thread.sleep(2000);
			CommonMethod.click("ScoreCardAddButton");
			Thread.sleep(2000);
			CommonMethod.click("ScoreCardAddButton");
			Thread.sleep(2000);
			CommonMethod.click("ScoreCardVerificationCloseicon");
			for(int i=1;i<=2;i++) {
				Thread.sleep(2000);
			CommonMethod.click("ScoreCardVerificationAssignbtn");
			CommonMethod.ClickCheckbox("ScoreCardVerificationAssignLocCbx");
			Thread.sleep(2000);
			CommonMethod.click("ScoreCardVerificationAssignLocSavebtn");
			}
			Thread.sleep(2000);
			CommonMethod.scrollDown();
			Thread.sleep(2000);
			for(int i=1;i<=1;i++) {
				CommonMethod.WaitUntilClickble("ScoreCardVerificationUploadbtn", 60);
			CommonMethod.click("ScoreCardVerificationUploadbtn");
			CommonMethod.uploadFile("ScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.sendKeys("ScoreCardVerificationAddNote", "Meet Thresholds for Organic Gases");
		Thread.sleep(2000);
		//CommonMethod.click("ScoreCardVerificationUploadDocbtn");
			Thread.sleep(20000);
			}
		}
		
	

	public void UploadFileinAudit() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilClickble("ScoreCardSupportOrgFeature", 60);
		CommonMethod.click("ScoreCardSupportOrgFeature");
		Thread.sleep(1000);
		CommonMethod.WaitUntilClickble("ScorecardFeatureVerificationTab", 60);
		CommonMethod.click("ScorecardFeatureVerificationTab");
		CommonMethod.click("ScoreCardAddOptionbutton");
		Thread.sleep(2000);
		CommonMethod.click("ScoreCardAddButton");
		Thread.sleep(3000);
		CommonMethod.click("ScoreCardVerificationCloseicon");
		Thread.sleep(2000);
		CommonMethod.click("ScoreCardVerificationAssignbtn");
		Thread.sleep(2000);
		CommonMethod.ClickCheckbox("ScoreCardVerificationAssignLocCbx");
		Thread.sleep(2000);
		CommonMethod.click("ScoreCardVerificationAssignLocSavebtn");
		Thread.sleep(2000);
		CommonMethod.scrollDown();
		Thread.sleep(2000);
		CommonMethod.assertEqualsmessage("ScoreCardVerificationTaskLoc","0/2 Locations","Verified locations count");
		CommonMethod.click("ScoreCardVerificationUploadbtn");
		Thread.sleep(2000);
		CommonMethod.scrollDown();
		Thread.sleep(2000);
		CommonMethod.uploadFile("ScoreCardVerificationUpload", PortfolioLocationImportfile);
		CommonMethod.sendKeys("ScoreCardVerificationAddNote", "Meet Thresholds for Organic Gases");
		Thread.sleep(2000);
	//	CommonMethod.click("ScoreCardVerificationUploadDocbtn");

	}
	public void clickDocument() throws IOException
{
		CommonMethod.WaitUntilClickble("DocumentTab", 60);
		
}

	public void ValidatingUploadFileCount() throws IOException, InterruptedException {
		
		CommonMethod.assertcontainsmessage("DocumentList", "10", "Verified Upload File Count");
	}

}

