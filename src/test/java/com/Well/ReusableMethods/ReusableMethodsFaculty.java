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
		CommonMethod.WaitUntilVisibility("WFContinuebtn", 30);
		CommonMethod.click("WFContinuebtn");
		CommonMethod.WaitUntilVisibility("WPROwnerCountry", 60);
		CommonMethod.selectdropdown("WPROwnerCountry", data.getCellData(SheetName, "country", rowNum));
		CommonMethod.selectdropdown("WPROwnerState", data.getCellData(SheetName, "state", rowNum));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("WPROrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WPROrgCity", ProjectCity);
		CommonMethod.sendKeys("WPROrgPostalcode", PostalCode);
		CommonMethod.sendKeys("WFEmp", ProjectCity);
		CommonMethod.sendKeys("WFPostion", PostalCode);
		CommonMethod.click("OwnerOrgClick");
		CommonMethod.sendKeys("OwnerOrg", "English");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.click("SelectOwnerOrg");
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
	}

	public void AgreementFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		String sampleText = "WELL Faculty Application";
		CommonMethod.sendKeys("WFFacilitation", sampleText);
		CommonMethod.uploadFile("WFProvideUpload", SamplePdffile);
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile);
		Thread.sleep(1000);
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile1);
		CommonMethod.uploadFile("WFSurveyUpload", SamplePdffile);
		Thread.sleep(2000);
		CommonMethod.sendKeys("WFExp", sampleText);
		CommonMethod.sendKeys("WFTravel", sampleText);
		CommonMethod.ClickCheckbox("WFTermcbx");
		CommonMethod.scrolldowntoElement("WFTermcbx");
		CommonMethod.WaitUntilVisibility("WFAddrContinuebtn", 60);
		Thread.sleep(1000);
		CommonMethod.click("WFAddrContinuebtn");

	}

	public void SubmitReviewFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {

		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		CommonMethod.WaitUntilVisibility("WFStatus", 60);
		CommonMethod.ClickCheckbox("WFStatus");
		CommonMethod.click("WFApprovedDate");
		CommonMethod.WaitUntilVisibility("V2ProjectdocsubOkbtn", 10);
		CommonMethod.click("V2ProjectdocsubOkbtn");
		Thread.sleep(1000);
		String FirstName = USfaker.address().firstName();
		CommonMethod.sendKeys("WFApproved", FirstName);
		CommonMethod.WaitUntilVisibility("WFExpireDate", 10);
		CommonMethod.click("WFExpireDate");
		CommonMethod.click("V2ProjectdocsubOkbtn");
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
		CommonMethod.click("V2ProjectdocsubOkbtn");
		CommonMethod.uploadFile("WFProvideUpload", SamplePdffile);
		CommonMethod.sendKeys("WFAdminNote3narration", sampleText);
		CommonMethod.sendKeys("WFAdminNote2narration", sampleText);
		CommonMethod.sendKeys("WFAdminnarration", sampleText);
		CommonMethod.sendKeys("WFNextnarration", sampleText);
		CommonMethod.WaitUntilClickble("WFEventsnarration", 60).sendKeys(sampleText);
		CommonMethod.sendKeys("WFTeachingnarration", sampleText);
		CommonMethod.click("WFContinuebtn");
		CommonMethod.WaitUntilVisibility("WFSubmitApplicationbtn", 60);
		CommonMethod.RobustclickElementVisible("WFSubmitApplicationbtn","WFReturnbtn");
		Thread.sleep(2000);
		
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
		System.out.println("###" + admin_Header);
		return res;
	}

	public static Response DeleteFacultyOrMembership() {

		/*
		 * Delete Faculty/Membership using Token
		 */
		Response res = given().contentType("application/json").header("Authorization", admin_Header).when()
				.delete("https://test-v2-api.wellcertified.com/api/admin/qa/automation/bulk-delete/" + username);
		System.out.println(res.toString());
		return res;
	}
}