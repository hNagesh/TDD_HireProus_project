package com.Well.ReusableMethods;

import java.io.IOException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodCommon extends BaseClass {
	
	public void SelectCountryAndState(String Country,String SheetName,int rowNum) throws IOException, InterruptedException {

		CommonMethod.selectdropdownVisibletext("V2ProjectlocationCountry", Country);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("ProjectlocationCountry"));
		CommonMethod.selectdropdownrandom("V2ProjectlocationState");
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
	data.setCellData(SheetName, "OrgName", 2, CommonMethod.getText("OrgName"));
	testlog.info("OrganizationName: " + data.getCellData(SheetName, "Org", rowNum));
	
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
		CommonMethod.sendKeys("CardHolderNumber", "4111111111111111");
		data.setCellData(SheetName, "CardHolderNumber", rowNum, CommonMethod.getattributeValue("CardHolderNumber"));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardExpDateIframe");
		testlog.info("CardHolderExpDate:" + "0925");
		CommonMethod.WaitUntilClickble("CardHolderExpDate", 60).sendKeys("0");
		CommonMethod.sendKeys("CardHolderExpDate", "9");
		CommonMethod.sendKeys("CardHolderExpDate", "2");
		CommonMethod.sendKeys("CardHolderExpDate", "5");
		data.setCellData(SheetName, "CardHolderExpDate", rowNum, CommonMethod.getattributeValue("CardHolderExpDate"));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardCVVIframe");
		CommonMethod.WaitUntilClickble("CardHolderCVC", 60);
		testlog.info("CardHolderCVC:" + "999");
		CommonMethod.sendKeys("CardHolderCVC", "999");
		data.setCellData(SheetName, "CardHolderCVC", rowNum, CommonMethod.getattributeValue("CardHolderCVC"));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("PayNowButton", 10);
		CommonMethod.click("PayNowButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilInVisibility("CardHolderName", 180);
		testlog.pass("**Verifies the Completed Card Payment Billing successfully**");
	}
}


