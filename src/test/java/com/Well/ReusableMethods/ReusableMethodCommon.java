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
}


