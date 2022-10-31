package com.Well.ReusableMethods;

import java.io.IOException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodCommon extends BaseClass {
	
	public void SignOut() throws InterruptedException, IOException {

		if(Environment.equalsIgnoreCase("Test")) {
		driver.get("https://test-nuxt.wellcertified.com/logout");
		}
		else {
	    driver.get("https://stg-nuxt.wellcertified.com/logout");
		}
		CommonMethod.WaitUntilPresence("Username", 10);
	}
	
	public void SelectCountryAndState(String Country,String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.selectdropdownValue("ProjectlocationCountry", Country);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("ProjectlocationCountry"));
		CommonMethod.selectdropdownrandom("ProjectlocationState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("ProjectlocationState"));
		testlog.info("Country: " + data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
	}
	
	public void SelectOwnerOrg(String SheetName,int rowNum) throws IOException, InterruptedException {
	CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
	CommonMethod.click("OwnerOrgClick");
	CommonMethod.sendKeys("OwnerOrg", "R");
	CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
	CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
	data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
	testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
	
	}
	public void Billing(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BillingLanding", 300);
		CommonMethod.scrolldowntoElement("CardHolderName");
		CommonMethod.WaitUntilClickble("CardHolderName", 60);
		testlog.info("firstName:" + USfaker.address().firstName());
		CommonMethod.sendKeys("CardHolderName", USfaker.address().firstName());
		data.setCellData(SheetName, "CardHolderName", rowNum, CommonMethod.getattributeValue("CardHolderName"));
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardNumberIframe");
		CommonMethod.WaitUntilClickble("CardHolderNumber", 60);
		Thread.sleep(2000);
		testlog.info("CardHolderNumber:" + "4111111111111111");
		CommonMethod.sendKeys("CardHolderNumber", data.getCellData(SheetName, "CardNumber", rowNum));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardExpDateIframe");
		testlog.info("CardHolderExpDate:" + "0925");
		CommonMethod.WaitUntilClickble("CardHolderExpDate", 60).sendKeys("0");
		CommonMethod.sendKeys("CardHolderExpDate", "9");
		CommonMethod.sendKeys("CardHolderExpDate", "2");
		CommonMethod.sendKeys("CardHolderExpDate", "5");
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardCVVIframe");
		CommonMethod.WaitUntilClickble("CardHolderCVC", 60);
		testlog.info("CardHolderCVC:" + "999");
		CommonMethod.sendKeys("CardHolderCVC", data.getCellData(SheetName, "CardCVC", rowNum));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("PayNowButton", 10);
		CommonMethod.click("PayNowButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilInVisibility("CardHolderName", 180);
		testlog.pass("**Verifies the Completed Card Payment Billing successfully**");
	}
	
	public void LocationImport(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("LocationsTab", 60);
		CommonMethod.click("LocationsTab");
		CommonMethod.WaitUntilVisibility("PortfolioLocationLanding", 60);
		CommonMethod.RobustclickElementVisible("PortfolioLocationsImportButton","PortfolioUploadFileNextButton");
		CommonMethod.scrolldowntoElement("PortfolioUploadLocationButton");
		CommonMethod.uploadFile("PortfolioUploadLocationButton", PortfolioLocationImportfile);
		CommonMethod.click("PortfolioUploadFileNextButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("PortfolioUploadFileNextButton", 30);
		if (CommonMethod.isElementsExist("PortfolioUnmatchFieldcbx", 3)) {
			CommonMethod.WaitUntilVisibility("PortfolioUnmatchFieldcbx", 30);
			CommonMethod.ClickCheckbox("PortfolioUnmatchFieldcbx");
		}
		CommonMethod.WaitUntilVisibility("PortfolioUploadFileNextButton", 30);
		CommonMethod.click("PortfolioUploadFileNextButton");
		CommonMethod.WaitUntilVisibility("PortfolioFinishImportButton", 30);
		CommonMethod.click("PortfolioFinishImportButton");
		CommonMethod.WaitUntilVisibility("PortfolioImportCloseButton", 30);
		CommonMethod.click("PortfolioImportCloseButton");
		CommonMethod.WaitUntilVisibility("PortfolioLocationLanding", 60);
		testlog.pass("**Imported Locations successfully**");
	}
	
	public void clickOnAlternatives(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AlternativesTab", 300);
		CommonMethod.RobustclickElementVisible("AlternativesTab", "V2ProjectEPSubmitButton");
		CommonMethod.RobustclickElementVisible("V2ProjectEPSubmitButton", "V2ProjectFeatureDropdown");
}

	public void alternatives(String SheetName, int rowNum, String alternativeOption)
			throws IOException, InterruptedException {
		if (alternativeOption.equalsIgnoreCase("EP")) {
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownrandom("V2ProjectFeatureDropdown");
			data.setCellData(SheetName, "EPFeatureName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
			testlog.info("EPFeatureName: " + data.getCellData(SheetName, "EPFeatureName", rowNum));
			if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
				CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			}
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyReason", 60).sendKeys("Reason for Equivalency Request");
			CommonMethod.WaitUntilClickble("V2ProjectEquivalencyCountriesInput", 60)
					.sendKeys("Regions/Countries where Equivalency may be Applicable");
			if (CommonMethod.isElementsExist("V2ProjectVerificationTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("V2ProjectVerificationTextArea", 60);
				CommonMethod.clearAndSendKey("V2ProjectVerificationTextArea",
						"Verification method within proposed equivalent");
			} else if (CommonMethod.isElementsExist("PortfolioVerificationTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("PortfolioVerificationTextArea", 60);
				CommonMethod.clearAndSendKey("PortfolioVerificationTextArea",
						"Verification method within proposed equivalent");
			}
			if (CommonMethod.isElementsExist("V2ProjectSimilaritiesTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("V2ProjectSimilaritiesTextArea", 60);
				CommonMethod.clearAndSendKey("V2ProjectSimilaritiesTextArea",
						"Similarities to WELL feature requirement");
			} else if (CommonMethod.isElementsExist("PortfolioSimilaritiesTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("PortfolioSimilaritiesTextArea", 60);
				CommonMethod.clearAndSendKey("PortfolioSimilaritiesTextArea",
						"Similarities to WELL feature requirement");
			}
			if (CommonMethod.isElementsExist("V2ProjectDifferencesTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("V2ProjectDifferencesTextArea", 60);
				CommonMethod.clearAndSendKey("V2ProjectDifferencesTextArea",
						"Differences from WELL feature requirement");
			} else if (CommonMethod.isElementsExist("PortfolioDifferencesTextArea", 10)) {
				CommonMethod.WaitUntilVisibility("PortfolioDifferencesTextArea", 60);
				CommonMethod.clearAndSendKey("PortfolioDifferencesTextArea",
						"Differences from WELL feature requirement");
			}
		} else if (alternativeOption.equalsIgnoreCase("AAP")) {
			CommonMethod.refreshBrowser();
			CommonMethod.WaitUntilVisibility("V2ProjectAapSubmitButton", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectAapSubmitButton", "V2ProjectFeatureDropdown");
			CommonMethod.WaitUntilVisibility("V2ProjectFeatureDropdown", 60);
			CommonMethod.selectdropdownrandom("V2ProjectFeatureDropdown");
			data.setCellData(SheetName, "AAPFeatureName", rowNum,
					CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
			testlog.info("AAPFeatureName: " + data.getCellData(SheetName, "AAPFeatureName", rowNum));
			if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
				CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			}
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

	public void team(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TeamTab", 300);
		CommonMethod.click("TeamTab");
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 30);
		CommonMethod.click("V2ProjectAddMemberbtn");
		String TeamEmail = "gokulthiru22@gmail.com";
		CommonMethod.WaitUntilVisibility("V2ProjectEmailAddress", 30);
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
	
	public void editAndValidateOrganizationInformation(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectNameInput");
		if (CommonMethod.isElementsExist("V2ProjectProjectInformationButton", 10)) {
//			CommonMethod.WaitUntilVisibility("V2ProjectProjectInformationButton", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
//			CommonMethod.WaitUntilVisibility("V2ProjectProjectNameInput", 60);
			CommonMethod.clearAndSendKey("V2ProjectProjectNameInput",
					data.getCellData(SheetName, "ProjectName", rowNum));
		} else if (CommonMethod.isElementsExist("HSROrganizationInformationButton", 10)) {
//			CommonMethod.WaitUntilVisibility("HSROrganizationInformationButton", 60);
			CommonMethod.RobustclickElementVisible("HSROrganizationInformationButton", "V2ProjectProjectScope");
//			CommonMethod.WaitUntilVisibility("V2ProjectProjectNameInput", 60);
			CommonMethod.clearAndSendKey("V2ProjectProjectNameInput", data.getCellData(SheetName, "HsrName", rowNum));
		}

//		CommonMethod.WaitUntilVisibility("V2ProjectProjectScope", 60);
		CommonMethod.sendKeys("V2ProjectProjectScope", data.getCellData(SheetName, "ProjectScope", rowNum));
//		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.sendKeys("V2ProjectProjectGoals", data.getCellData(SheetName, "ProjectGoals", rowNum));
//		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WPRHsrPortfolioDashboard");
		testlog.info("**Project Information data updated successfully**");
		/*
		 * Validate updated project information fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectInformationButton");
		if (CommonMethod.isElementsExist("V2ProjectProjectInformationButton", 10)) {
//			CommonMethod.WaitUntilVisibility("V2ProjectProjectInformationButton", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
		} else if (CommonMethod.isElementsExist("HSROrganizationInformationButton", 10)) {
//			CommonMethod.WaitUntilVisibility("HSROrganizationInformationButton", 60);
			CommonMethod.RobustclickElementVisible("HSROrganizationInformationButton", "V2ProjectProjectScope");
		}
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectScope"),
				data.getCellData(SheetName, "ProjectScope", rowNum), "Project scope data doesn't match");
		testlog.info("**Project scope data updated successfully**");
//		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("V2ProjectProjectGoals"),
				data.getCellData(SheetName, "ProjectGoals", rowNum), "Project goals data doesn't match");
		testlog.pass("**Project goals data updated successfully**");
	}

	public void editAndValidateAdmin(String SheetName, int rowNum) throws Exception {

		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "CoachingContactsDropDown");
		CommonMethod.WaitUntilVisibility("CoachingContactsDropDown", 60);
		CommonMethod.selectdropdownrandom("CoachingContactsDropDown");
		data.setCellData(SheetName, "CoachingContacts", rowNum,
				CommonMethod.getSelectedDropdownValue("CoachingContactsDropDown"));
		testlog.info("Coaching Contacts: " + data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.WaitUntilVisibility("RelationshipManagerDropDown", 60);
		CommonMethod.selectdropdownrandom("RelationshipManagerDropDown");
		data.setCellData(SheetName, "RelationshipManager", rowNum,
				CommonMethod.getSelectedDropdownValue("RelationshipManagerDropDown"));
		testlog.info("Relationship Manager: " + data.getCellData(SheetName, "RelationshipManager", rowNum));
		CommonMethod.WaitUntilVisibility("WellReviewerDropDown", 60);
		CommonMethod.selectdropdownrandom("WellReviewerDropDown");
		data.setCellData(SheetName, "WellReviewer", rowNum,
				CommonMethod.getSelectedDropdownValue("WellReviewerDropDown"));
		testlog.info("Well Reviewer: " + data.getCellData(SheetName, "WellReviewer", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectSaveChangesButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WPRHsrPortfolioDashboard");
		testlog.pass("**Admin data updated successfully**");
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilVisibility("V2ProjectAdminFieldsButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "CoachingContactsDropDown");
		CommonMethod.WaitUntilVisibility("CoachingContactsDropDown", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("CoachingContactsDropDown"),
				data.getCellData(SheetName, "CoachingContacts", rowNum), "Coaching contacts value doesn't match");
		testlog.pass("**Coaching contacts updated successfully**");
		CommonMethod.WaitUntilVisibility("RelationshipManagerDropDown", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("RelationshipManagerDropDown"),
				data.getCellData(SheetName, "RelationshipManager", rowNum), "Relationship Manager value doesn't match");
		testlog.pass("**Relationship Manager value updated successfully**");
		CommonMethod.WaitUntilVisibility("WellReviewerDropDown", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("WellReviewerDropDown"),
				data.getCellData(SheetName, "WellReviewer", rowNum), "Well Reviewer value doesn't match");
		testlog.pass("**Well Reviewer value updated successfully**");
	}

	public void promotionCardValidation(String SheetName, int rowNum, String cardValue) throws Exception {
		CommonMethod.WaitUntilVisibility("PromotionTab", 60);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.assertActualContainsExpected(cardCount, cardValue);
		testlog.info("Card count: " + cardCount);
		testlog.pass("**Verify card count successfully**");

	}

	public void profile(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("ProfileTab", 60);
		CommonMethod.RobustclickElementVisible("ProfileTab", "V2ProjectGeneralInformation");
		CommonMethod.WaitUntilVisibility("V2ProjectGeneralInformation", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectBio", 60);
		CommonMethod.clearAndSendKey("V2ProjectProjectBio", "Project bio testing");
		CommonMethod.uploadFile("V2ProjectLogo", SampleJpgfile);
		CommonMethod.uploadFile("V2ProjectProfileImage", SampleJpgfile);
		CommonMethod.WaitUntilVisibility("V2ProjectPrimaryProfileImageDeleteVerify", 120);
		CommonMethod.WaitUntilVisibility("V2ProjectProfileImageDeleteVerify", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		testlog.pass("**General Information data updated successfully**");
		CommonMethod.WaitUntilVisibility("ProfileTab", 60);
		CommonMethod.RobustclickElementVisible("ProfileTab", "WellHealthSafty");
		CommonMethod.WaitUntilVisibility("WellHealthSafty", 60);
		CommonMethod.RobustclickElementVisible("WellHealthSafty", "V2ProjectYourObjective");
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
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		testlog.pass("**Certification story data updated successfully**");
	}
	public void addLocation(String SheetName, int rowNum, String module) throws Exception {
		CommonMethod.WaitUntilVisibility("ProfileTab", 60);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		CommonMethod.RobustclickElementVisible("AddButton", "AddLocationButton");
		CommonMethod.RobustclickElementVisible("AddLocationButton", "CountryName");
		if (module.equalsIgnoreCase("WPR") || module.equalsIgnoreCase("HSR")) {			
			CommonMethod.sendKeys("LocationName", data.getCellData(SheetName, "LocationName", rowNum));
			CommonMethod.sendKeys("LocationArea", data.getCellData(SheetName, "Area", rowNum));
			CommonMethod.selectdropdownrandom("SpaceType");
			data.setCellData(SheetName, "SpaceTypes", rowNum, CommonMethod.getSelectedDropdownValue("SpaceType"));
			testlog.info("Space type: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
			CommonMethod.selectdropdownrandom("OwnershipType");
			data.setCellData(SheetName, "OwnerType", rowNum, CommonMethod.getSelectedDropdownValue("OwnershipType"));
			testlog.info("Owner type: " + data.getCellData(SheetName, "OwnerType", rowNum));
		} else {
			CommonMethod.sendKeys("PortfolioProjectName", data.getCellData(SheetName, "ProjectName", rowNum));
			CommonMethod.selectdropdownrandom("PortfolioProjectVersion");
			data.setCellData(SheetName, "ProjectVersion", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioProjectVersion"));
			testlog.info("Project Version: " + data.getCellData(SheetName, "ProjectVersion", rowNum));
			CommonMethod.sendKeys("PortfolioProjectArea", data.getCellData(SheetName, "AreaSQFT", rowNum));
			CommonMethod.selectdropdownrandom("PortfolioSpaceType");
			data.setCellData(SheetName, "SpaceTypes", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioSpaceType"));
			testlog.info("Space type: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
			CommonMethod.selectdropdownrandom("PortfolioOwnerType");
			data.setCellData(SheetName, "OwnerType", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerType"));
			testlog.info("Owner type: " + data.getCellData(SheetName, "OwnerType", rowNum));
		}
		CommonMethod.sendKeys("CountryName", data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.sendKeys("StreetName", data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("CityName", data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("PostalCode", data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.click("SubmitButton");

		/*
		 * Validate location added successfully
		 */
		CommonMethod.WaitUntilVisibility("LocationColumn", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("LocationColumn"),
				data.getCellData(SheetName, "LocationName", rowNum), "Well Reviewer value doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("CountryColumn"),
				data.getCellData(SheetName, "Country", rowNum), "Well Reviewer value doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("CityColumn"),
				data.getCellData(SheetName, "City", rowNum), "Well Reviewer value doesn't match");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("StatusColumn"), "PENDING",
				"Well Reviewer value doesn't match");
	}
}


