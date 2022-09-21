package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethodsExam extends BaseClass {

	public void RegisterExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.click("TrainingNavBar");
		CommonMethod.click("WELLExamRatingNavBar");
		CommonMethod.click("WFContinuebtn");
		CommonMethod.selectdropdown("WPROwnerCountry", data.getCellData(SheetName, "country", rowNum));
		CommonMethod.selectdropdown("WPROwnerState", data.getCellData(SheetName, "state", rowNum));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("WPROrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WPROrgCity", ProjectCity);
		CommonMethod.sendKeys("WPROrgPostalcode", PostalCode);
		CommonMethod.sendKeys("APPhoneNo", "9999999999");
		CommonMethod.click("APRegContinue");
		CommonMethod.WaitUntilVisibility("APJobtitle", 60);
	}

	public void EnrollExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("APJobtitle", 60);
		String firstName = USfaker.address().firstName();
		CommonMethod.sendKeys("APJobtitle", firstName);
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
		CommonMethod.selectdropdownIndex("APIndustry", 1);
		CommonMethod.ClickCheckbox("APDesignationscbx");
		CommonMethod.ClickCheckbox("APGender");
		CommonMethod.WaitUntilVisibility("V2ProjectdocsubUpdatebtn", 30);
		CommonMethod.click("V2ProjectdocsubUpdatebtn");
		CommonMethod.WaitUntilVisibility("APYearDOB", 30);
		CommonMethod.click("APYearDOB");
		CommonMethod.WaitUntilVisibility("APSelctyear", 30);
		CommonMethod.click("APSelctyear");
		Thread.sleep(1000);
		CommonMethod.WaitUntilVisibility("V2ProjectdocsubOkbtn", 30);
		CommonMethod.click("V2ProjectdocsubOkbtn");
		CommonMethod.click("V2ProjectdocsubOkbtn");
		CommonMethod.click("APJobtitleContinuebtn");
		CommonMethod.selectdropdownIndex("APSelectWELLAP", 1);
		CommonMethod.ClickCheckbox("APPrimaryReason");
		CommonMethod.selectdropdownIndex("APLanguage", 1);
		CommonMethod.ClickCheckbox("APAgree");
		CommonMethod.click("APAlmostContinuebtn");
		CommonMethod.click("APPay");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		
	}
	public void BillingExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("BillingLanding", 30);
		v2project.Billing(SheetName, rowNum);	
		CommonMethod.WaitUntilVisibility("APStoreExamId", 60);
	}
	public void StoreExam(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("APStoreExamId", 30);
		String getId = CommonMethod.getText("APStoreExamId");
		data.setCellData("Exam", "examId", 2, getId);
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
	}
}
	