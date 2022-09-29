package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;


public class ReusableMethodsHealthSafety extends BaseClass {
	
	public void RegisterHealthSafety(String SheetName,int rowNum) throws IOException, InterruptedException {
	   CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
	   CommonMethod.click("ProjectNavBar");
	   CommonMethod.click("WELLHealthSafetyNavBar");
	   CommonMethod.click("HsrWellhealthstartprojectbtn");
	   CommonMethod.click("HsrEnrollnowbtn");
	   CommonMethod.click("HsrEnrollbtn");
	   CommonMethod.WaitUntilClickble("HsrenrollName", 30);
	   String erollName = "Automation HSR Project "+CommonMethod.randomNumber(8000000);
	   CommonMethod.sendKeys("HsrenrollName", erollName);
	   data.setCellData("Hsr", "HsrName", 2, CommonMethod.getattributeValue("HsrenrollName"));
		testlog.info("HsrName: "+data.getCellData(SheetName, "HsrName", rowNum));
	   CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
	   CommonMethod.click("OwnerOrgClick");
	   CommonMethod.sendKeys("OwnerOrg", "R");
	   CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 6).click();
		data.setCellData("Hsr", "Org", 2, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " +data.getCellData(SheetName, "Org", rowNum));
	   CommonMethod.selectdropdownrandom("OrgIndustry");
	   data.setCellData("Hsr", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
	   CommonMethod.selectdropdownVisibletext("Hsrenrollcountry",  "United States");
	   data.setCellData("Hsr", "Country", 2, CommonMethod.getSelectedDropdownValue("Hsrenrollcountry"));
	   CommonMethod.selectdropdownrandom("Hsrenrollstate");
	   data.setCellData("Hsr", "State", 2, CommonMethod.getSelectedDropdownValue("Hsrenrollstate"));
       String ProjectAddress = USfaker.address().streetAddress();
	   String ProjectCity = USfaker.address().cityName();
	   String PostalCode = USfaker.address().zipCode();
	   CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
	   data.setCellData("Hsr", "Street", 2, CommonMethod.getattributeValue("Hsrenrollstreet"));
		testlog.info("Hsrenrollstreet: "+data.getCellData(SheetName, "Street", rowNum));
       CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
       data.setCellData("Hsr", "City", 2, CommonMethod.getattributeValue("Hsrenrollcity"));
		testlog.info("City: "+data.getCellData(SheetName, "City", rowNum));
       CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
       data.setCellData("Hsr", "PostalCode", 2, CommonMethod.getattributeValue("Hsrenrollpostalcode"));
		testlog.info("PostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
       CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
       CommonMethod.click("Hsrenrollcontinuebtn");
       CommonMethod.ClickCheckbox("Hsrregcheckbox");
       CommonMethod.selectdropdownVisibletext("HsrIwbimemberdropdown","No");
       CommonMethod.click("HsrRegcontinuebtn");
       CommonMethod.click("HsrTypeoneEnrollbtn");
       CommonMethod.scrollUp();
       CommonMethod.sendKeys("Hsrlocations", "10");
       data.setCellData("Hsr", "Location", 2, CommonMethod.getattributeValue("Hsrlocations"));
		testlog.info("Hsrlocations: "+data.getCellData(SheetName, "Location", rowNum));
       CommonMethod.click("HsrWPRlocationsSpacetype");
       Thread.sleep(2000);
       CommonMethod.click("HsrWPRlocationsSpaceOption");
       CommonMethod.clear("Hsrlocationsize");
       String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
       CommonMethod.sendKeys("Hsrlocationsize", Area);
       data.setCellData("Hsr", "Area", 2, CommonMethod.getattributeValue("Hsrlocationsize"));
       testlog.info("Hsrlocations: "+data.getCellData(SheetName, "Area", rowNum));
       if(CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 20)) {
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 60);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
			}
       CommonMethod.WaitUntilVisibility("HsrLocContinuebutton", 120);
	   CommonMethod.Robustclick("HsrLocContinuebutton");
		CommonMethod.WaitUntilClickble("HsrProgramFeePublicrbtn", 60);
		CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
	   CommonMethod.WaitUntilVisibility("HsrAcknowledecbx", 60);
	   CommonMethod.ClickCheckbox("HsrAcknowledecbx");
	   CommonMethod.click("HsrReviewbtn");
	   CommonMethod.WaitUntilVisibility("BillingLanding", 60);
	   testlog.pass("**Verifies the Registration successful**");
	}
	public void StoreIdHealthSafety(String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId =CommonMethod.getText("StoreId"); 
      String[] stringArray = getId.split(": ");
      String getHsrId = stringArray[1].trim();
      data.setCellData("Hsr", "hsrId", 2, getHsrId);
      testlog.info("HealthSafety Id:" +getHsrId);
      testlog.pass("**Stored the Registered id  in excel successfully**");
	}
	
