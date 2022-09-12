package com.Well.ReusableMethods;

import java.io.IOException;


import org.openqa.selenium.By;

import java.util.List;


import org.openqa.selenium.WebElement;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsV2Project extends BaseClass {

	public void RegisterV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {

		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WELLCertificationNavBar");
		CommonMethod.click("V2Projectstartav2projectbtn");
		CommonMethod.click("V2ProjectstartProjectcontinuebtn");
		String ProjectName = "Automation Project" + CommonMethod.randomNumber(8000000);
		data.setCellData("V2Project", "projectName", 2, ProjectName);
		CommonMethod.sendKeys("V2Projectprojectnickname", ProjectName);
		CommonMethod.click("V2ProjectnicknameContinuebtn");
		CommonMethod.selectdropdown("V2ProjectlocationCountry", data.getCellData(SheetName, "country", rowNum));
		CommonMethod.selectdropdown("V2ProjectlocationState", data.getCellData(SheetName, "state", rowNum));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("V2ProjectlocationStreet", ProjectAddress);
		CommonMethod.sendKeys("V2ProjectlocationCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectlocationPostalcode", PostalCode);
		CommonMethod.click("V2ProjectlocationContinuebtn");
		CommonMethod.sendKeys("V2ProjectareaSize", data.getCellData(SheetName, "area", rowNum));
		CommonMethod.click("V2ProjectareaContinuebtn");
		CommonMethod.ClickCheckbox("V2ProjectspaceType");
		CommonMethod.click("V2ProjectspacetypeContinuebtn");
		CommonMethod.click("V2Projectwellcorecertification");
		CommonMethod.WaitUntilClickble("V2ProjectdocsubUpdatebtn", 60);
		Thread.sleep(10000);
		CommonMethod.click("V2ProjectdocsubUpdatebtn");
		CommonMethod.click("V2ProjectdocsubOkbtn");
		CommonMethod.WaitUntilClickble("V2ProjectdocsubConfirmbtn", 60);
		CommonMethod.click("V2ProjectdocsubConfirmbtn");
		CommonMethod.click("V2Projectcontinuethejourneybtn");
		CommonMethod.WaitUntilClickble("StoreId", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData("V2Project", "projectId", 2, getProjectId);

	}

	public void SearchV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WELLCertificationNavBar");
		CommonMethod.sendKeys("V2ProjectId", data.getCellData(SheetName, "projectId", rowNum));
		CommonMethod.click("V2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectIdCompare");
	}

	public void EnrollV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.click("EnrollTab");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		String Ownername = USfaker.address().cityName();
		CommonMethod.sendKeys("V2ProjectownerName", Ownername);
		CommonMethod.sendKeys("V2ProjectownerEmail", "www.auto@gmail.com");
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("V2Projectownerphone", PostalCode);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		CommonMethod.sendKeys("V2Projectorganizationwebsite", Ownername);
		CommonMethod.sendKeys("V2ProjectorganizationOverview", Ownername);
		CommonMethod.ClickCheckbox("V2ProjectconstructionOrrenovation");
		CommonMethod.click("V2ProjectdocsubEstidate");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		CommonMethod.click("V2ProjectdocsubAnticdate");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		CommonMethod.click("V2ProjectprojectOwnerContinuebtn");
		CommonMethod.selectdropdown("V2ProjectprojectaddressCountry", "United States");
		CommonMethod.WaitUntilVisibility("V2ProjectprojectState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectprojectState");
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		CommonMethod.sendKeys("V2ProjectprojectaddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectprojectaddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectprojectaddressPostalcode", PostalCode);
		CommonMethod.selectdropdown("V2ProjectowneraddressCountry", "United States");
		CommonMethod.WaitUntilVisibility("V2ProjectowneraddressState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectowneraddressState");
		CommonMethod.sendKeys("V2ProjectowneraddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectowneraddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectowneraddressPostalcode", PostalCode);
		CommonMethod.ClickCheckbox("V2Projectisthisapublicproject");
		CommonMethod.click("V2ProjectprojectaddressContinuebtn");
		Thread.sleep(4000);
	}

	public void BillingV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.click("BiilingTab");
		CommonMethod.click("PortfolioPayNowButton");
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

	public void AgreementV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WellV2DashboardTab");
		CommonMethod.WaitUntilClickble("V2ProjectSignNow", 60);
		CommonMethod.Robustclick("V2ProjectSignNow");
	}

	public void BuildScorecardV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectStartBuilding", 60);
		CommonMethod.click("V2ProjectStartBuilding");
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", 300);
	}

	public void RefreshScorecard() throws IOException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", 300);
	}
	
	public void Scorecardfill(int YesEnd,int NoStart, int NoEnd,int DifferencePlusOne) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		YesButton = CommonMethod.findElements("V2ProjectPurseYes"); 
		  for (int i = 1; i<= YesEnd; i++) { 
			  int RemainingYes = YesButton.size(); 
			  do {
		  CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
		  CommonMethod.click("V2ProjectPurseYes"); 
		  Thread.sleep(1000); 
		  YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		  }while(YesButton.size()==RemainingYes); RemainingYes--; }
		 
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		int j=DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			System.out.println("A"+RemainingNo);
			do {
			CommonMethod.click(NoButton.get(RemainingNo-j));
			Thread.sleep(1000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
			j--;
		}
		RefreshScorecard();
	}

	public void CompleteScorecardV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilClickble("V2ProjectAirconcept", 60);
		CommonMethod.click("V2ProjectAirconcept");
		Scorecardfill(15,16,25,10);  
		/*
		 * Water concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectWaterconcept", 60);
		CommonMethod.click("V2ProjectWaterconcept");
		Scorecardfill(13,14,17,4);
		/*
		 * Nourisement concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectNourisementconcept", 60);
		CommonMethod.click("V2ProjectNourisementconcept");
		Scorecardfill(13,14,15,2);
		/*
		 * Light concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectLightconcept", 60);
		CommonMethod.click("V2ProjectLightconcept");
		Scorecardfill(6,7,12,6);
		/*
		 * Movement concept
		 */
		CommonMethod.WaitUntilClickble("V2Projectmovementconcept", 60);
		CommonMethod.click("V2Projectmovementconcept");
		Scorecardfill(11,12,22,11);
		/*
		 * Thermal concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectThermalconcept", 60);
		CommonMethod.click("V2ProjectThermalconcept");
		Scorecardfill(10,11,15,5);
		/*
		 * Sound concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectSoundconcept", 60);
		CommonMethod.click("V2ProjectSoundconcept");
		Scorecardfill(9,10,14,5);
		/*
		 * Material concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMaterialconcept", 60);
		CommonMethod.click("V2ProjectMaterialconcept");
		Scorecardfill(17,18,24,7);
		/*
		 * Mind concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMindconcept", 60);
		CommonMethod.click("V2ProjectMindconcept");
		Scorecardfill(8,9,19,11);
		/*
		 * Community concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectCommunityconcept", 60);
		CommonMethod.click("V2ProjectCommunityconcept");
		Scorecardfill(17,18,35,18);
		/*
		 * Innovation concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectInnovationconcept", 60);
		CommonMethod.click("V2ProjectInnovationconcept");

		Scorecardfill(10,11,18,8);
//		Thread.sleep(4000);
//		CommonMethod.Isdisplayed("V2ProjectScorecardYesCount", 60);
//		int YesFeatureCount = CommonMethod.ElementSize("V2ProjectScorecardYesCount");
//		String yesFeatureCount = Integer.toString(YesFeatureCount);
//		CommonMethod.assertActualContainsExpected(yesFeatureCount, "130", "Verified Scorecard part Yes Count");
//		int NoFeatureCount = CommonMethod.ElementSize("V2ProjectScorecardNoCount");
//		String noFeatureCount = Integer.toString(NoFeatureCount);
//		CommonMethod.assertActualContainsExpected(noFeatureCount, "86", "Verified Scorecard part No Count");

		

	}

	public void UploadFeatureDocV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardFeature", 60);
		CommonMethod.Robustclick("V2ProjectScorecardFeature");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2ProjectscorecardDocbtn");
		CommonMethod.selectdropdown("V2Projectscorecardverificationdropdown", "Performance Test OR Sensor Data");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2Projectscorecarddocuploadsubmit");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		CommonMethod.refreshBrowser();

	}

	public void UploadAuditDocV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardAuditFeature", 60);
		CommonMethod.Robustclick("V2ProjectScorecardAuditFeature");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2ProjectscorecardDocbtn");
		CommonMethod.selectdropdown("V2Projectscorecardverificationdropdown", "Technical Document (Audited)");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2Projectscorecarddocuploadsubmit");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();

	}

	public void UploadGeneralDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.Robustclick("WellV2ProjectDocumentTab");
		CommonMethod.click("V2ProjectDocUploadbtn");
		CommonMethod.selectdropdown("V2ProjectDocType", "General");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.click("V2ProjectDocSubmit");
		Thread.sleep(2000);
	}

	public void UploadLegalDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.Robustclick("WellV2ProjectDocumentTab");
		CommonMethod.click("V2ProjectDocUploadbtn");
		CommonMethod.selectdropdown("V2ProjectDocType", "Legal");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.click("V2ProjectDocSubmit");
		Thread.sleep(2000);
	}

	public void UploadOngoingDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.click("V2ProjectDocUploadbtn");
		CommonMethod.selectdropdown("V2ProjectDocType", "Ongoing data reports");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectResetbtn");
		Thread.sleep(1000);
		CommonMethod.selectdropdown("V2ProjectDocType", "Legal");
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectResetbtn");
		Thread.sleep(2000);
		CommonMethod.selectdropdown("V2ProjectDocType", "Ongoing data reports");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.selectdropdown("V2ProjectDocPeriod", "Year 1 reporting");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.click("V2ProjectDocSubmit");
		Thread.sleep(4000);
		CommonMethod.refreshBrowser();
	}

	public void UploadFeatureDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.click("V2ProjectDocUploadbtn");
		Thread.sleep(2000);
		CommonMethod.selectdropdown("V2ProjectDocType", "Feature");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectPart");
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectSelectPartDoc");
		Thread.sleep(1000);
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.click("V2ProjectDocSubmit");
		Thread.sleep(2000);
	}

	public void UploadDocumentCountInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.click("V2ProjectGeneralDoc");
		int V2ProjectDocCount = CommonMethod.ElementSize("V2ProjectGeneralDocCount");
		String V2ProjectDocuCounts = Integer.toString(V2ProjectDocCount);
		CommonMethod.assertActualContainsExpected(V2ProjectDocuCounts, "2");
		CommonMethod.click("V2ProjectScorecardDoc");
		int V2ProjectScoreDocCount = CommonMethod.ElementSize("V2ProjectScorecardDocCount");
		String V2ProjectDocCounts = Integer.toString(V2ProjectScoreDocCount);
		CommonMethod.assertActualContainsExpected(V2ProjectDocCounts, "4");

	}
	
	public void ReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("ReviwTab", 60);
		CommonMethod.click("ReviwTab");
		CommonMethod.WaitUntilClickble("V2ProjectsubmitReview", 60);
		CommonMethod.click("V2ProjectsubmitReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60);
		CommonMethod.sendKeys("V2ProjectcommentReview", "Preliminary Precertification Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdown("V2ProjectSelectPhase", "Preliminary Precertification Review");	
		CommonMethod.WaitUntilClickble("V2ProjectSubmitPhaseReview", 60);
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilClickble("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60);
		CommonMethod.sendKeys("AdminV2ProjectId", data.getCellData(SheetName, "projectId", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.click("ReviwTab");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectReviewViewbtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectReturnReviewbtn");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60);
		CommonMethod.sendKeys("V2ProjectReviewCommentNarrative", "Preliminary Precertification Review");
		CommonMethod.sendKeys("V2ProjectGeneralCommentNarrative", "Preliminary Precertification Review");
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
	public void HealthSafetyV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HealthSafetyTab", 300);
		CommonMethod.click("HealthSafetyTab");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrContinuebtn", 300);
		CommonMethod.click("V2ProjectHsrContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 300);
		CommonMethod.click("V2ProjectHsrTermscbx");
		CommonMethod.click("V2ProjectHsrTermsbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 300);
		CommonMethod.click("V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrProceedbtn", 300);
		CommonMethod.click("V2ProjectHsrProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrAccountbtn", 300);
		CommonMethod.click("V2ProjectHsrAccountbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrScorecard", 300);
		for(int i=1;i<=27;i++) {
			CommonMethod.click("V2ProjectHsrPursuingNo");
			Thread.sleep(3000);
		}
		Thread.sleep(2000);
		CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrPursuingYes", 300);
	
		for(int i=1;i<=15;i++) {
			CommonMethod.click("V2ProjectHsrPursuingYes");
			Thread.sleep(2000);
		}
	}
	public void uploadDocumentWpr() throws IOException, InterruptedException {

		CommonMethod.WaitUntilVisibility("V2ProjectWPRPDocIcon", 300);
		CommonMethod.click("V2ProjectWPRPDocIcon");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 300);
		CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
		CommonMethod.uploadFile("V2ProjectDocUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("V2ProjectWPRUploadbtn", 300);
		CommonMethod.click("V2ProjectWPRUploadbtn");
		Thread.sleep(5000);
		CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");


	}
	public void uploadHsrDocV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		//feature0
		CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 300);
		CommonMethod.click("V2ProjectWPRPFeature");
		uploadDocumentWpr();
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectWPRPFeature");
		
		//feature1
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature1", 300);
		CommonMethod.click("V2ProjectWPRPFeature1");
		uploadDocumentWpr();
		CommonMethod.click("V2ProjectWPRPFeature1");
		Thread.sleep(2000);
		
		
}
	public void hsrReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 300);
		String getCurrentUrl = driver.getCurrentUrl().replaceAll("wpr","reviews");
		CommonMethod.GotoURL(getCurrentUrl);
		CommonMethod.click("V2ProjectSubmitForReviewlink");
		CommonMethod.WaitUntilClickble("V2ProjectsubmitReview", 60);
		CommonMethod.click("V2ProjectsubmitReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60);
		CommonMethod.sendKeys("V2ProjectcommentReview", "Final Documentation Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdown("V2ProjectSelectPhase", "Final Documentation Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingHsrcbx");
		CommonMethod.WaitUntilClickble("V2ProjectSubmitPhaseReview", 60);
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilClickble("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60);
		CommonMethod.sendKeys("AdminV2ProjectId", data.getCellData(SheetName, "projectId", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.click("ReviwTab");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectReviewViewbtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectReturnReviewbtn");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60);
		CommonMethod.sendKeys("V2ProjectReviewCommentNarrative", "Final Precertification Review");
		CommonMethod.sendKeys("V2ProjectGeneralCommentNarrative", "Final Precertification Review");
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
	
	public void performanceV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PerformanceTab", 300);
		CommonMethod.click("PerformanceTab");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRContinuebtn", 300);
		CommonMethod.click("V2ProjectWPRContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRTermscbx", 300);
		CommonMethod.ClickCheckbox("V2ProjectWPRTermscbx");
		CommonMethod.click("V2ProjectWPRTermsbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 300);
		CommonMethod.ClickCheckbox("V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRProceedbtn", 300);
		CommonMethod.click("V2ProjectWPRProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRAccountbtn", 300);
		CommonMethod.click("V2ProjectWPRAccountbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrScorecard", 300);
		for(int i=1;i<=38;i++) {
			CommonMethod.click("V2ProjectHsrPursuingNo");
			Thread.sleep(3000);
		}
		CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrPursuingYes", 300);
		for(int i=1;i<=21;i++) {
			CommonMethod.click("V2ProjectHsrPursuingYes");
			Thread.sleep(3000);
		}
	}
	
	public void uploadPerformanceDocV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		//feature0
		CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 300);
		CommonMethod.click("V2ProjectWPRPFeature");
		uploadDocumentWpr();
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectWPRPFeature");
		
		//feature1
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature1", 300);
		CommonMethod.click("V2ProjectWPRPFeature1");
		uploadDocumentWpr();
		CommonMethod.click("V2ProjectWPRPFeature1");
		Thread.sleep(2000);
		//feature2
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature2", 300);
				CommonMethod.click("V2ProjectWPRPFeature2");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature2");
				Thread.sleep(2000);
				//feature3
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature3", 300);
				CommonMethod.click("V2ProjectWPRPFeature3");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature3");
				Thread.sleep(2000);
				//feature4
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature4", 300);
				CommonMethod.click("V2ProjectWPRPFeature4");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature4");
				Thread.sleep(2000);
				//feature5
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature5", 300);
				CommonMethod.click("V2ProjectWPRPFeature5");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature5");
				Thread.sleep(2000);
				//feature6
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature6", 300);
				CommonMethod.click("V2ProjectWPRPFeature6");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature6");
				Thread.sleep(2000);
				//feature7
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature7", 300);
				CommonMethod.click("V2ProjectWPRPFeature7");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature7");
				Thread.sleep(2000);
				//feature8
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature8", 300);
				CommonMethod.click("V2ProjectWPRPFeature8");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature8");
				Thread.sleep(2000);
				//feature9
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature9", 300);
				CommonMethod.click("V2ProjectWPRPFeature9");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature9");
				Thread.sleep(2000);
				//feature10
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature10", 300);
				CommonMethod.click("V2ProjectWPRPFeature10");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature10");
				Thread.sleep(2000);
				//feature11
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature11", 300);
				CommonMethod.click("V2ProjectWPRPFeature11");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature11");
				Thread.sleep(2000);
				//feature12
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature12", 300);
				CommonMethod.click("V2ProjectWPRPFeature12");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature12");
				Thread.sleep(2000);
				//feature13
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature13", 300);
				CommonMethod.click("V2ProjectWPRPFeature13");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature13");
				Thread.sleep(2000);
				//feature14
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature14", 300);
				CommonMethod.click("V2ProjectWPRPFeature14");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature14");
				Thread.sleep(2000);
				//feature15
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature15", 300);
				CommonMethod.click("V2ProjectWPRPFeature15");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature15");
				Thread.sleep(2000);
				//feature16
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature16", 300);
				CommonMethod.click("V2ProjectWPRPFeature16");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature16");
				Thread.sleep(2000);
				//feature17
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature17", 300);
				CommonMethod.click("V2ProjectWPRPFeature17");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature17");
				Thread.sleep(2000);
				//feature18
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature18", 300);
				CommonMethod.click("V2ProjectWPRPFeature18");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature18");
				Thread.sleep(2000);
				//feature19
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature19", 300);
				CommonMethod.click("V2ProjectWPRPFeature19");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature19");
				Thread.sleep(2000);
				//feature20
				CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature20", 300);
				CommonMethod.click("V2ProjectWPRPFeature20");
				uploadDocumentWpr();
				CommonMethod.click("V2ProjectWPRPFeature20");
				Thread.sleep(2000);	

	}
	public void wprReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 300);
		String getCurrentUrl = driver.getCurrentUrl().replaceAll("wpr","reviews");
		CommonMethod.GotoURL(getCurrentUrl);
		CommonMethod.WaitUntilVisibility("V2ProjectsubmitReview", 300);
		CommonMethod.click("V2ProjectsubmitReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60);
		CommonMethod.sendKeys("V2ProjectcommentReview", "Final Performance Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdown("V2ProjectSelectPhase", "Final Performance Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingWprcbx");
		CommonMethod.WaitUntilVisibility("V2ProjectSubmitPhaseReview", 300);
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 300);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilVisibility("AdminV2ProjectId", 300);
		CommonMethod.sendKeys("AdminV2ProjectId", data.getCellData(SheetName, "projectId", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.click("ReviwTab");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectReviewViewbtn", 300);
		CommonMethod.click("V2ProjectReviewViewbtn");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectReturnReviewbtn", 300);
		CommonMethod.click("V2ProjectReturnReviewbtn");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60);
		CommonMethod.sendKeys("V2ProjectReviewCommentNarrative", "Preliminary Precertification Review");
		CommonMethod.sendKeys("V2ProjectGeneralCommentNarrative", "Preliminary Precertification Review");
		CommonMethod.WaitUntilVisibility("V2ProjectdocsubUpdatebtn", 300);
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectdocsubUpdatebtn");
		CommonMethod.WaitUntilClickble("V2ProjectdocsubOkbtn", 60);
		CommonMethod.click("V2ProjectdocsubOkbtn");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("V2ProjectPaymentstatus", 300);
		CommonMethod.ClickCheckbox("V2ProjectPaymentstatus");
		CommonMethod.WaitUntilVisibility("V2ProjectReturnReviewSubmit", 300);
		CommonMethod.click("V2ProjectReturnReviewSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectReviwedStatus", 300);
		CommonMethod.assertcontainsmessage("V2ProjectReviwedStatus", "REVIEWED", "Verified Review status");	
	}
	
	public void teamV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TeamTab", 300);
		CommonMethod.click("TeamTab");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 300);
		CommonMethod.click("V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectEmailAddress", 300);
		CommonMethod.sendKeys("V2ProjectEmailAddress", "gokulthiru22@gmail.com");
		CommonMethod.selectdropdown("V2ProjectRole", "Acoustician");
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		CommonMethod.WaitUntilVisibility("V2ProjectInvitebtn", 300);
		CommonMethod.click("V2ProjectInvitebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectDeleteIcon", 300);
		CommonMethod.click("V2ProjectDeleteIcon");
		Thread.sleep(2000);
	}
}
