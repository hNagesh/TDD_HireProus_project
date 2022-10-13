package com.Well.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsV2Project extends BaseClass {

	public void RegisterV2Project(String SheetName, int rowNum, String ProjectType, String Country)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLCertificationNavBar");
		CommonMethod.click("WELLCertificationNavBar");
		CommonMethod.WaitUntilVisibility("V2Projectstartav2projectbtn", 300);
		CommonMethod.Robustclick("V2Projectstartav2projectbtn");
		CommonMethod.Robustclick("V2ProjectstartProjectcontinuebtn");
		String ProjectName = "Automation V2 Project" + CommonMethod.randomNumber(8000000);
		testlog.info("V2 ProjectName is: " + ProjectName);
		data.setCellData(SheetName, "ProjectName", rowNum, ProjectName);
		CommonMethod.sendKeys("V2Projectprojectnickname", ProjectName);
		CommonMethod.RobustclickElementVisible("V2ProjectnicknameContinuebtn", "V2ProjectlocationContinuebtn");
		rc.SelectCountryAndState(Country, SheetName, rowNum);
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Street: " + ProjectAddress);
		testlog.info("City: " + ProjectCity);
		testlog.info("Postalcode: " + PostalCode);
		CommonMethod.sendKeys("V2ProjectlocationStreet", ProjectAddress);
		System.out.println("V2ProjectlocationStreet"+CommonMethod.getattributeValue("V2ProjectlocationStreet"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("V2ProjectlocationStreet"));
		CommonMethod.sendKeys("V2ProjectlocationCity", ProjectCity);
		System.out.println("V2ProjectlocationCity"+CommonMethod.getattributeValue("V2ProjectlocationCity"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("V2ProjectlocationCity"));
		CommonMethod.sendKeys("V2ProjectlocationPostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum,
				CommonMethod.getattributeValue("V2ProjectlocationPostalcode"));
		CommonMethod.RobustclickElementVisible("V2ProjectlocationContinuebtn", "V2ProjectareaContinuebtn");
		String Area = CommonMethod.randomNumberBetweenRanges(100, 85000);
		CommonMethod.clearAndSendKey("V2ProjectareaSize", Area);
		data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("V2ProjectareaSize"));
		testlog.info("Area: " + data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectareaContinuebtn", "V2ProjectspacetypeContinuebtn");
		CommonMethod.ClickCheckbox("V2ProjectspaceType");
		CommonMethod.WaitUntilVisibility("V2ProjectspacetypeContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectspacetypeContinuebtn", "V2Projectwellcorecertification");
		if (ProjectType.equalsIgnoreCase("WELLCore")) {
			CommonMethod.WaitUntilVisibility("V2Projectwellcorecertification", 30);
			CommonMethod.click("V2Projectwellcorecertification");
		} else if (ProjectType.equalsIgnoreCase("WELLCertification")) {
			CommonMethod.WaitUntilVisibility("V2ProjectwellCertification", 30);
			CommonMethod.click("V2ProjectwellCertification");
			CommonMethod.WaitUntilVisibility("V2ProjectownershipOflocation", 30);
			CommonMethod.ClickCheckbox("V2ProjectownershipOflocation");
			CommonMethod.click("V2ProjectownershipContinuebtn");
		}
		CommonMethod.WaitUntilVisibility("DatePickerButton", 300);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilVisibility("V2ProjectnextMonthbtn", 120);
		CommonMethod.Robustclick("V2ProjectnextMonthbtn", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilVisibility("V2ProjectselectNextMonth", 120);
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectselectNextMonth");
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 120);
		CommonMethod.Robustclick("DatePickerOkButton", "V2ProjectselectNextMonth");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.WaitUntilClickble("V2ProjectdocsubConfirmbtn", 60);
		CommonMethod.click("V2ProjectdocsubConfirmbtn");
		CommonMethod.click("V2Projectcontinuethejourneybtn");
		CommonMethod.WaitUntilVisibility("EnrollTab", 300);
		CommonMethod.WaitUntilVisibility("StoreId", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getProjectId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void SearchV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.RobustclickElementVisible("WELLCertificationNavBar", "V2ProjectId");
		CommonMethod.WaitUntilClickble("V2ProjectId", 60);
		testlog.info("ProjectId:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("V2ProjectId", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("V2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "Project name doesn't matches in search");
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 300);
		testlog.pass("**Verifies the Search V2Project ByID successfully**");
	}

	public void EnrollV2ProjectById(String SheetName, int rowNum, String ProjectType, String Country)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("EnrollTab", 60);
		CommonMethod.click("EnrollTab");
		rc.SelectOwnerOrg(SheetName, rowNum);
		String Ownername = USfaker.address().firstName();
		String Email = USfaker.internet().emailAddress();
		String Phoneno = USfaker.number().digits(10);
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Ownername: " + Ownername);
		CommonMethod.sendKeys("V2ProjectownerName", Ownername);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("V2ProjectownerName"));
		testlog.info("OwnerEmail: " + Email);
		CommonMethod.sendKeys("V2ProjectownerEmail", Email);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("V2ProjectownerEmail"));
		CommonMethod.sendKeys("V2Projectownerphone", Phoneno);
		data.setCellData(SheetName, "PhoneNum", rowNum, CommonMethod.getattributeValue("V2Projectownerphone"));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.sendKeys("V2Projectorganizationwebsite",
				"https://test-nuxt.wellcertified.com/projects/v2/2202266385/register");
		data.setCellData(SheetName, "Website", rowNum, CommonMethod.getattributeValue("V2Projectorganizationwebsite"));
		CommonMethod.sendKeys("V2ProjectorganizationOverview", Ownername);
		data.setCellData(SheetName, "Overview", rowNum,
				CommonMethod.getattributeValue("V2ProjectorganizationOverview"));
		CommonMethod.ClickCheckbox("V2ProjectconstructionOrrenovation");
		CommonMethod.click("V2ProjectdocsubEstidate");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		CommonMethod.click("V2ProjectdocsubAnticdate");
		CommonMethod.click("V2ProjectdocsubEstidateOkbtn");
		if (ProjectType.equalsIgnoreCase("WELLCore")) {
			CommonMethod.selectdropdownValue("V2ProjectSector", "government/municipal-buildings");
			data.setCellData(SheetName, "MarketSectorName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectSector"));
			testlog.info("MarketSector: " + data.getCellData(SheetName, "MarketSectorName", rowNum));
		}
		CommonMethod.click("V2ProjectprojectOwnerContinuebtn");
		testlog.info("Country: " + Country);
		CommonMethod.selectdropdownValue("V2ProjectprojectaddressCountry", Country);
		data.setCellData(SheetName, "OwnerCountry", rowNum,
				CommonMethod.getSelectedDropdownValue("V2ProjectprojectaddressCountry"));
		CommonMethod.WaitUntilVisibility("V2ProjectprojectState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectprojectState");
		data.setCellData(SheetName, "OwnerState", rowNum,
				CommonMethod.getSelectedDropdownValue("V2ProjectprojectState"));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		testlog.info("Organization Address:" + ProjectAddress1);
		testlog.info("Organization City:" + ProjectCity);
		testlog.info("Organization Postalcode:" + PostalCode);
		CommonMethod.sendKeys("V2ProjectprojectaddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectprojectaddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectprojectaddressPostalcode", PostalCode);
		CommonMethod.selectdropdownValue("V2ProjectowneraddressCountry", Country);
		CommonMethod.WaitUntilVisibility("V2ProjectowneraddressState", 10);
		CommonMethod.selectdropdownrandom("V2ProjectowneraddressState");
		CommonMethod.sendKeys("V2ProjectowneraddressStreet", ProjectAddress1);
		CommonMethod.sendKeys("V2ProjectowneraddressCity", ProjectCity);
		CommonMethod.sendKeys("V2ProjectowneraddressPostalcode", PostalCode);
		data.setCellData(SheetName, "OwnerStreet", rowNum, CommonMethod.getattributeValue("V2ProjectowneraddressStreet"));
		data.setCellData(SheetName, "OwnerCity", rowNum, CommonMethod.getattributeValue("V2ProjectowneraddressCity"));
		data.setCellData(SheetName, "OwnerPostalCode", rowNum,
				CommonMethod.getattributeValue("V2ProjectowneraddressPostalcode"));
		CommonMethod.ClickCheckbox("V2Projectisthisapublicproject");
		CommonMethod.RobustclickElementVisible("V2ProjectprojectaddressContinuebtn", "BiilingTab");
		CommonMethod.WaitUntilVisibility("BiilingTab", 300);
		testlog.pass("**Verifies the Enrolling successfully**");
	}

	public void ClickBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 120);
		CommonMethod.click("BiilingTab");
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton", "BillingLanding");
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void DownloadBillingReceiptAndValidate(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("DownloadReceipt", 120);
		CommonMethod.click("DownloadReceipt");
		File path = new File(downloadPath);
		File[] files = path.listFiles();
		for (File file : files) {
			CommonMethod.VerifyDownloadWithFileName(file.toString());
		}
	}

	public void AgreementV2ProjectById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		CommonMethod.click("WellV2DashboardTab");
		CommonMethod.WaitUntilClickble("V2ProjectSignNow", 60);
		CommonMethod.Robustclick("V2ProjectSignNow");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 30);
		testlog.pass("**Verifies Agreement V2Project successfully**");
	}

	public void CalculatePricingV2Project(String SheetName, int rowNum, String ProjectType)
			throws IOException, InterruptedException {
		long Enroll;
		long Programfee;
		Double Area = Double.valueOf(data.getCellData(SheetName, "Area", rowNum));
		if (ProjectType.equalsIgnoreCase("WellCore")) {
			Enroll = Math.round(2500 - (2500 * .35));
			data.setCellData(SheetName, "EnrollFee", rowNum, String.valueOf(Enroll));
			Double InterimProgramfee = Area * 0.08;
			if (InterimProgramfee <= 6500) {
				Programfee = (6500 - Math.round(6500 * .35));
			} else if (InterimProgramfee >= 98000) {
				Programfee = (98000 - Math.round(98000 * .35));
			} else {
				Programfee = Math.round(InterimProgramfee - (InterimProgramfee * .35));
			}
			data.setCellData(SheetName, "ProgramFee", rowNum, String.valueOf(Programfee));
			long TotalFee = Programfee + Enroll;
			data.setCellData(SheetName, "TotalFee", rowNum, String.valueOf(TotalFee));
		}

		else if (ProjectType.equalsIgnoreCase("WELLCertification")) {
			rowNum = rowNum - 1;
			data.setCellData(SheetName, "NoDiscEnrollFee", rowNum, "2500");
			Double InterimProgramfee = Area * 0.16;
			if (InterimProgramfee <= 6500) {
				Programfee = 6500;
			} else if (InterimProgramfee >= 98000) {
				Programfee = 98000;
			} else {
				Programfee = Math.round(InterimProgramfee);
			}
			data.setCellData(SheetName, "NoDiscProgramFee", rowNum, String.valueOf(Programfee));
			long NoDiscTotalFee = Programfee + 2500;
			data.setCellData(SheetName, "NoDiscTotalFee", rowNum, String.valueOf(NoDiscTotalFee));
		}
	}

	public void PricingSectorDiscountValidationV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PricingTab", 300);
		CommonMethod.RobustclickElementVisible("PricingTab", "V2ProjectPricingLanding");
		CommonMethod.WaitUntilPresence("V2ProjectPricingLanding", 120);
		String PricingEnrollFee = CommonMethod.getText("V2ProjectPricingEnrollFee").replaceAll("USD", "")
				.replaceAll("\\W", "");
		testlog.info("PricingEnrollFee: " + PricingEnrollFee);
		CommonMethod.softAssertEqualsMessage(PricingEnrollFee, data.getCellData(SheetName, "EnrollFee", rowNum),
				"PricingEnrollFee data doesn't match");
		String DiscountName = CommonMethod.getText("V2ProjectPricingSectorDiscountName").split(":")[1].toString()
				.trim();
		testlog.info("Sector DiscountName:" + DiscountName);
		DiscountName = DiscountName.replace("(-35%)", "").trim();
		CommonMethod.softAssertEqualsMessage(DiscountName, data.getCellData(SheetName, "MarketSectorName", rowNum),
				"Pricing Sector DiscountName data doesn't match");
		String ProgramFee = CommonMethod.getText("V2ProjectPricingProgramFee").replaceAll("USD", "").replaceAll("\\W",
				"");
		testlog.info("ProgramFee: " + ProgramFee);
		CommonMethod.softAssertEqualsMessage(ProgramFee, data.getCellData(SheetName, "ProgramFee", rowNum),
				"Pricing ProgramFee data doesn't match");
		String TotalFee = CommonMethod.getText("V2ProjectPricingTotalWellFees").replaceAll("USD", "").replaceAll("\\W",
				"");
		testlog.info("TotalFee: " + TotalFee);
		CommonMethod.softAssertEqualsMessage(TotalFee, data.getCellData(SheetName, "TotalFee", rowNum),
				"Pricing Total WellFees data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Pricing Sector Discount successfully**");
	}

	public void PricingNoDiscountValidationV2Project(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PricingTab", 300);
		CommonMethod.RobustclickElementVisible("PricingTab", "V2ProjectPricingLanding");
		CommonMethod.WaitUntilVisibility("V2ProjectPricingLanding", 120);
		rowNum = rowNum - 1;
		String PricingEnrollFee = CommonMethod.getText("V2ProjectPricingEnrollFee").replaceAll("USD", "")
				.replaceAll("\\W", "");
		testlog.info("PricingEnrollFee: " + PricingEnrollFee);
		CommonMethod.softAssertEqualsMessage(PricingEnrollFee, data.getCellData(SheetName, "NoDiscEnrollFee", rowNum),
				"PricingEnrollFee data doesn't match");
		String ProgramFee = CommonMethod.getText("V2ProjectPricingProgramFee").replaceAll("USD", "").replaceAll("\\W",
				"");
		testlog.info("ProgramFee: " + ProgramFee);
		CommonMethod.softAssertEqualsMessage(ProgramFee, data.getCellData(SheetName, "NoDiscProgramFee", rowNum),
				"Pricing ProgramFee data doesn't match");
		String TotalFee = CommonMethod.getText("V2ProjectPricingNoTotalWellFees").replaceAll("USD", "")
				.replaceAll("\\W", "");
		testlog.info("TotalFee: " + TotalFee);
		CommonMethod.softAssertEqualsMessage(TotalFee, data.getCellData(SheetName, "NoDiscTotalFee", rowNum),
				"Pricing Total WellFees data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies Pricing No Discount successfully**");
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

	public void UploadFeatureDocV2ProjectInsideScorecard(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardFeature", 60);
		CommonMethod.click("V2ProjectScorecardFeature");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2ProjectscorecardDocbtn");
		testlog.info("TaskName : Performance Test OR Sensor Data");
		CommonMethod.selectdropdownVisibletext("V2Projectscorecardverificationdropdown",
				"Performance Test OR Sensor Data");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", FeaturefileUpload);
		CommonMethod.WaitUntilVisibility("UploadFileVerifyScorecard", 120);
		CommonMethod.click("V2Projectscorecarddocuploadsubmit");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies the Upload Document in Scorecard Feature successfully**");

	}

	public void UploadAuditDocV2ProjectInsideScorecard(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("V2ProjectScorecardAuditFeature", 60);
		CommonMethod.click("V2ProjectScorecardAuditFeature");
		CommonMethod.WaitUntilClickble("V2ProjectscorecardDocbtn", 60);
		CommonMethod.click("V2ProjectscorecardDocbtn");
		testlog.info("TaskName : Technical Document (Audited)");
		CommonMethod.selectdropdownVisibletext("V2Projectscorecardverificationdropdown",
				"Technical Document (Audited)");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", AuditfileUpload);
		CommonMethod.WaitUntilVisibility("UploadFileVerifyScorecard", 120);
		CommonMethod.click("V2Projectscorecarddocuploadsubmit");
		CommonMethod.Isdisplayed("V2ProjectscorecardVerifyUploadDoc", 60);
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		testlog.pass("**Verifies the Upload Document in Scorecard Audit Feature successfully**");

	}

	public void UploadLegalAndGeneralDocumentFromDocumentLibrary(String SheetName, int rowNum, String DocumentType,
			String FileName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2ProjectDocumentTab", 60);
		CommonMethod.click("WellV2ProjectDocumentTab");
		CommonMethod.WaitUntilVisibility("V2ProjectDocUploadbtn", 60);
		CommonMethod.click("V2ProjectDocUploadbtn");
		testlog.info("Document Type : General");
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", DocumentType);
		CommonMethod.uploadFile("V2Projectscorecarddocupload", FileName);
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
		CommonMethod.WaitUntilVisibility("V2ProjectDocUploadbtn", 60);
		CommonMethod.click("V2ProjectDocUploadbtn");
		testlog.info("Document Type" + "Ongoing data reports");
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Ongoing data reports");
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectResetbtn");
		Thread.sleep(1000);
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Legal");
		Thread.sleep(1000);
		CommonMethod.click("V2ProjectResetbtn");
		Thread.sleep(2000);
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Ongoing data reports");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		CommonMethod.selectdropdownVisibletext("V2ProjectDocPeriod", "Year 1 reporting");
		CommonMethod.uploadFile("V2Projectscorecarddocupload", OngoingfileUpload);
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
		CommonMethod.WaitUntilVisibility("V2ProjectDocUploadbtn", 60);
		CommonMethod.click("V2ProjectDocUploadbtn");
		Thread.sleep(2000);
		testlog.info("Document Type" + "Feature");
		CommonMethod.selectdropdownVisibletext("V2ProjectPortfolioDocType", "Feature");
		Thread.sleep(2000);
		rc.SelectOwnerOrg(SheetName, rowNum);
		Thread.sleep(2000);
		CommonMethod.click("V2ProjectPart");
		Thread.sleep(1000);
		CommonMethod.Robustclick("V2ProjectSelectPartDoc");
		Thread.sleep(1000);
		CommonMethod.uploadFile("V2Projectscorecarddocupload", FeaturefileUpload);
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
		CommonMethod.selectdropdownVisibletext("V2ProjectSelectPhase", "Preliminary Precertification Review");
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		Thread.sleep(2000);
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.RobustclickElementVisible("AdminWELLCertificationNavBar", "AdminV2ProjectId");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "ProjectID doesn't matches in search");
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
		CommonMethod.click("ReviewTab");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.click("ReviewViewButton");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "V2ProjectReviewCommentNarrative");
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
		CommonMethod.WaitUntilVisibility("V2ProjectHsrContinuebtn", 60);
		CommonMethod.Robustclick("V2ProjectHsrContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 60);
		CommonMethod.click("V2ProjectHsrTermscbx");
		CommonMethod.click("V2ProjectHsrTermsbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 60);
		CommonMethod.click("V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrProceedbtn", 60);
		CommonMethod.Robustclick("V2ProjectHsrProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrAccountbtn", 60);
		CommonMethod.Robustclick("V2ProjectHsrAccountbtn");
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
			CommonMethod.WaitUntilPresence("V2ProjectWPRPDocIcon", 60);
			CommonMethod.click("V2ProjectWPRPDocIcon");
			CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 60);
			CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
			CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload);
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
		CommonMethod.selectdropdownVisibletext("V2ProjectSelectPhase", "Final Documentation Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingHsrcbx");
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectHSRReviewViewbtn", 120);
		testlog.pass("**Reviewed Final Precertification Review successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilClickble("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "Project ID doesn't matches");
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.click("ReviewTab");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectHSRReviewViewbtn", 120);
		CommonMethod.click("V2ProjectHSRReviewViewbtn");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReturnComment");
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
		CommonMethod.WaitUntilVisibility("V2ProjectWPRContinuebtn", 60);
		CommonMethod.Robustclick("V2ProjectWPRContinuebtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRTermscbx", 60);
		CommonMethod.ClickCheckbox("V2ProjectWPRTermscbx");
		CommonMethod.click("V2ProjectWPRTermsbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectHsrTermscbx", 60);
		CommonMethod.ClickCheckbox("V2ProjectHsrTermscbx");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRProceedbtn", 60);
		CommonMethod.Robustclick("V2ProjectWPRProceedbtn");
		CommonMethod.WaitUntilVisibility("V2ProjectWPRAccountbtn", 60);
		CommonMethod.Robustclick("V2ProjectWPRAccountbtn");
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
		CommonMethod.selectdropdownVisibletext("V2ProjectSelectPhase", "Final Performance Review");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingHsrcbx");
		CommonMethod.ClickCheckbox("V2ProjectsubmittingWprcbx");
		CommonMethod.click("V2ProjectSubmitPhaseReview");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectWPRReviewViewbtn", 30);
		testlog.pass("**Reviewed Final Precertification Review successfully**");

		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 300);
		CommonMethod.click("AdminNavBar");
		CommonMethod.click("AdminWELLCertificationNavBar");
		CommonMethod.WaitUntilVisibility("AdminV2ProjectId", 300)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("AdminV2ProjectApplybtn");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "ProjectID", rowNum), "Project name doesn't matches in search");
		CommonMethod.click("V2ProjectIdCompare");
		CommonMethod.click("ReviewTab");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("V2ProjectWPRReviewViewbtn", 30);
		CommonMethod.click("V2ProjectWPRReviewViewbtn");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 30);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReturnComment");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Final Review");
		CommonMethod.WaitUntilClickble("V2ProjectReviewCommentNarrative", 60).sendKeys("Final Precertification Review");
		CommonMethod.WaitUntilVisibility("DatePickerButton", 300);
		Thread.sleep(1000);
		CommonMethod.click("DatePickerButton");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
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
		String TeamEmail = "gokulthiru22@gmail.com";
		CommonMethod.sendKeys("V2ProjectEmailAddress", TeamEmail);
		data.setCellData(SheetName, "TeamEmailID", rowNum, TeamEmail);
		CommonMethod.selectdropdownVisibletext("V2ProjectRole", "Acoustician");
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

	public void supportV2Project(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectSupportButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSupportButton", "V2ProjectGetHelpButton");
		CommonMethod.WaitUntilVisibility("V2ProjectGetHelpButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectGetHelpButton", "V2ProjectQuestionAboutDropdown");
		CommonMethod.WaitUntilVisibility("V2ProjectQuestionAboutDropdown", 60);
		CommonMethod.selectdropdownValue("V2ProjectQuestionAboutDropdown", "well-v2-feature");
		CommonMethod.WaitUntilVisibility("V2ProjectIssueSubTypeDropdown", 60);
		CommonMethod.selectdropdownValue("V2ProjectIssueSubTypeDropdown", "A01 Air Quality");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		CommonMethod.WaitUntilClickble("V2ProjectSubjectInputField", 60).sendKeys("Testing");
		data.setCellData(SheetName, "Subject", rowNum, CommonMethod.getattributeValue("V2ProjectSubjectInputField"));
		testlog.info("FeatureName" + data.getCellData(SheetName, "Subject", rowNum));
		CommonMethod.WaitUntilClickble("V2ProjectDescriptionTextArea", 60).sendKeys("Testing");
		CommonMethod.uploadFile("DocumentsUpload", FeaturefileUpload);
		CommonMethod.WaitUntilVisibility("V2ProjectUploadFeatureVerify", 120);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectNewStatus");
		CommonMethod.WaitUntilVisibility("V2ProjectNewStatus", 60);
		CommonMethod.assertcontainsmessage("V2ProjectNewStatus", "New", "Verified New status");
		testlog.pass("**Raised support ticket successfully**");
	}

	public void alternativesV2Project(String SheetName, int rowNum, String alternativeOption)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("V2ProjectAlternativesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAlternativesButton", "V2ProjectEPSubmitButton");
		if (alternativeOption.equalsIgnoreCase("EP")) {
			CommonMethod.RobustclickElementVisible("V2ProjectEPSubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownVisibletext("V2ProjectFeatureDropdown", "A01 Air Quality");
			CommonMethod.WaitUntilVisibility("V2ProjectApplicablePartCheckBox", 60);
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyReason", 60).sendKeys("Reason for Equivalency Request");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyCountriesInput", 60)
					.sendKeys("Regions/Countries where Equivalency may be Applicable");
			CommonMethod.WaitUntilClickble("V2ProjectVerificationTextArea", 60)
					.sendKeys("Verification method within proposed equivalent");
			CommonMethod.WaitUntilClickble("V2ProjectSimilaritiesTextArea", 60)
					.sendKeys("Similarities to WELL feature requirement");
			CommonMethod.WaitUntilClickble("V2ProjectDifferencesTextArea", 60)
					.sendKeys("Differences from WELL feature requirement");
		} else if (alternativeOption.equalsIgnoreCase("AAP")) {
			CommonMethod.scrolldowntoElement("V2ProjectAditionalButton");
			CommonMethod.WaitUntilVisibility("V2ProjectAapSubmitButton", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectAapSubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownVisibletext("V2ProjectFeatureDropdown", "A01 Air Quality");
			data.setCellData(SheetName, "FeatureName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
			testlog.info("FeatureName" + data.getCellData(SheetName, "FeatureName", rowNum));
			CommonMethod.WaitUntilVisibility("V2ProjectApplicablePartCheckBox", 60);
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			CommonMethod.WaitUntilClickble("V2ProjectAlternativesReasonTextArea", 60)
					.sendKeys("Reason for Alternative Means and Methods");
		}
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesProposedTextArea", 60)
				.sendKeys("Proposed Alternative Means of Compliance");
		CommonMethod.uploadFile("DocumentsUpload", PortfolioLocationImportfile);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2projectEPTypeStatus");
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

	public void editAndValidateProjectInformationV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectNameInput", 60);
		CommonMethod.clearAndSendKey("V2ProjectProjectNameInput", data.getCellData(SheetName, "ProjectName", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectProjectScope", 60);
		CommonMethod.sendKeys("V2ProjectProjectScope", data.getCellData(SheetName, "ProjectScope", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.sendKeys("V2ProjectProjectGoals", data.getCellData(SheetName, "ProjectGoals", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectSuccessToastMessage");
		testlog.info("**Project Information data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
//		CommonMethod.WaitUntilVisibility("V2ProjectWellCertifiedLogo", 60);
		/*
		 * Validate updated project information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectScope"),
				data.getCellData(SheetName, "ProjectScope", rowNum), "Project scope data doesn't match");
		testlog.info("**Project scope data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectGoals"),
				data.getCellData(SheetName, "ProjectGoals", rowNum), "Project goals data doesn't match");
		softAssert.assertAll();
		testlog.pass("**Project goals data updated successfully**");
	}

	public void editAndValidateOwnerInformationV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectOwnerInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectOwnerInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectOwnerInformationButton", "V2ProjectOrganizationIndustry");
		CommonMethod.WaitUntilVisibility("V2ProjectOrganizationIndustry", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectOrganizationIndustry",
				data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectCountry", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectCountry", data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectState", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectState", data.getCellData(SheetName, "State", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectSuccessToastMessage");
		testlog.info("**Owner Information data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
//		CommonMethod.WaitUntilVisibility("V2ProjectWellCertifiedLogo", 60);
		/*
		 * Validate updated owner information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectOwnerInformationButton");
		CommonMethod.WaitUntilVisibility("V2ProjectOwnerInformationButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectOwnerInformationButton", "V2ProjectOrganizationIndustry");
		CommonMethod.WaitUntilVisibility("V2ProjectCountry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("V2ProjectCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country name doesn't match");
		testlog.info("**Country name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectState", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectState"),
				data.getCellData(SheetName, "State", rowNum), "State name doesn't match");
		softAssert.assertAll();
		testlog.pass("**State name updated successfully**");
	}

	public void editAndValidateAddressV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAddressButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAddressButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAddressButton", "V2ProjectBillingName");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingName", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingName", data.getCellData(SheetName, "BillingName", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingOrganization", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingOrganization",
				data.getCellData(SheetName, "BillingOrganization", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCountry", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectBillingCountry",
				data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingStreetAddress", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingStreetAddress", data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCity", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingCity", data.getCellData(SheetName, "City", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectBillingPostalCode", 60);
		CommonMethod.clearAndSendKey("V2ProjectBillingPostalCode", data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectSuccessToastMessage");
		testlog.pass("**Address data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
//		CommonMethod.WaitUntilVisibility("V2ProjectWellCertifiedLogo", 60);
		/*
		 * Validate updated address fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAddressButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAddressButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAddressButton", "V2ProjectBillingName");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingName", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingName"),
				data.getCellData(SheetName, "BillingName", rowNum), "Billing name doesn't match");
		testlog.info("**Billing name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingOrganization", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingOrganization"),
				data.getCellData(SheetName, "BillingOrganization", rowNum), "Billing organization name doesn't match");
		testlog.info("**Billing organization name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCountry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("V2ProjectBillingCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Billing country name doesn't match");
		testlog.info("**Country name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingStreetAddress", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingStreetAddress"),
				data.getCellData(SheetName, "Street", rowNum), "Billing street name doesn't match");
		testlog.info("**Street address name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingCity", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingCity"),
				data.getCellData(SheetName, "City", rowNum), "Billing city name doesn't match");
		testlog.pass("**City name updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectBillingPostalCode", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectBillingPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Billing postal code doesn't match");
		softAssert.assertAll();
		testlog.pass("**Postal code updated successfully**");
	}

	public void editAndValidateAdminV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "V2projectAdminBillingStatus");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingStatus", 60);
		CommonMethod.sendKeys("V2projectAdminBillingStatus", data.getCellData(SheetName, "BillingStatus", rowNum));
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingChallengeNote", 60);
		CommonMethod.sendKeys("V2projectAdminBillingChallengeNote",
				data.getCellData(SheetName, "ChallengeNote", rowNum));
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingCommunicationNote", 60);
		CommonMethod.sendKeys("V2projectAdminBillingCommunicationNote",
				data.getCellData(SheetName, "CommunicationNote", rowNum));
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingNote", 60);
		CommonMethod.sendKeys("V2projectAdminBillingNote", data.getCellData(SheetName, "BillingNote", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "V2ProjectSuccessToastMessage");
		testlog.pass("**Admin data updated successfully**");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
//		CommonMethod.WaitUntilVisibility("V2ProjectWellCertifiedLogo", 60);
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "V2projectAdminBillingStatus");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingStatus", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingStatus"),
				data.getCellData(SheetName, "BillingStatus", rowNum), "Billing status value doesn't match");
		testlog.pass("**Billing status updated successfully**");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingChallengeNote", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingChallengeNote"),
				data.getCellData(SheetName, "ChallengeNote", rowNum), "Challenge note value doesn't match");
		testlog.pass("**Challenge note updated successfully**");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingCommunicationNote", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingCommunicationNote"),
				data.getCellData(SheetName, "CommunicationNote", rowNum), "Communication note value doesn't match");
		testlog.pass("**Communication updated successfully**");
		CommonMethod.WaitUntilVisibility("V2projectAdminBillingNote", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2projectAdminBillingNote"),
				data.getCellData(SheetName, "BillingNote", rowNum), "Billing note value doesn't match");
		softAssert.assertAll();
		testlog.pass("**Billing note updated successfully**");
	}

	public void overviewV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("OverviewTab", 60);
		CommonMethod.RobustclickElementVisible("OverviewTab", "V2ProjectProjectID");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectID", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectID"),
				data.getCellData(SheetName, "ProjectID", rowNum), "Product id value doesn't match");	
		CommonMethod.WaitUntilVisibility("V2ProjectProjectName", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectName"),
				data.getCellData(SheetName, "ProjectName", rowNum), "Product name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectArea", 60);
		String getArea =  CommonMethod.getText("V2ProjectProjectArea").replace("sq ft", "").replace(",", "").trim();
		CommonMethod.softAssertEqualsMessage(getArea,
				data.getCellData(SheetName, "Area", rowNum), "Project area value doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectStreet", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Street name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectCity", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectCity"),
				data.getCellData(SheetName, "City", rowNum), "City name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectState", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectState"),
				data.getCellData(SheetName, "State", rowNum), "State name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectCountry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country name doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectOwnerIndustry", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectOwnerIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Owner industry name doesn't match");
		softAssert.assertAll();
		testlog.pass("**Project id matched successfully**");
		testlog.pass("**State name matched successfully**");
		testlog.pass("**Street name matched successfully**");
		testlog.pass("**Product area matched successfully**");
		testlog.pass("**ProjectName matched successfully**");
		testlog.pass("**City name matched successfully**");
		testlog.pass("**Country name matched successfully**");
		testlog.pass("**Owner industry name matched successfully**");
		testlog.pass("**verifies overview fields successfully**");
	}

	public void profileV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("ProfileTab", 60);
		CommonMethod.RobustclickElementVisible("ProfileTab", "V2ProjectGeneralInformation");
		CommonMethod.WaitUntilVisibility("V2ProjectGeneralInformation", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectBio", 60);
		CommonMethod.clearAndSendKey("V2ProjectProjectBio", "Project bio testing");
		CommonMethod.uploadFile("V2ProjectLogo", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectFeviconLogo", 60);
		CommonMethod.uploadFile("V2ProjectLogo", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectPrimaryProfileImageDeleteVerify", 120);
		CommonMethod.uploadFile("V2ProjectProfileImage", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectFeviconLogo", 60);
		CommonMethod.WaitUntilVisibility("V2ProjectPrimaryProfileImageDeleteVerify", 120);
		CommonMethod.WaitUntilVisibility("V2ProjectProfileImageDeleteVerify", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectGeneralInformation");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		testlog.pass("**General Information data updated successfully**");
		CommonMethod.WaitUntilInVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		/*
		 * V2ProjectCertificationStory
		 */
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("V2ProjectCertificationStory", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectCertificationStory", "V2ProjectProjectBio");
		CommonMethod.WaitUntilVisibility("V2ProjectYourObjective", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourObjective", "Your objective testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourOrganization", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourOrganization", "Your organization testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellGoals", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellGoals", "Your well goals testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellProject", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellProject", "Your well project testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellFeatures", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellFeatures", "Your well features testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourWellCertification", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourWellCertification", "Your well certification testing");
		CommonMethod.WaitUntilVisibility("V2ProjectPostCertificationMetric", 60);
		CommonMethod.clearAndSendKey("V2ProjectPostCertificationMetric", "Post certification metric testing");
		CommonMethod.WaitUntilVisibility("V2ProjectYourCompanyCulture", 60);
		CommonMethod.clearAndSendKey("V2ProjectYourCompanyCulture", "Your company culture testing");
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		softAssert.assertAll();
		testlog.pass("**Certification story data updated successfully**");
	}

	public void promotionCardValidationV2Project(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("PromotionTab", 60);
		CommonMethod.RobustclickElementVisible("PromotionTab", "V2ProjectCardContainer");
		int countCard = CommonMethod.ElementSize("V2ProjectCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, "2");
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");

	}
}