package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class ReusableMethodsFaculty extends BaseClass {
	
	public void RegisterFaculty(String SheetName,int rowNum) throws IOException, InterruptedException {

		   CommonMethod.click("TrainingNavBar");
		   CommonMethod.click("WELLFacultyNavBar");
		   CommonMethod.click("WFContinuebtn");
		   CommonMethod.selectdropdown("WPROwnerCountry",  data.getCellData(SheetName, "country", rowNum));
		   CommonMethod.selectdropdown("WPROwnerState",  data.getCellData(SheetName, "state", rowNum));
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
		   CommonMethod.click("WFAddrContinuebtn");
		   CommonMethod.ClickCheckbox("WFTermcbx");
		   CommonMethod.click("WFAddrContinuebtn");
		   CommonMethod.sendKeys("WFFacilitation", PostalCode);
		   CommonMethod.uploadFile("WFProvideUpload", SamplePdffile);
		   CommonMethod.uploadFile("WFClientUpload", SamplePdffile);
		   CommonMethod.uploadFile("WFClientUpload", SamplePdffile);
		   CommonMethod.uploadFile("WFSurveyUpload", SamplePdffile);
		   CommonMethod.sendKeys("WFExp", PostalCode);
		   CommonMethod.sendKeys("WFTravel", PostalCode);
		   CommonMethod.click("WFAddrContinuebtn");
	}
	@SuppressWarnings("unchecked")
	public static Response POSTRequest() {
		
		JSONObject param = new JSONObject();
		param.put("email", "welluiautomationtesting@gmail.com");
		param.put("password", "initpass");
		
		Response res = given().accept("application/json").contentType("application/json")
				.body(param).when().post("https://test-v2-api.wellcertified.com/api/authenticate");
		String header = (res.path("token")).toString();
		header = "Bearer " + header;
		System.out.println(header);
		return res;
	}
}
