package com.Well.ReusableMethods;

import java.io.IOException;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsExam extends BaseClass {

	public void RegisterExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.click("TrainingNavBar");
		CommonMethod.click("WELLExamRatingNavBar");
		CommonMethod.click("WFExamContinuebtn");
		CommonMethod.selectdropdown("WPRExamOwnerCountry", data.getCellData(SheetName, "country", rowNum));
		CommonMethod.selectdropdown("WPRExamOwnerState", data.getCellData(SheetName, "state", rowNum));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("ProjectAddress" + ProjectAddress);
		testlog.info("ProjectCity" + ProjectCity);
		testlog.info("PostalCode" + PostalCode);
		CommonMethod.sendKeys("WPRExamOrgAddress:", ProjectAddress);
		CommonMethod.sendKeys("WPRExamOrgCity:", ProjectCity);
		CommonMethod.sendKeys("WPRExamOrgPostalcode:", PostalCode);
		CommonMethod.sendKeys("APPhoneNo", "9999999999");
		CommonMethod.click("APRegContinue");
		CommonMethod.WaitUntilVisibility("APJobtitle", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void EnrollExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("APJobtitle", 60);
		String firstName = USfaker.address().firstName();
		testlog.info("firstName:" + firstName);
		CommonMethod.sendKeys("APJobtitle", firstName);
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.selectdropdownIndex("APIndustry", 1);
		CommonMethod.ClickCheckbox("APDesignationscbx");
		CommonMethod.ClickCheckbox("APGender");
		CommonMethod.WaitUntilVisibility("DatePickerButton", 30);
		CommonMethod.click("DatePickerButton");
		CommonMethod.WaitUntilVisibility("APYearDOB", 30);
		CommonMethod.click("APYearDOB");
		CommonMethod.WaitUntilVisibility("APSelctyear", 30);
		CommonMethod.click("APSelctyear");
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 30);
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.click("APJobtitleContinuebtn");
		CommonMethod.selectdropdownIndex("APSelectWELLAP", 1);
		CommonMethod.ClickCheckbox("APPrimaryReason");
		CommonMethod.selectdropdownIndex("APLanguage", 1);
		CommonMethod.ClickCheckbox("APAgree");
		CommonMethod.click("APAlmostContinuebtn");
		CommonMethod.click("APPay");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Enroll Exam successfully**");
	}

	public void BillingExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		v2project.Billing(SheetName, rowNum);
		CommonMethod.WaitUntilVisibility("APStoreExamId", 60);
		testlog.pass("**Completed Card Payment Billing successfully**");
	}

	public void StoreExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("APStoreExamId", 30);
		String getId = CommonMethod.getText("APStoreExamId");
		data.setCellData("Exam", "examId", 2, getId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
	}

	public void CancelExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.click("AdminNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLExamNavBar", 60);
		CommonMethod.click("AdminWELLExamNavBar");
		CommonMethod.WaitUntilClickble("APId", 60).sendKeys(data.getCellData(SheetName, "examId", rowNum));
		CommonMethod.click("APApplybtn");
		CommonMethod.scrolldowntoLast();
		CommonMethod.WaitUntilVisibility("APClickId", 60);
		CommonMethod.click("APClickId");
		CommonMethod.WaitUntilVisibility("APCancelExam", 60);
		CommonMethod.Robustclick("APCancelExam");
		testlog.pass("**Verifies Cancel the Exam successfully**");
	}
}
