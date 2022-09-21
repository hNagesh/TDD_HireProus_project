package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;


public class ReusableMethodsHealthSafety extends BaseClass {
	
	public void RegisterHealthSafety(String SheetName,int rowNum) throws IOException, InterruptedException {
	   CommonMethod.click("ProjectNavBar");
	   CommonMethod.click("WELLHealthSafetyNavBar");
	   CommonMethod.click("HsrWellhealthstartprojectbtn");
	   CommonMethod.click("HsrEnrollnowbtn");
	   CommonMethod.click("HsrEnrollbtn");
	   CommonMethod.WaitUntilClickble("HsrenrollName", 30);
	   String erollName = "Automation HSR Project "+CommonMethod.randomNumber(8000000);
	   CommonMethod.sendKeys("HsrenrollName", erollName);
	   CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
	   CommonMethod.click("OwnerOrgClick");
	   CommonMethod.sendKeys("OwnerOrg", "R");
	   CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
	   CommonMethod.click("SelectOwnerOrg");
	   CommonMethod.selectdropdownrandom("HsrorgIndustry");
	   data.setCellData("Hsr", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("HsrorgIndustry"));
	   CommonMethod.selectdropdown("Hsrenrollcountry",  data.getCellData(SheetName, "country", rowNum));
	   CommonMethod.selectdropdown("Hsrenrollstate", data.getCellData(SheetName, "state", rowNum));
       String ProjectAddress = USfaker.address().streetAddress();
	   String ProjectCity = USfaker.address().cityName();
	   String PostalCode = USfaker.address().zipCode();
	   CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
       CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
       CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
       CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
       CommonMethod.click("Hsrenrollcontinuebtn");
       CommonMethod.ClickCheckbox("Hsrregcheckbox");
       CommonMethod.selectdropdown("HsrIwbimemberdropdown","No");
       CommonMethod.click("HsrRegcontinuebtn");
       CommonMethod.click("HsrTypeoneEnrollbtn");
       CommonMethod.scrollUp();
       CommonMethod.sendKeys("Hsrlocations", "10");
       CommonMethod.click("HsrlocationsSpacetype");
       Thread.sleep(2000);
       CommonMethod.click("HsrlocationsSpaceOption");
       CommonMethod.clear("Hsrlocationsize");
       CommonMethod.sendKeys("Hsrlocationsize", "10");
	   CommonMethod.click("HsrLocContinuebutton");
	   CommonMethod.WaitUntilClickble("HsrYesMyOrganizationCbx", 30);
	   CommonMethod.ClickCheckbox("HsrYesMyOrganizationCbx");
	   CommonMethod.click("HsrLocContinuebutton");
	   CommonMethod.WaitUntilClickble("HsrProgramFeePublicrbtn", 60);
	   CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
	   CommonMethod.ClickCheckbox("HsrAcknowledecbx");
	   CommonMethod.click("HsrReviewbtn");
	   CommonMethod.WaitUntilVisibility("BillingLanding", 60);
	  
	}
	public void StoreIdHealthSafety(String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRDashboard", 60);
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId =CommonMethod.getText("StoreId"); 
      String[] stringArray = getId.split(": ");
      String getHsrId = stringArray[1].trim();
      data.setCellData("Hsr", "hsrId", 2, getHsrId);
      
	}
	
