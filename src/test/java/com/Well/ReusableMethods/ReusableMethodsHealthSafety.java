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
	   CommonMethod.RobustclickElementVisible("HsrEnrollnowbtn","HsrEnrollbtn");
	   CommonMethod.RobustclickElementVisible("HsrEnrollbtn","Hsrenrollcontinuebtn");
	   CommonMethod.WaitUntilClickble("HsrenrollName", 30);
	   String erollName = "Automation HSR Project "+CommonMethod.randomNumber(8000000);
	   CommonMethod.sendKeys("HsrenrollName", erollName);
	   data.setCellData(SheetName, "HsrName", rowNum, CommonMethod.getattributeValue("HsrenrollName"));
		testlog.info("HsrName: "+data.getCellData(SheetName, "HsrName", rowNum));
	   CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
	   rc.SelectOwnerOrg(SheetName, rowNum);
	   CommonMethod.selectdropdownrandom("OrgIndustry");
	   data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
	   CommonMethod.selectdropdownValue("Hsrenrollcountry",  "US");
	   data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("Hsrenrollcountry"));
	   CommonMethod.selectdropdownrandom("Hsrenrollstate");
	   data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("Hsrenrollstate"));
       String ProjectAddress = USfaker.address().streetAddress();
	   String ProjectCity = USfaker.address().cityName();
	   String PostalCode = USfaker.address().zipCode();
	   CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
	   data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("Hsrenrollstreet"));
		testlog.info("Hsrenrollstreet: "+data.getCellData(SheetName, "Street", rowNum));
       CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
       data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("Hsrenrollcity"));
		testlog.info("City: "+data.getCellData(SheetName, "City", rowNum));
       CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
       data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("Hsrenrollpostalcode"));
		testlog.info("PostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
       CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
       CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn","HsrRegcontinuebtn");
       CommonMethod.ClickCheckbox("Hsrregcheckbox");
       CommonMethod.selectdropdownVisibletext("HsrIwbimemberdropdown","No");
       CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn","HsrTypeoneEnrollbtn");
       CommonMethod.RobustclickElementVisible("HsrTypeoneEnrollbtn","HsrLocContinuebutton");
       CommonMethod.scrollUp();
       CommonMethod.sendKeys("Hsrlocations", "10");
       data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("Hsrlocations"));
		testlog.info("Hsrlocations: "+data.getCellData(SheetName, "Location", rowNum));
       CommonMethod.click("HsrWPRlocationsSpacetype");
       Thread.sleep(2000);
       CommonMethod.click("HsrWPRlocationsSpaceOption");
       String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
       CommonMethod.clearAndSendKey("Hsrlocationsize",Area);
       data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("Hsrlocationsize"));
       testlog.info("Hsrlocations: "+data.getCellData(SheetName, "Area", rowNum));
       CommonMethod.WaitUntilVisibility("HsrLocContinuebutton", 120);
	   CommonMethod.RobustclickElementVisible("HsrLocContinuebutton","HSRApplyButton");
       if(CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 20)) {
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 60);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
			}
       
       CommonMethod.RobustclickElementVisible("HsrLocContinuebutton","HsrReviewbtn");
		CommonMethod.WaitUntilClickble("HsrProgramFeePublicrbtn", 60);
		CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
	   CommonMethod.WaitUntilVisibility("HsrAcknowledecbx", 60);
	   CommonMethod.ClickCheckbox("HsrAcknowledecbx");
	   CommonMethod.RobustclickElementVisible("HsrReviewbtn","BillingLanding");
	   CommonMethod.WaitUntilVisibility("BillingLanding", 60);
	   testlog.pass("**Verifies the Registration successful**");
	}
	public void StoreIdHealthSafety(String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId =CommonMethod.getText("StoreId"); 
      String[] stringArray = getId.split(": ");
      String getHsrId = stringArray[1].trim();
      data.setCellData(SheetName, "ProjectID", rowNum, getHsrId);
      testlog.info("HealthSafety Id:" +getHsrId);
      testlog.pass("**Stored the Registered id  in excel successfully**");
	}
	
	public void SearchHealthSafetyByID (String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		 CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		   CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar","HsrIdSearch");
		   CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		   CommonMethod.click("HsrIdSearch");
		   testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		   CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		   CommonMethod.click("HsrapplySearch");
		  Thread.sleep(3000);
		  CommonMethod.assertcontainsmessage("HSRIdClick", data.getCellData(SheetName, "projectID", rowNum),
					"Project name doesn't matches in search");
		   CommonMethod.click("HSRIdClick");
		   CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		   testlog.pass("**Verifies the Search HealthSafety ByID successfully**");
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
			  CommonMethod.WaitUntilPresence("V2ProjectWPRPDocIcon", 60);
				CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon","HsrSelectTypeDoc");
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
				CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload);
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
		CommonMethod.WaitUntilVisibility("HsrSubmitDocReview", 60);
		CommonMethod.WaitUntilVisibility("HsrCommentReview", 60).sendKeys("Preliminary Health-Safety Review");
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
		CommonMethod.RobustclickElementVisible("AdminWELLHealthsafetyNavBar","HsrAdminIdSearch");
		CommonMethod.WaitUntilVisibility("HsrAdminIdSearch", 300);
		CommonMethod.click("HsrAdminIdSearch");
		CommonMethod.sendKeys("HsrAdminIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("HsrAdminApplybtn");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("HsrAdminIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.click("HsrAdminIdClick");
		Thread.sleep(3000);
		CommonMethod.WaitUntilVisibility("ReviewTab", 300);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.click("ReviewViewButton");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton","ReviewReturnSubmit");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");;
		CommonMethod.RobustclickElementVisible("DatePickerButton","DatePickerOkButton");
		CommonMethod.Robustclick("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.Robustclick("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Reviewed Preliminary Health-Safety Review successfully**");
}
	public void UploadDocumentHsr() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2ProjectDocumentTab", 300);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","V2ProjectDocUpload");
		CommonMethod.WaitUntilVisibility("HsrSelectTypeDoc", 60);
		CommonMethod.selectdropdownValue("HsrSelectTypeDoc", "general");
		CommonMethod.selectdropdownIndex("HsrType", 1);
		CommonMethod.uploadFile("V2ProjectDocUpload", GeneralfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.Robustclick("HsrDocumentUploadbtn");
		/* CommonMethod.click("V2ProjectGeneralDoc"); */
		//Add Doc count validation
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);
		testlog.pass("**Upload Document successfully**");
}
	public void registerFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 30);
		CommonMethod.RobustclickElementVisible("EditTab","HsrOrganizationInformation");
		CommonMethod.WaitUntilVisibility("HsrOrganizationInformation", 30);
		CommonMethod.RobustclickElementVisible("HsrOrganizationInformation","HsrEditProjectName");
		CommonMethod.WaitUntilVisibility("HsrEditProjectName", 30);
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditProjectName"),
				data.getCellData(SheetName, "HsrName", rowNum), "Verified Portfolio Project Name matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditArea"),
				data.getCellData(SheetName, "Area", rowNum), "Verified Hsr Area matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditLocation"),
				data.getCellData(SheetName, "Location", rowNum), "Verified Location matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "Verified Organization Name matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditOwnerName"),
				data.getCellData(SheetName, "AccountName", rowNum), "Verified OwnerName matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditOwnerEmailAddress"),
				data.getCellData(SheetName, "AccountName", rowNum), "Verified Owner EmailAddress matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditOwnerPhoneNumber"),
				data.getCellData(SheetName, "AccountName", rowNum), "Verified Owner PhoneNumber matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getSelectedDropdownValue("HsrEditOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Verified OrganizationIndustry matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditState"),
				data.getCellData(SheetName, "State", rowNum), "Verified State matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Verified StreetAddress matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrEditCity"),
				data.getCellData(SheetName, "City", rowNum), "Verified City matched with excel");
		CommonMethod.verifyTextPresentInElement(CommonMethod.getattributeValue("HsrPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Verified postal code matched with excel");
	}
}
