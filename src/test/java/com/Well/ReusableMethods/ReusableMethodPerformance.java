package com.Well.ReusableMethods;

import java.io.IOException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodPerformance extends BaseClass {
	
	public void RegisterPerformance(String SheetName,int rowNum) throws IOException, InterruptedException {

	   CommonMethod.click("ProjectNavBar");
	   CommonMethod.click("WELLPerformanceRatingNavBar");
	   CommonMethod.click("WPRstartNewProject");
	   CommonMethod.click("WPREnrollOption");
	   CommonMethod.click("WPRenrollbtn");
	   String ProjectName = "Automation Project"+CommonMethod.randomNumber(8000000);
	   data.setCellData("Wpr", "projectName", 2, ProjectName);
	   CommonMethod.sendKeys("WPROrgName", ProjectName);
	   CommonMethod.ClickCheckbox("WPROwnerInfocbx");  
	   CommonMethod.click("OwnerOrgClick");
	   CommonMethod.sendKeys("OwnerOrg", "R");
	   CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
	   CommonMethod.click("SelectOwnerOrg");
	   CommonMethod.selectdropdownrandom("OrgIndustry");
	   CommonMethod.selectdropdown("WPROwnerCountry",  data.getCellData(SheetName, "country", rowNum));
	   CommonMethod.selectdropdown("WPROwnerState",  data.getCellData(SheetName, "state", rowNum));
	   String ProjectAddress = USfaker.address().streetAddress();
	   String ProjectCity = USfaker.address().cityName();
	   String PostalCode = USfaker.address().zipCode();
	   CommonMethod.sendKeys("WPROrgAddress", ProjectAddress);
       CommonMethod.sendKeys("WPROrgCity", ProjectCity);
       CommonMethod.sendKeys("WPROrgPostalcode", PostalCode);
       CommonMethod.ClickCheckbox("WPROwnercbx"); 
       CommonMethod.scrollDown();
       CommonMethod.click("WPROrgContinebtn");
       Thread.sleep(2000);
       CommonMethod.scrollUp();
       CommonMethod.ClickCheckbox("WPRBehalfCbx");
       CommonMethod.selectdropdown("WPRSelectMember",  "No");
       CommonMethod.click("WPROwnerRegContinuebtn");
       Thread.sleep(2000);
       CommonMethod.scrollUp();
       CommonMethod.sendKeys("WPRlocations", "10");
       CommonMethod.click("HsrlocationsSpacetype");
       CommonMethod.click("HsrlocationsSpaceOption");
       Thread.sleep(1000);
       CommonMethod.scrollDown();
       CommonMethod.clear("WPRlocationsize");
       CommonMethod.sendKeys("WPRlocationsize", "100");
       CommonMethod.WaitUntilClickble("WPROwnerRegContinuebtn", 60);
	   CommonMethod.click("WPROwnerRegContinuebtn");
	   CommonMethod.WaitUntilClickble("HsrYesMyOrganizationCbx", 30);
	   CommonMethod.ClickCheckbox("HsrYesMyOrganizationCbx");
	   CommonMethod.click("WPRReviewContinuebutton");
	   CommonMethod.WaitUntilClickble("WPRProgramFeePublicrbtn", 60);
	   CommonMethod.ClickCheckbox("WPRProgramFeePublicrbtn");
	   CommonMethod.scrollDown();
	   CommonMethod.WaitUntilClickble("WPRAcknowledecbx", 60);
	   CommonMethod.ClickCheckbox("WPRAcknowledecbx");
	   CommonMethod.click("WPRtermContinuebutton");
	}
	
	
	
	

}

