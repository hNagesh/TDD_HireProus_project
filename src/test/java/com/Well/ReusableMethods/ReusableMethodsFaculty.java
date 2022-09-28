package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethodsFaculty extends BaseClass {
	static String username;
	static String admin_Header;

	public void RegisterFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.click("TrainingNavBar");
		CommonMethod.click("WELLFacultyNavBar");
		CommonMethod.WaitUntilVisibility("WFExamContinuebtn", 30);
		CommonMethod.click("WFExamContinuebtn");
		CommonMethod.WaitUntilVisibility("WPRExamOwnerCountry", 60);
		CommonMethod.selectdropdown("WPRExamOwnerCountry", "United States");
		data.setCellData("Faculty", "Country", 2, CommonMethod.getattributeValue("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		data.setCellData("Faculty", "State", 2, CommonMethod.getattributeValue("WPRExamOwnerState"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("ProjectAddress"+ProjectAddress);
		testlog.info("ProjectCity"+ProjectCity);
		testlog.info("PostalCode"+PostalCode);
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		data.setCellData("Faculty", "Street", 2, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		data.setCellData("Faculty", "City", 2, CommonMethod.getattributeValue("WPRExamOrgCity"));
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData("Faculty", "PostalCode", 2, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		CommonMethod.sendKeys("WFEmp", "FullTime");
		data.setCellData("Faculty", "WFEmp", 2, CommonMethod.getattributeValue("WFEmp"));
		CommonMethod.sendKeys("WFPostion", "Testing");
		CommonMethod.click("OwnerOrgClick");
		data.setCellData("Faculty", "WFPostion", 2, CommonMethod.getattributeValue("WFPostion"));
		testlog.info("Language"+"English");
		CommonMethod.sendKeys("OwnerOrg", "English");
		data.setCellData("Faculty", "Communication", 2, CommonMethod.getattributeValue("OwnerOrg"));
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 6).click();
		data.setCellData("Faculty", "Org", 2, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " +data.getCellData(SheetName, "Org", rowNum));
		CommonMethod.uploadFile("WFCvUpload", SamplePdffile);
		CommonMethod.ClickCheckbox("WFUsgbcFacultyrbtn");
		CommonMethod.ClickCheckbox("WFCredentialsrbtn");
		CommonMethod.ClickCheckbox("WFMigration");
		CommonMethod.ClickCheckbox("WFAdvisor");
		CommonMethod.ClickCheckbox("WFPartmemberOrg");
		CommonMethod.ClickCheckbox("WFLeedFaculty");
		CommonMethod.scrolldowntoElement("WFLeedFaculty");
		CommonMethod.WaitUntilVisibility("WFAddrContinuebtn", 30);
		CommonMethod.click("WFAddrContinuebtn");
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void AgreementFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		String sampleText = "WELL Faculty Application";
		CommonMethod.sendKeys("WFFacilitation", sampleText);
		data.setCellData("Faculty", "WFFacilitation", 2, CommonMethod.getattributeValue("WFFacilitation"));
		CommonMethod.uploadFile("WFProvideUpload", SamplePdffile);
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile);
		Thread.sleep(1000);
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile1);
		CommonMethod.uploadFile("WFSurveyUpload", SamplePdffile);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WFExp", sampleText);
		data.setCellData("Faculty", "WFExp", 2, CommonMethod.getattributeValue("WFExp"));
		CommonMethod.sendKeys("WFTravel", sampleText);
		data.setCellData("Faculty", "WFTravel", 2, CommonMethod.getattributeValue("WFTravel"));
		CommonMethod.ClickCheckbox("WFTermcbx");
		CommonMethod.scrolldowntoElement("WFTermcbx");
		CommonMethod.WaitUntilVisibility("WFAddrContinuebtn", 60);
		Thread.sleep(1000);
		CommonMethod.click("WFAddrContinuebtn");
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		testlog.pass("**Verifies the Agreement Faculty successfully**");
	}

	public void SubmitReviewFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		CommonMethod.WaitUntilVisibility("WFStatus", 60);
		CommonMethod.ClickCheckbox("WFStatus");
		CommonMethod.click("WFApprovedDate");
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 10);
		CommonMethod.click("DatePickerOkButton");
		Thread.sleep(1000);
		String FirstName = USfaker.address().firstName();
		testlog.info("firstName"+FirstName);
		CommonMethod.sendKeys("WFApproved", FirstName);
		data.setCellData("Faculty", "WFApproved", 2, CommonMethod.getattributeValue("WFApproved"));
		CommonMethod.WaitUntilVisibility("WFExpireDate", 10);
		CommonMethod.click("WFExpireDate");
		CommonMethod.click("DatePickerOkButton");
		String sampleText = "WELL Faculty Application";
		CommonMethod.sendKeys("WFReasonnarration", sampleText);
		CommonMethod.sendKeys("WFRegion", sampleText);
		CommonMethod.sendKeys("WFSource", sampleText);
		CommonMethod.ClickCheckbox("WFTeachingcbx");
		CommonMethod.sendKeys("WFWillingness", sampleText);
		CommonMethod.ClickCheckbox("WFTechrbn");
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("WFBusinessrbn");
		CommonMethod.ClickCheckbox("WFRedflagrbn");
		CommonMethod.ClickCheckbox("WFWorkshops");
		CommonMethod.click("WFNextDate");
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.uploadFile("WFProvideUpload", SamplePdffile);
		CommonMethod.sendKeys("WFAdminNote3narration", sampleText);
		CommonMethod.sendKeys("WFAdminNote2narration", sampleText);
		CommonMethod.sendKeys("WFAdminnarration", sampleText);
		CommonMethod.sendKeys("WFNextnarration", sampleText);
		CommonMethod.WaitUntilClickble("WFEventsnarration", 60).sendKeys(sampleText);
		CommonMethod.sendKeys("WFTeachingnarration", sampleText);
		CommonMethod.click("WFExamContinuebtn");
		CommonMethod.WaitUntilVisibility("WFSubmitApplicationbtn", 60);
		CommonMethod.RobustclickElementVisible("WFSubmitApplicationbtn","WFReturnbtn");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("WFReturnbtn", 60);
		testlog.pass("**Verifies Submitted Review successfully**");
		
	}

	@SuppressWarnings("unchecked")
	public static Response PostRequestAuthenticate() {
		/*
		 * Get Token by authentication
		 */
		username = data.getCellData("Login", "UserName", 3);
		JSONObject param = new JSONObject();
		param.put("email", username);
		param.put("password", "initpass");

		Response res = given().accept("application/json").contentType("application/json").body(param).when()
				.post("https://test-v2-api.wellcertified.com/api/authenticate");
		admin_Header = (res.path("token")).toString();
		admin_Header = "Bearer " + admin_Header;
		return res;
	}

	public static Response DeleteFacultyOrMembership() {

		/*
		 * Delete Faculty/Membership using Token
		 */
		Response res = given().contentType("application/json").header("Authorization", admin_Header).when()
				.delete("https://test-v2-api.wellcertified.com/api/admin/qa/automation/bulk-delete/" + username);
		return res;
		
	}
}