	public void SearchHealthSafetyByID (String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		 CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		   CommonMethod.click("WELLHealthSafetyNavBar");
		   CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		   CommonMethod.click("HsrIdSearch");
		   testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "hsrId", rowNum));
		   CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "hsrId", rowNum));
		   CommonMethod.click("HsrapplySearch");
		  Thread.sleep(3000);
		   CommonMethod.click("Hsrprojectidcompare");
		   CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		   testlog.pass("**Verifies the Search HealthSafety ByID successfully**");
	}
	public void HSRBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		rc.Billing(SheetName, rowNum);
		testlog.pass("**Completed Card Payment Billing successfully**");
	}
	public void HSRLocation(String SheetName, int rowNum) throws IOException, InterruptedException {
	portfolio.PortfolioLocationImport(SheetName, rowNum);
	}
	public void ScorecardfillHSRWPR(int YesEnd,int NoStart, int NoEnd,int DifferencePlusOne) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
		int j=DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.click(NoButton.get(RemainingNo-j));
			Thread.sleep(1000);
			NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
			j--;
		}
		CommonMethod.scrolldowntoElement("HsrScorecard");
		YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		  for (int i = 1; i<= YesEnd; i++) { 
			  int RemainingYes = YesButton.size(); 
			  do {
		  CommonMethod.WaitUntilClickble("V2ProjectHsrPurseYes", 60);
		  CommonMethod.click("V2ProjectHsrPurseYes"); 
		  Thread.sleep(1000); 
		  YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		  }while(YesButton.size()==RemainingYes); RemainingYes--; }
		 
		
	}
	
	public void CompleteScorecardHsrById(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(3000);
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.click("ScorecardTab");
		CommonMethod.WaitUntilVisibility("HsrScorecard", 300);
		ScorecardfillHSRWPR(15,1,27,27); 
		testlog.pass("**Verifies the 15 Purse Yes Scorecard HealthSafety in V2Project successfully**");
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
		testlog.pass("**Upload 15 Scorecard Documents successfully**");
}
	public void ReviewHsr(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 20);
		CommonMethod.WaitUntilVisibility("HsrSubmitReview", 60);
		CommonMethod.click("HsrSubmitReview");
		CommonMethod.WaitUntilPresence("HsrCommentReview", 60).sendKeys("Preliminary Health-Safety Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdownVisibletext("HsrSelectedProjectPhaseReview", "Preliminary Health-Safety Review");
		CommonMethod.WaitUntilClickble("HsrSubmitDocReview", 60);
		CommonMethod.click("HsrSubmitDocReview");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		testlog.pass("**Submitted Preliminary Health-Safety Review successfully**");
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
		CommonMethod.WaitUntilVisibility("ReviewTab", 300);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.click("ReviewViewButton");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 60);
		CommonMethod.click("ReviewReturnButton");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");;
		CommonMethod.click("DatePickerButton");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.click("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Reviewed Preliminary Health-Safety Review successfully**");
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
		testlog.pass("**Upload Document successfully**");
}
}
