package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsCustomPortfolio extends BaseClass {

	public void RegisterPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar","PortfolioCreateAccountButton");
		CommonMethod.WaitUntilVisibility("PortfolioCreateAccountButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountButton","PortfolioAccountName");
		String AccountName = "Automation portfolio " + CommonMethod.randomNumber(8000000);
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 30);
		CommonMethod.sendKeys("PortfolioAccountName", AccountName);
		data.setCellData(SheetName, "AccountName", rowNum, AccountName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		testlog.info("OrgIndustry: " +data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.ClickCheckbox("PortfolioNotSureRadio");
		CommonMethod.sendKeys("PortfolioNumberOfLocation", "15");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("PortfolioNumberOfLocation"));
		testlog.info("PortfolioNumberOfLocation: "+data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.sendKeys("PortfolioEstimatedNumberOfLocation", "10");
		data.setCellData(SheetName, "EstimatedNumberOfLocation", rowNum, CommonMethod.getattributeValue("PortfolioEstimatedNumberOfLocation"));
		testlog.info("EstimatedNumberOfLocation: "+data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100,50000);
		CommonMethod.sendKeys("PortfolioGrossAreaSQFT", Area);
		data.setCellData(SheetName, "AreaSQFT", rowNum, CommonMethod.getattributeValue("PortfolioGrossAreaSQFT"));
		testlog.info("PortfolioGrossAreaSQFT: "+data.getCellData(SheetName, "AreaSQFT", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioPrimarlyLocated");
		CommonMethod.click("PortfolioPrimarlyLocated");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.click("PortfolioSpaceType");
		CommonMethod.click("PortfolioSelectSpaceType");
		CommonMethod.selectdropdownValue("PortfolioOwnerCountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerCountry"));
		testlog.info("PortfolioOwnerCountry: " +data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioOwnerState", 10);
		CommonMethod.selectdropdownrandom("PortfolioOwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerState"));
		testlog.info("PortfolioOwnerCountry: " +data.getCellData(SheetName, "State", rowNum));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("PortfolioOwnerStreetAddress", ProjectAddress1);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("PortfolioOwnerStreetAddress"));
		testlog.info("PortfolioOwnerStreetAddress: "+data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("PortfolioOwnerCity"));
		testlog.info("PortfolioOwnerCity: "+data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPostalCode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountSubmit", "WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getProjectId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
		testlog.pass("**Verifies the Registration successful**");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void SearchPortfolioByName(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("Portfolio Name:" +data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" +data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.click("PortfolioSearchApplyFilter");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("PortfolioIDVerify", data.getCellData(SheetName, "ProjectID", rowNum),
			"Portfolio ID doesn't matched with exceles in search");
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Search Portfolio Name successfully**");
	}

	public void SignAgreementPortfolio() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("PortfolioClickSignNow", 60);
		CommonMethod.Robustclick("PortfolioClickSignNow");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Portfolio Sign Agreement successfully**");
	}

	public void SubscribePortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("SubscribeTab", 30);
		CommonMethod.Robustclick("SubscribeTab","PortfolioOwnerName");
		CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		String OwnerName = USfaker.address().firstName();
		String OwnerEmail = USfaker.internet().emailAddress();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("PortfolioOwnerName"));
		testlog.info("OwnerName: "+data.getCellData(SheetName, "OwnerName", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("PortfolioOwnerEmail"));
		testlog.info("OwnerEmail: "+data.getCellData(SheetName, "OwnerEmail", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		data.setCellData(SheetName, "OwnerPhone", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPhone"));
		testlog.info("OwnerPhone: "+data.getCellData(SheetName, "OwnerPhone", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton","PortfolioSubcribeContinueButton2");
		CommonMethod.ClickCheckbox("PortfolioQuestionRadio");
		CommonMethod.WaitUntilVisibility("PortfolioLocationDescriptionTextbox", 20);
		CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: "+data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton2","PortfolioSubscribeDone");
		CommonMethod.RobustclickElementVisible("PortfolioSubscribeDone","PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		CommonMethod.Robustclick("PortfolioGoToBilling");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.navigateBack();
		testlog.pass("**Verifies Subscribe Portfolio successfully**");
	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.RobustclickElementVisible("BiilingTab","V2ProjectPreBillingPayNowButton");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton","BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("WellV2Tab", 120);
		CommonMethod.RobustclickElementVisible("WellV2Tab","ScorecardTab");
		CommonMethod.click("ScorecardTab");
		if (CommonMethod.isElementsExist("PortfolioScorecardFinishedButton", 30)) {
			Thread.sleep(2000);
			CommonMethod.click("PortfolioScorecardFinishedButton");
			Thread.sleep(2000);
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPopupButton", 30);
			CommonMethod.click("PortfolioScorecardPopupButton");
		}
		CommonMethod.WaitUntilVisibility("PortFolioScoreCardPageLand", 300);
		testlog.pass("**Verfies Scorecard Page successfully**");
	}

	public void MeetThresholdsforParticulateMatter(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.clickListWebelementFromIndex("PortfolioScorecardPursueYesButton", 0);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardWeightPHighlighted", 1);
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 1);
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 1);
			    
				CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 0);
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
						"PortfolioScoreCardVerificationAssignLocCancelbtn");
				Thread.sleep(2000);
				CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationUploadbtn", 60);
				Thread.sleep(20000);
				CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
						"PortfolioScoreCardVerificationAddNote");
				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
				}
				List<String> val = CommonMethod.fetchTableData("PortfolioScorecardDocumentUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.assertcontainsmessage(val.get(0), "Ready For Review", "Document table data mismatch");
				testlog.info("Review Status is correct in Table in UplaodTab");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);

			}
		}
	}
	
	public void MeetThresholdsforOrganicGases(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				/*
				 * ScoreCard Add option
				 */
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardRemoveButton", 2);
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 2);
				/*
				 * AssignButton
				 */
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
							"PortfolioScorecardValidDisable");
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignLocSavebtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocSavebtn",
							"PortfolioScoreCardVerificationAssignLocCancelbtn");
				}
				Thread.sleep(2000);
				CommonMethod.WaitUntilPresence("PortfolioScorecardOptionPurseLocation", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionPurseLocation", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskPurseLocation", 2);
				CommonMethod.scrollDown();
				/*
				 * UploadTask
				 */
				List<WebElement> UploadTaskbtn;
				UploadTaskbtn = CommonMethod.findElements("PortfolioScoreCardVerificationUploadbtn");
				for (WebElement f : UploadTaskbtn) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					/*
					 * Uploading Document for Feature
					 * Valid FeatureName, DocumentType and VerificationMethod
					 */
					CommonMethod.assertActualContainsExpected(CommonMethod.getattributeValue("PortfolioScorecardUploadFeatureName"), "Meet Thresholds for Organic Gases");
					CommonMethod.assertActualContainsExpected(CommonMethod.getattributeValue("PortfolioScorecardDocumentType"), "Feature verification");
					CommonMethod.assertActualContainsExpected(CommonMethod.getattributeValue("PortfolioScoreVerifyUploadVerificationMethod"), "Performance Test");
					
					CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadAddfeature",
							"PortfolioScoreCardVerificationSelectFeature");
					String VerificationMethod = CommonMethod.getattributeValue("PortfolioScoreVerifyUploadVerificationMethod");
					/*
					 * Adding part A05.2
					 */
					if (VerificationMethod.equalsIgnoreCase("Performance Test")) {
						CommonMethod.selectdropdownValue("PortfolioScoreCardVerificationSelectFeature", "A05.2");
						CommonMethod.Robustclick("PortfolioScoreCardVerificationAddPart");
				}
					/*
					 * Adding part
					 */
					else if(VerificationMethod.equalsIgnoreCase("Sensor Data")) {
						CommonMethod.selectdropdownIndex("PortfolioScoreCardVerificationSelectFeature", 1);
						CommonMethod.Robustclick("PortfolioScoreCardVerificationAddPart");
					}
					/*
					 * Valid Added part remove link
					 */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 60);
					CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationUploadDocbtn", 30);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
							"PortfolioScoreCardVerificationAddNote");
					if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
						CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
					}
				}
				
				
			}
	}
}
}