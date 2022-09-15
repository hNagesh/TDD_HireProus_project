package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodPerformance extends BaseClass {
	
	public void RegisterPerformance(String SheetName,int rowNum) throws IOException, InterruptedException {
	   CommonMethod.click("ProjectNavBar");
	   CommonMethod.click("WELLPerformanceRatingNavBar");
	   CommonMethod.click("WPRstartNewProject");
	   CommonMethod.click("WPREnrollOption");
	   CommonMethod.click("WPRenrollbtn");
	   String ProjectName = "Automation Project"+CommonMethod.randomNumber(8000000);
	   data.setCellData("Wpr", "projectName", 2, ProjectName);
	   CommonMethod.sendKeys("WPROrgName", ProjectName);
	   CommonMethod.ClickCheckbox("WPROwnerInfocbx");  
	   CommonMethod.click("OwnerOrgClick");
	   CommonMethod.sendKeys("OwnerOrg", "R");
	   CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
	   CommonMethod.click("SelectOwnerOrg");
	   CommonMethod.selectdropdownrandom("OrgIndustry");
	   CommonMethod.selectdropdown("WPROwnerCountry",  data.getCellData(SheetName, "country", rowNum));
	   CommonMethod.selectdropdown("WPROwnerState",  data.getCellData(SheetName, "state", rowNum));
	   String ProjectAddress = USfaker.address().streetAddress();
	   String ProjectCity = USfaker.address().cityName();
	   String PostalCode = USfaker.address().zipCode();
	   CommonMethod.sendKeys("WPROrgAddress", ProjectAddress);
       CommonMethod.sendKeys("WPROrgCity", ProjectCity);
       CommonMethod.sendKeys("WPROrgPostalcode", PostalCode);
       CommonMethod.ClickCheckbox("WPROwnercbx"); 
       CommonMethod.scrollDown();
       CommonMethod.click("WPROrgContinebtn");
       Thread.sleep(2000);
       CommonMethod.scrollUp();
       CommonMethod.ClickCheckbox("WPRBehalfCbx");
       CommonMethod.selectdropdown("WPRSelectMember",  "No");
       CommonMethod.click("WPROwnerRegContinuebtn");
       Thread.sleep(2000);
       CommonMethod.scrollUp();
       CommonMethod.sendKeys("WPRlocations", "10");
       CommonMethod.click("HsrlocationsSpacetype");
       CommonMethod.click("HsrlocationsSpaceOption");
       Thread.sleep(1000);
       CommonMethod.scrollDown();
       CommonMethod.clear("WPRlocationsize");
       CommonMethod.sendKeys("WPRlocationsize", "100");
       CommonMethod.WaitUntilClickble("WPROwnerRegContinuebtn", 60);
	   CommonMethod.click("WPROwnerRegContinuebtn");
	   CommonMethod.WaitUntilClickble("HsrYesMyOrganizationCbx", 30);
	   CommonMethod.ClickCheckbox("HsrYesMyOrganizationCbx");
	   CommonMethod.click("WPRReviewContinuebutton");
	   CommonMethod.WaitUntilClickble("WPRProgramFeePublicrbtn", 60);
	   CommonMethod.ClickCheckbox("WPRProgramFeePublicrbtn");
	   CommonMethod.scrollDown();
	   CommonMethod.WaitUntilClickble("WPRAcknowledecbx", 60);
	   CommonMethod.ClickCheckbox("WPRAcknowledecbx");
	   CommonMethod.click("WPRtermContinuebutton");
	}
	public void StoreIdPerformance(String SheetName,int rowNum) throws IOException, InterruptedException {
		  Thread.sleep(10000); 
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId =CommonMethod.getText("StoreId"); 
    String[] stringArray = getId.split(": ");
    String getWprId = stringArray[1].trim();
    data.setCellData("Wpr", "wprId", 2, getWprId);
	}
	
	public void SearchPerformanceByID(String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		 CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		   CommonMethod.click("WELLPerformanceRatingNavBar");
		   CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(data.getCellData(SheetName, "wprId", rowNum));
		   CommonMethod.click("WPRApplybtn");
		  Thread.sleep(3000);
		   CommonMethod.click("WPRIdClick");
		   CommonMethod.WaitUntilVisibility("WPRDashboard", 300);
	}
	
	public void ScorecardfillHSRWPR(int YesEnd,int NoStart, int NoEnd,int DifferencePlusOne, String purseYes, String purseNo) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		YesButton = CommonMethod.findElements(purseYes);
		  for (int i = 1; i<= YesEnd; i++) { 
			  int RemainingYes = YesButton.size(); 
			  do {
		  CommonMethod.click(purseYes); 
		  CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 30);
		  YesButton = CommonMethod.findElements(purseYes);
		  }while(YesButton.size()==RemainingYes); RemainingYes--; }
		  
			
			NoButton = CommonMethod.findElements(purseNo);
			int j=DifferencePlusOne;
			for (int i = NoStart; i <= NoEnd; i++) {
				int RemainingNo = NoButton.size();
				do {
				CommonMethod.click(NoButton.get(RemainingNo-j));
				 CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 30);
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements(purseNo);
				}while(NoButton.size()==RemainingNo);
				RemainingNo--;
				j--;
			}	
	}
	
	public void CompleteScorecardWprById(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(3000);
		CommonMethod.WaitUntilVisibility("WellV2ScorecardTab", 60);
		CommonMethod.click("WellV2ScorecardTab");
		CommonMethod.WaitUntilVisibility("WPRScorecardLanding", 300);
		ScorecardfillHSRWPR(21,21,36,16,"WPRPurseYes","WPRPurseNo"); 

	}
	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature"); 
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("WPRScorecardLanding");
		  for (WebElement f:Feature) {
			  CommonMethod.click(f);
			  CommonMethod.WaitUntilVisibility("WPRVerficationTab", 60);
				CommonMethod.click("WPRVerficationTab");
				CommonMethod.WaitUntilVisibility("WPRAddOption", 60);
				CommonMethod.click("WPRAddOption");
				CommonMethod.WaitUntilVisibility("WPRAddOptionbtn", 60);
				CommonMethod.click("WPRAddOptionbtn");
				CommonMethod.WaitUntilVisibility("WPRAddOptionCloseIcon", 60);
				CommonMethod.Robustclick("WPRAddOptionCloseIcon");
				CommonMethod.WaitUntilVisibility("WPRAssignLocbtn", 30);
				Thread.sleep(2000);
				CommonMethod.click("WPRAssignLocbtn");
				Thread.sleep(2000);
				CommonMethod.ClickCheckbox("WPRAssignLocCbx");
				Thread.sleep(2000);
				CommonMethod.WaitUntilVisibility("WPRAssignSavebtn", 30);
				CommonMethod.click("WPRAssignSavebtn");
				CommonMethod.WaitUntilVisibility("WPRUploadDocTaskbtn", 60);
				CommonMethod.click("WPRUploadDocTaskbtn");
				CommonMethod.scrolldowntoLast();
				CommonMethod.uploadFile("WPRDocUpload", PortfolioLocationImportfile);
				Thread.sleep(2000);
				CommonMethod.Robustclick("WPRUploadDocTaskSavebtn");
				CommonMethod.scrolldowntoElement("WPRScorecardLanding");
                CommonMethod.click(f);
		  }
	}
	public void UploadWPRDocForFeature() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRScorecardLanding", 300);
		uploadDocumentInFeature(21);	
}
	
	public void WPRReview(String SheetName, int rowNum) throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilClickble("ReviwTab", 60);
		Thread.sleep(3000);
		CommonMethod.click("ReviwTab");
		CommonMethod.click("WPRReviewSubmitbtn");
		CommonMethod.selectdropdown("WPRReviewProjectPhase", "Preliminary Performance Rating Review");	
		CommonMethod.WaitUntilClickble("WPRReviewComment", 60).sendKeys("Preliminary Performance Rating Review");
		CommonMethod.click("WPRReviewSubmitDocbtn");
		Thread.sleep(2000);
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
		CommonMethod.click("ReviwTab");
		CommonMethod.WaitUntilVisibility("HsrReviewViewbtn", 60);
		CommonMethod.click("HsrReviewViewbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectReturnReviewbtn", 60);
		CommonMethod.click("V2ProjectReturnReviewbtn");
		CommonMethod.WaitUntilClickble("HsrReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectdocsubUpdatebtn");
		CommonMethod.click("V2ProjectdocsubOkbtn");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("V2ProjectPaymentstatus");
		CommonMethod.click("V2ProjectReturnReviewSubmit");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectReviwedStatus", "REVIEWED", "Verified Review status");
}
	
	
	public void UploadWPRDocument() throws IOException, InterruptedException {
			Thread.sleep(2000);
			CommonMethod.WaitUntilVisibility("WellV2DocLibraryTab", 300);
			CommonMethod.click("WellV2DocLibraryTab");
			CommonMethod.WaitUntilVisibility("WPRUploadDocLib", 60);
			CommonMethod.click("WPRUploadDocLib");
			CommonMethod.WaitUntilVisibility("WPRSelectDocType", 60);
			CommonMethod.selectdropdownIndex("WPRSelectDocType", 1);
			CommonMethod.selectdropdownIndex("WPRSelectType", 1);
			CommonMethod.uploadFile("WPRDocUpload", PortfolioLocationImportfile);
			Thread.sleep(2000);
			CommonMethod.sendKeys("WPRAddNote", "Submitting Document");
			CommonMethod.Robustclick("WPRSumbitUploadDocLib");
			
	}
}
	

