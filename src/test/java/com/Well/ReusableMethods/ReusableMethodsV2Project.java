package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import com.github.javafaker.Internet.UserAgent;

public class ReusableMethodsV2Project extends BaseClass {

	public void RegisterV2Project(String SheetName, int rowNum, String ProjectType) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WELLCertificationNavBar");
		CommonMethod.WaitUntilVisibility("V2Projectstartav2projectbtn", 300);
		CommonMethod.click("V2Projectstartav2projectbtn");
		CommonMethod.click("V2ProjectstartProjectcontinuebtn");
		String ProjectName = "Automation V2 Project" + CommonMethod.randomNumber(8000000);

		testlog.info("ProjectName: " +ProjectName);
		data.setCellData("V2Project", "ProjectName", 2, ProjectName);
		CommonMethod.sendKeys("V2Projectprojectnickname", ProjectName);
		CommonMethod.click("V2ProjectnicknameContinuebtn");
		CommonMethod.selectdropdown("V2ProjectlocationCountry", "United States");
		data.setCellData("V2Project", "Country", 2, CommonMethod.getSelectedDropdownValue("V2ProjectlocationCountry"));
		CommonMethod.selectdropdownrandom("V2ProjectlocationState");
		data.setCellData("V2Project", "State", 2, CommonMethod.getSelectedDropdownValue("V2ProjectlocationState"));
		testlog.info("Country: " +data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " +data.getCellData(SheetName, "State", rowNum));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Street: " +ProjectAddress);
		testlog.info("City: " +ProjectCity);
		testlog.info("Postalcode: " +PostalCode);
		CommonMethod.sendKeys("V2ProjectlocationStreet", ProjectAddress);
		data.setCellData("V2Project", "Street", 2, CommonMethod.getText("V2ProjectlocationStreet"));
		CommonMethod.sendKeys("V2ProjectlocationCity", ProjectCity);
		data.setCellData("V2Project", "City", 2, CommonMethod.getText("V2ProjectlocationCity"));
		CommonMethod.sendKeys("V2ProjectlocationPostalcode", PostalCode);
		data.setCellData("V2Project", "PostalCode", 2, CommonMethod.getText("V2ProjectlocationPostalcode"));
		CommonMethod.click("V2ProjectlocationContinuebtn");
		String Area = CommonMethod.randomNumberBetweenRanges(100,50000);
		CommonMethod.clear("V2ProjectareaSize");
		CommonMethod.sendKeys("V2ProjectareaSize", Area);
		data.setCellData("V2Project", "Area", 2, CommonMethod.getattributeValue("V2ProjectareaSize"));
		testlog.info("Area: " +data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.click("V2ProjectareaContinuebtn");
		CommonMethod.ClickCheckbox("V2ProjectspaceType");
		CommonMethod.WaitUntilVisibility("V2ProjectspacetypeContinuebtn", 60);
		CommonMethod.click("V2ProjectspacetypeContinuebtn");
		if (ProjectType.equalsIgnoreCase("WELLCore")) {
			CommonMethod.WaitUntilVisibility("V2Projectwellcorecertification", 30);
			CommonMethod.click("V2Projectwellcorecertification");
		}
		else if (ProjectType.equalsIgnoreCase("WELLCertification")) {
			CommonMethod.WaitUntilVisibility("V2ProjectwellCertification", 30);
			CommonMethod.click("V2ProjectwellCertification");
			CommonMethod.WaitUntilVisibility("V2ProjectownershipOflocation", 30);
			CommonMethod.ClickCheckbox("V2ProjectownershipOflocation");
			CommonMethod.click("V2ProjectownershipContinuebtn");
		}
		CommonMethod.WaitUntilVisibility("DatePickerButton", 300);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilVisibility("V2ProjectnextMonthbtn", 300);
		CommonMethod.Robustclick("V2ProjectnextMonthbtn", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilVisibility("V2ProjectselectNextMonth", 300);
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectselectNextMonth");
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 300);
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.WaitUntilClickble("V2ProjectdocsubConfirmbtn", 60);
		CommonMethod.click("V2ProjectdocsubConfirmbtn");
		CommonMethod.click("V2Projectcontinuethejourneybtn");
		CommonMethod.WaitUntilVisibility("EnrollTab", 300);
		CommonMethod.WaitUntilVisibility("StoreId", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData("V2Project", "ProjectId", 2, getProjectId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void SearchV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WELLCertificationNavBar");
		CommonMethod.WaitUntilClickble("V2ProjectId", 60);
		testlog.info("ProjectId:" +data.getCellData(SheetName, "ProjectId", rowNum));
		CommonMethod.sendKeys("V2ProjectId", data.getCellData(SheetName, "ProjectId", rowNum));
		CommonMethod.click("V2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectIdCompare");
		testlog.pass("**Verifies the Search V2Project ByID successfully**");
	}

	public void EnrollV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("EnrollTab", 60);
		CommonMethod.click("EnrollTab");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.ClickRandomWebElement("SelectOwnerOrgDyn");
		data.setCellData("V2Project", "Org", 2, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " +data.getCellData(SheetName, "Org", rowNum));
		String Ownername = USfaker.address().firstName();
		String Email = USfaker.internet().emailAddress();
		String Phoneno = USfaker.number().digits(10);
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Ownername: " +Ownername);
		CommonMethod.sendKeys("V2ProjectownerName", Ownername);
		data.setCellData("V2Project", "OwnerName", 2, CommonMethod.getattributeValue("V2ProjectownerName"));
		testlog.info("OwnerEmail: " +Email);
		CommonMethod.sendKeys("V2ProjectownerEmail", Email);
		Thread.sleep(20000);
		data.setCellData("V2Project", "OwnerEmail", 2, CommonMethod.getattributeValue("V2ProjectownerEmail"));
		Thread.sleep(20000);
		CommonMethod.sendKeys("V2Projectownerphone", Phoneno);
		data.setCellData("V2Project", "PhoneNum", 2, CommonMethod.getattributeValue("V2Projectownerphone"));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData("V2Project", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.sendKeys("V2Projectorganizationwebsite", "https://test-nuxt.wellcertified.com/projects/v2/2202266385/register");
		data.setCellData("V2Project", "Website", 2, CommonMethod.getattributeValue("V2Projectorganizationwebsite"));
		CommonMethod.sendKeys("V2ProjectorganizationOverview", Ownername);
		data.setCellData("V2Project", "Overview", 2, CommonMethod.getattributeValue("V2ProjectorganizationOverview"));
		CommonMethod.ClickCheckbox("V2ProjectconstructionOrrenovation");
		CommonMethod.click("V2ProjectdocsubEstidate");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		CommonMethod.click("V2ProjectdocsubAnticdate");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		CommonMethod.click("V2ProjectprojectOwnerContinuebtn");
		testlog.info("Country:" + "United States");
		CommonMethod.selectdropdown("V2ProjectprojectaddressCountry", "United States");
		data.setCellData("V2Project", "Country", 2, CommonMethod.getSelectedDropdownValue("V2ProjectprojectaddressCountry"));
		CommonMethod.WaitUntilVisibility("V2ProjectprojectState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectprojectState");
		data.setCellData("V2Project", "State", 2, CommonMethod.getSelectedDropdownValue("V2ProjectprojectState"));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		testlog.info("Organization Address:" + ProjectAddress1);
		testlog.info("Organization City:" + ProjectCity);
		testlog.info("Organization Postalcode:" + PostalCode);
		CommonMethod.sendKeys("V2ProjectprojectaddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectprojectaddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectprojectaddressPostalcode", PostalCode);
		CommonMethod.selectdropdown("V2ProjectowneraddressCountry", "United States");
		CommonMethod.WaitUntilVisibility("V2ProjectowneraddressState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectowneraddressState");
		CommonMethod.sendKeys("V2ProjectowneraddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectowneraddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectowneraddressPostalcode", PostalCode);
		data.setCellData("V2Project", "Street", 2, CommonMethod.getattributeValue("V2ProjectowneraddressStreet"));
		data.setCellData("V2Project", "City", 2, CommonMethod.getattributeValue("V2ProjectowneraddressCity"));
		data.setCellData("V2Project", "PostalCode", 2, CommonMethod.getattributeValue("V2ProjectowneraddressPostalcode"));
		CommonMethod.ClickCheckbox("V2Projectisthisapublicproject");
		CommonMethod.click("V2ProjectprojectaddressContinuebtn");
		CommonMethod.WaitUntilVisibility("BiilingTab", 300);
		testlog.pass("**Verifies the Enrolling successfully**");
	}

	public void ClickBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 300);
		CommonMethod.click("BiilingTab");
		CommonMethod.click("PortfolioPayNowButton");
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void Billing(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BillingLanding", 300);
		CommonMethod.scrolldowntoElement("CardHolderName");
		CommonMethod.WaitUntilClickble("CardHolderName", 60);
		testlog.info("firstName:" + USfaker.address().firstName());
		CommonMethod.sendKeys("CardHolderName", USfaker.address().firstName());
		data.setCellData("V2Project", "CardHolderName", 2, CommonMethod.getattributeValue("CardHolderName"));
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardNumberIframe");
		CommonMethod.WaitUntilClickble("CardHolderNumber", 60);
		Thread.sleep(2000);
		testlog.info("CardHolderNumber:" + "4111111111111111");
		CommonMethod.sendKeys("CardHolderNumber", "4111111111111111");
		data.setCellData("V2Project", "CardHolderNumber", 2, CommonMethod.getattributeValue("CardHolderNumber"));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardExpDateIframe");
		testlog.info("CardHolderExpDate:"+"0925");
		CommonMethod.WaitUntilClickble("CardHolderExpDate", 60).sendKeys("0");
		CommonMethod.sendKeys("CardHolderExpDate", "9");
		CommonMethod.sendKeys("CardHolderExpDate", "2");
		CommonMethod.sendKeys("CardHolderExpDate", "5");
		data.setCellData("V2Project", "CardHolderExpDate", 2, CommonMethod.getattributeValue("CardHolderExpDate"));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardCVVIframe");
		CommonMethod.WaitUntilClickble("CardHolderCVC", 60);
		testlog.info("CardHolderCVC:" + "999");
		CommonMethod.sendKeys("CardHolderCVC", "999");
		data.setCellData("V2Project", "CardHolderCVC", 2, CommonMethod.getattributeValue("CardHolderCVC"));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("PayNowButton", 10);
		CommonMethod.click("PayNowButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilInVisibility("CardHolderName", 180);
		testlog.pass("**Verifies the Completed Card Payment Billing successfully**");
	}

	public void AgreementV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		CommonMethod.click("WellV2DashboardTab");
		CommonMethod.WaitUntilClickble("V2ProjectSignNow", 60);
		CommonMethod.Robustclick("V2ProjectSignNow");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 30);
		testlog.pass("**Verifies Agreement V2Project successfully**");
	}

	public void BuildScorecardV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectStartBuilding", 60);
		CommonMethod.click("V2ProjectStartBuilding");
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", 300);
		testlog.pass("**Verfies Scorecard Page successfully**");
	}

