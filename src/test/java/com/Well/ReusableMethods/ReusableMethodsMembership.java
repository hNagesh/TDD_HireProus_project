package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethodsMembership extends BaseClass {

	public void RegisterMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("MPUserMenu", 60);
		CommonMethod.click("MPUserMenu");
		CommonMethod.click("MPMyMembership");
		CommonMethod.WaitUntilVisibility("MPMembershipLanding", 60);
		CommonMethod.refreshBrowser();
		CommonMethod.scrolldowntoElement("MPCornerstoneAmount");
		testlog.info("MembershipName:" +MembershipName);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.click("MPCornerstonebtn");
		} else if (MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.click("MPKeystonebtn");
		}
		String firstName = USfaker.address().firstName();
		CommonMethod.sendKeys("MPorganization", firstName);
		data.setCellData("Membership", "Organization", 2, CommonMethod.getattributeValue("MPorganization"));
		CommonMethod.uploadFile("WFProvideUpload", SampleJpgfile);
		CommonMethod.ClickCheckbox("MPNumberofyearsrtn");
		CommonMethod.sendKeys("MPorganizationwebsite", "https://test-nuxt.wellcertified.com/");
		data.setCellData("Membership", "Organizationwebsite", 2, CommonMethod.getattributeValue("MPorganizationwebsite"));
		CommonMethod.WaitUntilVisibility("MPorgcontinuebtn", 30);
		testlog.info("organizationName: "+ data.getCellData(SheetName, "Organization", rowNum));
		testlog.info("organizationwebsite: " +data.getCellData(SheetName, "Organizationwebsite", rowNum));
		CommonMethod.click("MPorgcontinuebtn");
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void EnrollMembership(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Point Contact
		 */
		CommonMethod.WaitUntilVisibility("MPNamePointContact", 30);
		String firstName = USfaker.address().firstName();
		String PhoneNumber = USfaker.number().digits(10);
		String email = USfaker.internet().emailAddress();
		testlog.info("website:" +"https://test-nuxt.wellcertified.com/");
		testlog.info("firstName:" +firstName);
		testlog.info("phonenumber: " +PhoneNumber);
		CommonMethod.sendKeys("MPNamePointContact", firstName);
		data.setCellData("Membership", "Name", 2, CommonMethod.getattributeValue("MPNamePointContact"));
		CommonMethod.sendKeys("MPEmail", email);
		data.setCellData("Membership", "Email", 2, CommonMethod.getattributeValue("MPEmail"));
		CommonMethod.sendKeys("MPJobtitle", "Testing");
		data.setCellData("Membership", "JobTitle", 2, CommonMethod.getattributeValue("MPJobtitle"));
		CommonMethod.sendKeys("MPPhonenumber", PhoneNumber);
		data.setCellData("Membership", "PhoneNumber", 2, CommonMethod.getattributeValue("MPPhonenumber"));
		CommonMethod.ClickCheckbox("MPContactdetailscheckbox");
		testlog.info("Name: " +data.getCellData(SheetName, "Name", rowNum));
		testlog.info("Email: " +data.getCellData(SheetName, "Email", rowNum));
		testlog.info("JobTitle: " +data.getCellData(SheetName, "JobTitle", rowNum));
		CommonMethod.click("MPContinuebutton");
		/*
		 * Owner details
		 */
		CommonMethod.WaitUntilVisibility("MPOwnername", 30);
		CommonMethod.sendKeys("MPOwnername", firstName);
		data.setCellData("Membership", "Name", 2, CommonMethod.getattributeValue("MPOwnername"));
		CommonMethod.sendKeys("MPOwnerEmail", email);
		data.setCellData("Membership", "Email", 2, CommonMethod.getattributeValue("MPOwnerEmail"));
		testlog.info("Ownerjob:" +"Testing");
		CommonMethod.sendKeys("MPOwnerjob", "Testing");
		data.setCellData("Membership", "JobTitle", 2, CommonMethod.getattributeValue("MPOwnerjob"));
		CommonMethod.sendKeys("MPOwnernumber", PhoneNumber);
		data.setCellData("Membership", "PhoneNumber", 2, CommonMethod.getattributeValue("MPOwnernumber"));
		CommonMethod.click("MPMembershipOwnerContinue");
		/*
		 * Office Address
		 */
		CommonMethod.WaitUntilVisibility("MPOfficecountry", 30);
		CommonMethod.selectdropdownVisibletext("MPOfficecountry", "United States");
		data.setCellData("Membership", "Country", 2, CommonMethod.getSelectedDropdownValue("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("MPOfficestate");
		data.setCellData("Membership", "State", 2, CommonMethod.getSelectedDropdownValue("MPOfficestate"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("MPOfficestreet", ProjectAddress);
		data.setCellData("Membership", "Street", 2, CommonMethod.getattributeValue("MPOfficestreet"));
		CommonMethod.sendKeys("MPOfficecity", ProjectCity);
		data.setCellData("Membership", "City", 2, CommonMethod.getattributeValue("MPOfficecity"));
		CommonMethod.sendKeys("MPOfficePostalCode", PostalCode);
		data.setCellData("Membership", "PostalCode", 2, CommonMethod.getattributeValue("MPOfficePostalCode"));
		testlog.info("Country: " +data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " +data.getCellData(SheetName, "State", rowNum));
		testlog.info("Street: " +data.getCellData(SheetName, "Street", rowNum));
		testlog.info("PostalCode: " +data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.click("MPOfficecontinuebtn");
		/*
		 * Term
		 */
		CommonMethod.WaitUntilVisibility("MPTermscheckbox", 30);
		CommonMethod.ClickCheckbox("MPTermscheckbox");
		CommonMethod.scrolldowntoElement("MPProcedtopaymentbtn");
		CommonMethod.click("MPProcedtopaymentbtn");
		CommonMethod.WaitUntilVisibility("MPTermscheckbox", 30);
		CommonMethod.click("MPProcedtoConfirmationPaymentbtn");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies Enrollment successfully**");
	}

	public void BillingMembership(String SheetName, int rowNum, String MembershipName) throws IOException, InterruptedException {
		v2project.Billing(SheetName, rowNum);
		testlog.info("MembershipName:" +MembershipName);
		CommonMethod.WaitUntilVisibility("MPValidMembershipeType", 60);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.assertcontainsmessage("MPValidMembershipeType", "CORNERSTONE MEMBERSHIP", "Verified Cornerstone Membership Name");
		}
		testlog.pass("**Verified Membership Name successfully**");
	}

}