	public void SearchHealthSafetyByID (String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		 CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		   CommonMethod.click("WELLHealthSafetyNavBar");
		   CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		   CommonMethod.click("HsrIdSearch");
		   CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "hsrId", rowNum));
		   CommonMethod.click("HsrapplySearch");
		  Thread.sleep(3000);
		   CommonMethod.click("Hsrprojectidcompare");
		   CommonMethod.WaitUntilVisibility("WPRDashboard", 60);
	}
	public void ScorecardfillHSRWPR(int YesEnd,int NoStart, int NoEnd,int DifferencePlusOne) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		int j=DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.click(NoButton.get(RemainingNo-j));
			Thread.sleep(1000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
			j--;
		}
		CommonMethod.scrolldowntoElement("HsrScorecard");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		  for (int i = 1; i<= YesEnd; i++) { 
			  int RemainingYes = YesButton.size(); 
			  do {
		  CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
		  CommonMethod.click("V2ProjectPurseYes"); 
		  Thread.sleep(1000); 
		  YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		  }while(YesButton.size()==RemainingYes); RemainingYes--; }
		 
		
	}
	
	public void CompleteScorecardHsrById(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(3000);
		CommonMethod.WaitUntilVisibility("WellV2ScorecardTab", 300);
		CommonMethod.click("WellV2ScorecardTab");
		CommonMethod.WaitUntilVisibility("HsrScorecard", 300);
		ScorecardfillHSRWPR(15,1,27,27); 
		
	}
	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature"); 
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("HsrScorecard");
		  for (WebElement f:Feature) {
			  CommonMethod.WaitUntilClickble(f, 30).click();
			  CommonMethod.WaitUntilVisibility("V2ProjectWPRPDocIcon", 60);
				CommonMethod.click("V2ProjectWPRPDocIcon");
				CommonMethod.WaitUntilVisibility("HsrSelectTypeDoc", 60);
				CommonMethod.selectdropdownIndex("HsrSelectTypeDoc", 1);
				if(CommonMethod.isElementsExist("HsrLocationrtn",3)) {
					CommonMethod.WaitUntilClickble("HsrLocationrtn", 10);
					CommonMethod.ClickCheckbox("HsrLocationrtn");
				}
				CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 60);
				CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
				CommonMethod.scrolldowntoElement("V2ProjectWPRVerificationMethod");
				if(CommonMethod.isElementsExist("HsrSelectLoc",3)) {
					CommonMethod.WaitUntilClickble("HsrSelectLoc", 10);
					CommonMethod.selectdropdownIndex("HsrSelectLoc", 1);
				}
				CommonMethod.uploadFile("V2ProjectDocUpload", PortfolioLocationImportfile);
				Thread.sleep(2000);
				CommonMethod.Robustclick("HsrUploadDocFeature");
				CommonMethod.scrolldowntoElement("HsrScorecard");
                CommonMethod.click(f);
		  }
	}
	public void UploadHsrDocForFeature() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HsrScorecard", 300);
		uploadDocumentInFeature(15);	
}
	public void ReviewHsr(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviwTab", 60);
		CommonMethod.click("ReviwTab");
		CommonMethod.WaitUntilVisibility("PortfolioReviewlanding", 20);
		CommonMethod.WaitUntilVisibility("HsrSubmitReview", 60);
		CommonMethod.click("HsrSubmitReview");
		CommonMethod.WaitUntilPresence("HsrCommentReview", 60).sendKeys("Preliminary Health-Safety Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdown("HsrSelectedProjectPhaseReview", "Preliminary Health-Safety Review");
		CommonMethod.WaitUntilClickble("HsrSubmitDocReview", 60);
		CommonMethod.click("HsrSubmitDocReview");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("PortfolioReviewlanding", 60);
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLHealthsafetyNavBar", 60);
		CommonMethod.click("AdminWELLHealthsafetyNavBar");
		CommonMethod.WaitUntilVisibility("HsrAdminIdSearch", 300);
		CommonMethod.click("HsrAdminIdSearch");
		CommonMethod.sendKeys("HsrAdminIdSearch", data.getCellData(SheetName, "hsrId", rowNum));
		CommonMethod.click("HsrAdminApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("HsrAdminIdClick");
		Thread.sleep(3000);
		CommonMethod.WaitUntilVisibility("ReviwTab", 300);
		CommonMethod.click("ReviwTab");
		CommonMethod.WaitUntilVisibility("HsrReviewViewbtn", 60);
		CommonMethod.click("HsrReviewViewbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectReturnReviewbtn", 60);
		CommonMethod.click("V2ProjectReturnReviewbtn");
		CommonMethod.WaitUntilClickble("HsrReturnComment", 60).sendKeys("Preliminary Precertification Review");;
		CommonMethod.WaitUntilClickble("V2ProjectdocsubUpdatebtn", 60);
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectdocsubUpdatebtn");
		CommonMethod.WaitUntilClickble("V2ProjectdocsubOkbtn", 60);
		CommonMethod.click("V2ProjectdocsubOkbtn");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.WaitUntilClickble("V2ProjectPaymentstatus", 60);
		CommonMethod.ClickCheckbox("V2ProjectPaymentstatus");
		CommonMethod.WaitUntilClickble("V2ProjectReturnReviewSubmit", 60);
		CommonMethod.click("V2ProjectReturnReviewSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("V2ProjectReviwedStatus", 60);
		CommonMethod.assertcontainsmessage("V2ProjectReviwedStatus", "REVIEWED", "Verified Review status");
}
	public void UploadDocumentHsr() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2ProjectDocumentTab", 300);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);
		CommonMethod.click("HsrAddDoc");
		CommonMethod.WaitUntilVisibility("HsrSelectTypeDoc", 60);
		CommonMethod.selectdropdownIndex("HsrSelectTypeDoc", 1);
		CommonMethod.selectdropdownIndex("HsrType", 1);
		CommonMethod.uploadFile("V2ProjectDocUpload", PortfolioLocationImportfile);
		Thread.sleep(2000);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.Robustclick("HsrDocumentUploadbtn");
		CommonMethod.click("V2ProjectGeneralDoc");
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);	
}
}