	public void RefreshScorecard() throws IOException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("ScoreCardPageLand", 300);
	}

	public void Scorecardfill(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne)
			throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			System.out.println(RemainingYes);
			do {
				CommonMethod.WaitUntilClickble("V2ProjectHsrPurseYes", 60);
				CommonMethod.click("V2ProjectHsrPurseYes");
				Thread.sleep(1000);
				YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
				System.out.println(YesButton);
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}

		NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
				CommonMethod.click(NoButton.get(RemainingNo - j));
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
		RefreshScorecard();
	}

	public void ScorecardfillHSRWPR(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne)
			throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
				CommonMethod.click(NoButton.get(RemainingNo - j));
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
		CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");
		YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			do {
				CommonMethod.WaitUntilClickble("V2ProjectHsrPurseYes", 60);
				CommonMethod.click("V2ProjectHsrPurseYes");
				Thread.sleep(1000);
				YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}

	}

	public void CompleteScorecardHsrById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2ScorecardTab", 300);
		CommonMethod.click("WellV2ScorecardTab");
		Scorecardfill(15, 16, 27, 8);
		testlog.pass("**Verifies the 15 Purse Yes Scorecard HealthSafety ByID successfully**");
	}

	public void CompleteScorecardV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectAirconcept", 60);
		CommonMethod.click("V2ProjectAirconcept");
		Scorecardfill(15, 16, 25, 10);
		/*
		 * Water concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectWaterconcept", 60);
		CommonMethod.click("V2ProjectWaterconcept");
		Scorecardfill(13, 14, 17, 4);
		/*
		 * Nourisement concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectNourisementconcept", 60);
		CommonMethod.click("V2ProjectNourisementconcept");
		Scorecardfill(13, 14, 15, 2);
		/*
		 * Light concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectLightconcept", 60);
		CommonMethod.click("V2ProjectLightconcept");
		Scorecardfill(6, 7, 12, 6);
		/*
		 * Movement concept
		 */
		CommonMethod.WaitUntilClickble("V2Projectmovementconcept", 60);
		CommonMethod.click("V2Projectmovementconcept");
		Scorecardfill(11, 12, 22, 11);
		/*
		 * Thermal concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectThermalconcept", 60);
		CommonMethod.click("V2ProjectThermalconcept");
		Scorecardfill(10, 11, 15, 5);
		/*
		 * Sound concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectSoundconcept", 60);
		CommonMethod.click("V2ProjectSoundconcept");
		Scorecardfill(9, 10, 14, 5);
		/*
		 * Material concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMaterialconcept", 60);
		CommonMethod.click("V2ProjectMaterialconcept");
		Scorecardfill(17, 18, 24, 7);
		/*
		 * Mind concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectMindconcept", 60);
		CommonMethod.click("V2ProjectMindconcept");
		Scorecardfill(8, 9, 19, 11);
		/*
		 * Community concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectCommunityconcept", 60);
		CommonMethod.click("V2ProjectCommunityconcept");
		Scorecardfill(17, 18, 35, 18);
		/*
		 * Innovation concept
		 */
		CommonMethod.WaitUntilClickble("V2ProjectInnovationconcept", 60);
		CommonMethod.click("V2ProjectInnovationconcept");

		Scorecardfill(10, 11, 18, 8);
