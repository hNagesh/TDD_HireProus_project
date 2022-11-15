package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodEquity extends BaseClass {

	public void RegisterEquity(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.click("ProjectNavBar");
		CommonMethod.click("WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WERstartNeWERoject", 60);
		CommonMethod.click("WERstartNeWERoject");
		CommonMethod.RobustclickElementVisible("WEREnrollOption", "WERenrollbtn");
		CommonMethod.RobustclickElementVisible("WERenrollbtn", "WEROrgContinebtn");
		String ProjectName = "Automation WER Project" + CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: " + ProjectName);
		data.setCellData(SheetName, "projectName", rowNum, ProjectName);
		CommonMethod.sendKeys("WEROrgName", ProjectName);
		CommonMethod.ClickCheckbox("WEROwnerInfocbx");
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("WERExamOwnerCountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("WERExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WERExamOwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Organization Address: " + ProjectAddress);
		testlog.info("Organization City: " + ProjectCity);
		testlog.info("Organization Postalcode: " + PostalCode);
		CommonMethod.sendKeys("WERExamOrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WERExamOrgCity", ProjectCity);
		CommonMethod.sendKeys("WERExamOrgPostalcode", PostalCode);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("WERExamOwnerCountry"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WERExamOwnerState"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WERExamOrgAddress"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WERExamOrgCity"));
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WERExamOrgPostalcode"));
		CommonMethod.ClickCheckbox("WEROwnercbx");
		CommonMethod.scrollDown();
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

}
