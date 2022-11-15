package com.Well.ReusableMethods;

import java.io.IOException;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodEquity extends BaseClass {

	public void RegisterEquity(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERstartNewProject");
		CommonMethod.WaitUntilVisibility("WERstartNewProject", 60);
		CommonMethod.RobustclickElementVisible("WERstartNewProject","WEREnrollOption");
		CommonMethod.RobustclickElementVisible("WEREnrollOption", "WERenrollbtn");
		CommonMethod.RobustclickElementVisible("WERenrollbtn", "WEROrgContinebtn");
		String ProjectName = "Automation WER Project" + CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: " + ProjectName);
		data.setCellData(SheetName, "projectName", rowNum, ProjectName);
		CommonMethod.WaitUntilPresence("WEREnrollName",60);
		CommonMethod.sendKeys("WEREnrollName", ProjectName);
		CommonMethod.ClickCheckbox("WEROwnerInfocbx");
		String OwnerName = USfaker.address().firstName();
		CommonMethod.sendKeys("WEROrgName", OwnerName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("WEROwnerCountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("WEROwnerCountry"));
		CommonMethod.selectdropdownrandom("WEROwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Organization Address: " + ProjectAddress);
		testlog.info("Organization City: " + ProjectCity);
		testlog.info("Organization Postalcode: " + PostalCode);
		CommonMethod.sendKeys("WEROrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WEROrgCity", ProjectCity);
		CommonMethod.sendKeys("WEROrgPostalcode", PostalCode);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("WEROwnerCountry"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WEROwnerState"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WEROrgAddress"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WEROrgCity"));
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WEROrgPostalcode"));
		CommonMethod.ClickCheckbox("WEROwnercbx");
		CommonMethod.scrolldowntoElement("WEROwnercbx");
		CommonMethod.WaitUntilPresence("WEROrgContinebtn",60);
		CommonMethod.RobustclickElementVisible("WEROrgContinebtn", "WEROwnerRegContinuebtn");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.ClickCheckbox("WERBehalfCbx");
		CommonMethod.selectdropdownVisibletext("WERSelectMember", "No");
		data.setCellData(SheetName, "WERSelectMember", rowNum,
				CommonMethod.getSelectedDropdownValue("WERSelectMember"));
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn","WERlocations");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("WERlocations", "10");
		data.setCellData(SheetName, "WERlocations", rowNum, CommonMethod.getattributeValue("WERlocations"));
		CommonMethod.click("WERlocationsSpacetype");
		CommonMethod.click("WERlocationsSpaceOption");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		testlog.info("Locationsize: " + Area);
		CommonMethod.clearAndSendKey("WERlocationsize", Area);
		data.setCellData(SheetName, "WERlocationsize", rowNum, CommonMethod.getattributeValue("WERlocationsize"));
		CommonMethod.WaitUntilClickble("WEROwnerRegContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn", "WERReviewContinuebutton");
		if (CommonMethod.isElementsExist("WERYesMyOrganizationCbx", 2)) {
			CommonMethod.WaitUntilClickble("WERYesMyOrganizationCbx", 30);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
		}
		CommonMethod.RobustclickElementVisible("WERReviewContinuebutton", "WERtermContinuebutton");
		if (CommonMethod.isElementsExist("WERProgramFeePublicrbtn", 20)) {
			CommonMethod.WaitUntilClickble("WERProgramFeePublicrbtn", 60);
			CommonMethod.ClickCheckbox("WERProgramFeePublicrbtn");
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilClickble("WERAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("WERAcknowledecbx");
		CommonMethod.RobustclickElementVisible("WERtermContinuebutton", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdEquity(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("WPRHsrPortfolioDashboard", 180);
		CommonMethod.WaitUntilVisibility("StoreId", 30);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getWprId = stringArray[1].trim();
		testlog.info("Equity Id: " + getWprId);
		data.setCellData(SheetName, "ProjectID", rowNum, getWprId);
		testlog.info("Equity ID: " + getWprId);
		testlog.pass("**Stored the Registered id  into excel successfully**");
	}
}