//		Thread.sleep(4000);
//		CommonMethod.Isdisplayed("V2ProjectScorecardYesCount", 60);
//		int YesFeatureCount = CommonMethod.ElementSize("V2ProjectScorecardYesCount");
//		String yesFeatureCount = Integer.toString(YesFeatureCount);
//		CommonMethod.assertActualContainsExpected(yesFeatureCount, "130", "Verified Scorecard part Yes Count");
//		int NoFeatureCount = CommonMethod.ElementSize("V2ProjectScorecardNoCount");
//		String noFeatureCount = Integer.toString(NoFeatureCount);
//		CommonMethod.assertActualContainsExpected(noFeatureCount, "86", "Verified Scorecard part No Count");
		testlog.pass("**Verifies the 134 Purse Yes Scorecard V2Project successfully**");
		testlog.pass("**Verifies the 86 Purse Yes Scorecard V2Project successfully**");
	}

	public void UploadFeatureDocV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardFeature", 60);
		CommonMethod.click("V2ProjectScorecardFeature");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2ProjectscorecardDocbtn");
		testlog.info("TaskName : Performance Test OR Sensor Data");
		CommonMethod.selectdropdown("V2Projectscorecardverificationdropdown", "Performance Test OR Sensor Data");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2Projectscorecarddocuploadsubmit");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies the Upload Document in Scorecard Feature successfully**");

	}

	public void UploadAuditDocV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardAuditFeature", 60);
		CommonMethod.click("V2ProjectScorecardAuditFeature");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2ProjectscorecardDocbtn");
		testlog.info("TaskName : Technical Document (Audited)");
		CommonMethod.selectdropdown("V2Projectscorecardverificationdropdown", "Technical Document (Audited)");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2Projectscorecarddocuploadsubmit");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies the Upload Document in Scorecard Audit Feature successfully**");

	}

	public void UploadDocumentInDocV2Project(String SheetName, int rowNum, String DocumentType)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.click("V2ProjectDocUploadbtn");
		testlog.info("Document Type : General");
		CommonMethod.selectdropdown("V2ProjectPortfolioDocType", DocumentType);
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.click("V2ProjectDocSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("V2ProjectDocUploadbtn", 30);
		testlog.pass("**Upload Document successfully**");
	}

	public void UploadOngoingDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.click("V2ProjectDocUploadbtn");
		testlog.info("Document Type" + "Ongoing data reports");
		CommonMethod.selectdropdown("V2ProjectPortfolioDocType", "Ongoing data reports");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectResetbtn");
		Thread.sleep(1000);
		CommonMethod.selectdropdown("V2ProjectPortfolioDocType", "Legal");
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectResetbtn");
		Thread.sleep(2000);
		CommonMethod.selectdropdown("V2ProjectPortfolioDocType", "Ongoing data reports");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.selectdropdown("V2ProjectDocPeriod", "Year 1 reporting");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilClickble("V2ProjectDocSubmit", 60);
		CommonMethod.click("V2ProjectDocSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("V2ProjectDocUploadbtn", 30);
		testlog.pass("**Upload Document successfully**");
	}

	public void UploadFeatureDocumentInDocV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.click("V2ProjectDocUploadbtn");
		Thread.sleep(2000);
		testlog.info("Document Type" + "Feature");
		CommonMethod.selectdropdown("V2ProjectPortfolioDocType", "Feature");
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
		CommonMethod.WaitUntilClickble("V2ProjectDocUploadbtn", 30);
		testlog.pass("**Upload Document successfully**");
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
		testlog.pass("**Verifies Uploaded Document successfully**");
	}

	public void ReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 20);
		CommonMethod.WaitUntilVisibility("V2ProjectsubmitReview", 60);
		CommonMethod.click("V2ProjectsubmitReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdown("V2ProjectSelectPhase", "Preliminary Precertification Review");
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60)
				.sendKeys(data.getCellData(SheetName, "projectId", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("Adminv2ProjectNameVerify", "Automation", "Project name doesn't matches in search");
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.click("ReviewViewButton");
		Thread.sleep(2000);
		CommonMethod.click("ReviewReturnButton");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60)
				.sendKeys("Preliminary Precertification Review");
		CommonMethod.sendKeys("V2ProjectGeneralCommentNarrative", "Preliminary Precertification Review");
		CommonMethod.WaitUntilClickble("DatePickerButton", 60);
		Thread.sleep(1000);
		CommonMethod.click("DatePickerButton");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.click("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Reviewed Preliminary Precertification Review successfully**");
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
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
		ScorecardfillHSRWPR(15, 1, 27, 27);
		testlog.pass("**Verifies the 15 Purse Yes Scorecard Performance ByID successfully**");
	}

	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");
		for (WebElement f : Feature) {
			CommonMethod.click(f);
			CommonMethod.WaitUntilVisibility("V2ProjectWPRPDocIcon", 60);
			CommonMethod.click("V2ProjectWPRPDocIcon");
			CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 60);
			CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
			CommonMethod.uploadFile("V2ProjectDocUpload", PortfolioLocationImportfile);
			CommonMethod.WaitUntilVisibility("FeatureFileUploadedVisible", 60);
			CommonMethod.Robustclick("V2ProjectWPRUploadbtn");
			CommonMethod.scrolldowntoElement("V2ProjectHsrScorecard");
			CommonMethod.click(f);
		}

	}

	public void uploadHsrDocV2Project() throws IOException, InterruptedException {
		uploadDocumentInFeature(16);
		testlog.pass("**Upload 15 Scorecard Documents successfully**");
	}

	public void hsrReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 300);
		String getCurrentUrl = driver.getCurrentUrl().replaceAll("hsr", "reviews");
		CommonMethod.GotoURL(getCurrentUrl);
		CommonMethod.click("V2ProjectsubmitReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60).sendKeys("Final Documentation Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdown("V2ProjectSelectPhase", "Final Documentation Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingHsrcbx");
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		testlog.pass("**Reviewed Final Precertification Review successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilClickble("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60).sendKeys(data.getCellData(SheetName, "ProjectId", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.click("ReviewTab");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectHSRReviewViewbtn");
		Thread.sleep(2000);
		CommonMethod.click("ReviewReturnButton");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Final Review");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60).sendKeys("Final Precertification Review");
		CommonMethod.WaitUntilClickble("DatePickerButton", 60).click();
		CommonMethod.WaitUntilClickble("DatePickerOkButton", 60).click();
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.click("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Final Precertification Review successfully**");
	}

	public void performanceV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PerformanceTab", 300);
		CommonMethod.click("PerformanceTab");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRContinuebtn", 300);
		CommonMethod.Robustclick("V2ProjectWPRContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRTermscbx", 60);
		CommonMethod.ClickCheckbox("V2ProjectWPRTermscbx");
		CommonMethod.click("V2ProjectWPRTermsbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 300);
		CommonMethod.ClickCheckbox("V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRProceedbtn", 300);
		CommonMethod.click("V2ProjectWPRProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRAccountbtn", 300);
		CommonMethod.click("V2ProjectWPRAccountbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrScorecard", 300);
		ScorecardfillHSRWPR(21, 1, 38, 38);
		testlog.pass("**Verifies the 21 Purse Yes Scorecard Performance successfully**");
	}

	public void uploadPerformanceDocV2Project() throws IOException, InterruptedException {
		uploadDocumentInFeature(21);
		testlog.pass("**Upload 21 Scorecard Documents successfully**");
	}

	public void wprReviewV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectWPRPFeature", 300);
		String getCurrentUrl = driver.getCurrentUrl().replaceAll("wpr", "reviews");
		CommonMethod.GotoURL(getCurrentUrl);
		CommonMethod.WaitUntilVisibility("V2ProjectsubmitReview", 300);
		CommonMethod.click("V2ProjectsubmitReview");
		CommonMethod.WaitUntilClickble("V2ProjectcommentReview", 60).sendKeys("Final Performance Review");
		Thread.sleep(4000);
		CommonMethod.selectdropdown("V2ProjectSelectPhase", "Final Performance Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingHsrcbx");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingWprcbx");
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		testlog.pass("**Reviewed Final Precertification Review successfully**");

		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 300);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilVisibility("AdminV2ProjectId", 300)
				.sendKeys(data.getCellData(SheetName, "projectId", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.click("ReviewTab");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectWPRReviewViewbtn", 30);
		CommonMethod.click("V2ProjectWPRReviewViewbtn");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 30);
		CommonMethod.click("ReviewReturnButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Final Review");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60).sendKeys("Final Precertification Review");
		CommonMethod.WaitUntilVisibility("DatePickerButton", 300);
		Thread.sleep(1000);
		CommonMethod.click("DatePickerButton");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("ReviewReturnSubmit", 300);
		CommonMethod.click("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Final Precertification Review successfully**");
	}

	public void teamV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TeamTab", 300);
		CommonMethod.click("TeamTab");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 30);
		CommonMethod.click("V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectEmailAddress", 30);
		CommonMethod.sendKeys("V2ProjectEmailAddress", "gokulthiru22@gmail.com");
		CommonMethod.selectdropdown("V2ProjectRole", "Acoustician");
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		CommonMethod.WaitUntilVisibility("V2ProjectInvitebtn", 30);
		CommonMethod.click("V2ProjectInvitebtn");
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("V2ProjectDeleteIcon", 30);
		CommonMethod.click("V2ProjectDeleteIcon");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 300);
		testlog.pass("**Created Team member successfully**");
	}

	public void supportV2Project() throws IOException, InterruptedException {

		CommonMethod.WaitUntilVisibility("SupportButton", 60);
		CommonMethod.click("SupportButton");
		CommonMethod.WaitUntilVisibility("GetHelpButton", 60);
		CommonMethod.click("GetHelpButton");
		CommonMethod.WaitUntilVisibility("QuestionAboutDropdown", 60);
		CommonMethod.selectdropdown("QuestionAboutDropdown", "Feature");
		CommonMethod.WaitUntilVisibility("IssueSubTypeDropdown", 60);
		CommonMethod.selectdropdown("IssueSubTypeDropdown", "A01 Air Quality");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 6).click();
		CommonMethod.WaitUntilClickble("SubjectInputField", 60).sendKeys("Test1");
		CommonMethod.WaitUntilClickble("DescriptionTextArea", 60).sendKeys("Testing");
		CommonMethod.uploadFile("DocumentsUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.click("SubmitButton");
		CommonMethod.assertcontainsmessage("NewStatus", "New", "Verified New status");
		testlog.pass("**Raised support ticket successfully**");
	}

	public void alternativesV2Project(String alternativeOption) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AlternativesButton", 60);
		CommonMethod.click("AlternativesButton");

		if (alternativeOption.equalsIgnoreCase("EP")) {
			CommonMethod.click("EPSubmitButton");
			CommonMethod.WaitUntilVisibility("FeatureDropdown", 60);
			CommonMethod.selectdropdown("FeatureDropdown", "A01 Air Quality");
			CommonMethod.WaitUntilVisibility("ApplicablePartCheckBox", 60);
			CommonMethod.click("ApplicablePartCheckBox");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyReason", 60).sendKeys("xyz");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyCountriesInput", 60).sendKeys("abc");
			CommonMethod.WaitUntilClickble("V2ProjectVerificationTextArea", 60).sendKeys("pqr");
			CommonMethod.WaitUntilClickble("V2ProjectSimilaritiesTextArea", 60).sendKeys("mno");
			CommonMethod.WaitUntilClickble("V2ProjectDifferencesTextArea", 60).sendKeys("Testing");

		} else if (alternativeOption.equalsIgnoreCase("AAP")) {
			
			CommonMethod.scrollUp();
			CommonMethod.WaitUntilVisibility("AapSubmitButton", 60);
			CommonMethod.click("AapSubmitButton");
			CommonMethod.WaitUntilVisibility("FeatureDropdown", 60);
			CommonMethod.selectdropdown("FeatureDropdown", "A01 Air Quality");
			CommonMethod.WaitUntilVisibility("ApplicablePartCheckBox", 60);
			CommonMethod.click("ApplicablePartCheckBox");
			CommonMethod.WaitUntilClickble("AlternativesReasonTextArea", 60).sendKeys("Test2");
		}

		CommonMethod.WaitUntilClickble("AlternativesProposedTextArea", 60).sendKeys("For testing");
		CommonMethod.uploadFile("DocumentsUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.click("SubmitButton");
		if (alternativeOption.equalsIgnoreCase("EP")) {

			CommonMethod.WaitUntilVisibility("V2projectEPTypeStatus", 60);
			CommonMethod.assertcontainsmessage("V2projectEPTypeStatus", "EP", "Verified EP status");
			testlog.pass("**Added alternative EP documents successfully**");
		} else if (alternativeOption.equalsIgnoreCase("AAP")) {

			CommonMethod.WaitUntilVisibility("V2projectAAPTypeStatus", 60);
			CommonMethod.assertcontainsmessage("V2projectAAPTypeStatus", "AAP", "Verified AAP status");
			testlog.pass("**Added alternative AAP documents successfully**");
		}
	}

}