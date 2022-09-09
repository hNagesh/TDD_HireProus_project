package com.Well.ReusableMethods;

import java.io.IOException;
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

	public void CompleteScorecardV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		CommonMethod.WaitUntilClickble("V2ProjectAirconcept", 60);
		CommonMethod.click("V2ProjectAirconcept");
		
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 15; i++) {	
		int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 10; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Water concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectWaterconcept", 60);
		CommonMethod.click("V2ProjectWaterconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 13; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		CommonMethod.scrollUp();
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 4; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Nourisement concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectNourisementconcept", 60);
		CommonMethod.click("V2ProjectNourisementconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 14; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 1; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Light concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectLightconcept", 60);
		CommonMethod.click("V2ProjectLightconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 6; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 6; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Movement concept
		 */
		CommonMethod.WaitUntilClickble("V2Projectmovementconcept", 60);
		CommonMethod.click("V2Projectmovementconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 11; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		CommonMethod.scrollUp();
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 11; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Thermal concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectThermalconcept", 60);
		CommonMethod.click("V2ProjectThermalconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 10; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		CommonMethod.scrollUp();
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 5; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Sound concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectSoundconcept", 60);
		CommonMethod.click("V2ProjectSoundconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 9; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		CommonMethod.scrollUp();
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 5; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Material concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMaterialconcept", 60);
		CommonMethod.click("V2ProjectMaterialconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 17; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 7; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Mind concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMindconcept", 60);
		CommonMethod.click("V2ProjectMindconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 8; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 11; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Community concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectCommunityconcept", 60);
		CommonMethod.click("V2ProjectCommunityconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 17; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 18; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
		/*
		 * Innovation concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectInnovationconcept", 60);
		CommonMethod.click("V2ProjectInnovationconcept");
		YesButton = CommonMethod.findElements("V2ProjectPurseYes");
		for (int i = 1; i <= 10; i++) {
			int RemainingYes = YesButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseYes", 60);
			CommonMethod.click("V2ProjectPurseYes");
			Thread.sleep(4000);
			YesButton = CommonMethod.findElements("V2ProjectPurseYes");
			}while(YesButton.size()==RemainingYes);
			RemainingYes--;
		}
		NoButton = CommonMethod.findElements("V2ProjectPurseNo");
		for (int i = 1; i <= 8; i++) {
			int RemainingNo = NoButton.size();
			do {
			CommonMethod.WaitUntilClickble("V2ProjectPurseNo", 60);
			CommonMethod.click("V2ProjectPurseNo");
			Thread.sleep(4000);
			NoButton = CommonMethod.findElements("V2ProjectPurseNo");
			}while(NoButton.size()==RemainingNo);
			RemainingNo--;
		}
		RefreshScorecard();
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
		CommonMethod.WaitUntilClickble("HealthSafetyTab", 60);
		CommonMethod.click("HealthSafetyTab");
		CommonMethod.WaitUntilClickble("V2ProjectHsrContinuebtn", 60);
		CommonMethod.click("V2ProjectHsrContinuebtn");
		CommonMethod.WaitUntilClickble("V2ProjectHsrTermscbx", 60);
		CommonMethod.click("V2ProjectHsrTermscbx");
		CommonMethod.click("V2ProjectHsrTermsbtn");
		CommonMethod.click("V2ProjectHsrProceedbtn");
		CommonMethod.click("V2ProjectHsrAccountbtn");
		for(int i=1;i<=15;i++) {
			CommonMethod.click("V2ProjectHsrPursuingYes");
		}
		for(int i=1;i<=12;i++) {
			CommonMethod.click("V2ProjectHsrPursuingNo");
		}
		
	}
	
}
